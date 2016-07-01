/**
 * Copyright 2016 Linagora, Université Joseph Fourier, Floralis
 *
 * The present code is developed in the scope of the joint LINAGORA -
 * Université Joseph Fourier - Floralis research program and is designated
 * as a "Result" pursuant to the terms and conditions of the LINAGORA
 * - Université Joseph Fourier - Floralis research program. Each copyright
 * holder of Results enumerated here above fully & independently holds complete
 * ownership of the complete Intellectual Property rights applicable to the whole
 * of said Results, and may freely exploit it in any manner which does not infringe
 * the moral rights of the other copyright holders.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.roboconf.eclipse.modeler.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.modeler.commands.EditExportedVariableCommand;
import net.roboconf.eclipse.modeler.commands.ManageImportedVariableCommand;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;

/**
 * The Eclipse view to display Roboconf variables.
 * @author Vincent Zurczak - Linagora
 */
public class VariablesView extends ViewPart implements ISelectionListener {

	public static final String VIEW_ID = "net.roboconf.eclipse.modeler.views.variablesView";

	public static final String IMPORTED = "Imported Variables";
	private static final String EXPORTED = "Exported Variables";
	private static final String NO_EXPORTS = "No exported variable";
	private static final String NO_IMPORTS = "No imported variable";

	private TreeViewer viewer;



	@Override
	public void createPartControl( Composite parent ) {

		// Create the viewer
		this.viewer = new TreeViewer( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		this.viewer.setContentProvider( new VariablesTreeContentProvider());
		this.viewer.setLabelProvider( new VariablesLabelProvider());

		getSite().getPage().addSelectionListener( this );
		getSite().setSelectionProvider( this.viewer );

		// Handle double-clicks
		this.viewer.addDoubleClickListener( new IDoubleClickListener() {
			@Override
			public void doubleClick( DoubleClickEvent event ) {

				try {
					Object o = ((IStructuredSelection) event.getSelection()).getFirstElement();
					if( o instanceof RoboconfExportedVariable ) {
						EditExportedVariableCommand cmd = new EditExportedVariableCommand((RoboconfExportedVariable) o);
						cmd.execute( null );

					} else if( o instanceof RoboconfImportedVariable ) {
						RoboconfComponent owner = (RoboconfComponent) ((RoboconfImportedVariable) o).eContainer();
						ManageImportedVariableCommand cmd = new ManageImportedVariableCommand( owner );
						cmd.execute( null );
					}

				} catch( ExecutionException e ) {
					RoboconfModelerPlugin.log( e, IStatus.ERROR );
				}
			}
		});
	}


	@Override
	public void setFocus() {
		this.viewer.getControl().setFocus();
	}


	@Override
	public void selectionChanged( IWorkbenchPart part, ISelection selection ) {

		// Handle editor selection
		EObject eo = EclipseUtils.findEObjectFromSelection( selection );
		if( this.viewer != null
				&& ! this.viewer.getTree().isDisposed()
				&& eo instanceof RoboconfFacet ) {

			this.viewer.setInput( eo );
			this.viewer.refresh();
			this.viewer.expandAll();
		}

		// Filter other selections (ignore exports and imports)
		else if( eo != null
				&& !( eo instanceof RoboconfImportedVariable )
				&& !( eo instanceof RoboconfExportedVariable ))  {

			this.viewer.setInput( eo );
			this.viewer.refresh();
		}
	}


	/**
	 * A static method to update an element in the view.
	 * <p>
	 * This is a dirty workaround since EContentAdapters seem to ignore
	 * some model modifications. :/
	 * </p>
	 *
	 * @param eo an EMF object
	 * @param selection the object to select (can be null)
	 */
	public static void refreshElement( final EObject eo, final Object selection ) {

		final IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if( part instanceof VariablesView ) {

			// Verify the object and the displayed graph have the same origin
			Object input = ((VariablesView) part).viewer.getInput();
			if( input instanceof EObject
					&& Objects.equals( eo.eResource(), ((EObject) input).eResource())) {

				// Refresh the object
				Display.getDefault().asyncExec( new Runnable() {
					@Override
					public void run() {
						((VariablesView) part).viewer.refresh( eo );
						if( selection != null )
							((VariablesView) part).viewer.setSelection( new StructuredSelection( selection ));
					}
				});
			}
		}
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class VariablesTreeContentProvider implements ITreeContentProvider {

		private final Object root = new Object();
		private EObject input;


		@Override
		public void dispose() {
			// nothing
		}


		@Override
		public void inputChanged( Viewer viewer, Object oldInput, Object newInput ) {
			this.input = newInput instanceof EObject ? (EObject) newInput : null;
		}


		@Override
		public Object[] getElements( Object inputElement ) {

			Object[] result = new Object[ 0 ];
			if( this.input instanceof RoboconfComponent )
				result = new String[] { EXPORTED, IMPORTED };
			else if( this.input instanceof RoboconfFacet )
				result = new String[] { EXPORTED };

			return result;
		}


		@Override
		public Object[] getChildren( Object parentElement ) {

			List<Object> result = new ArrayList<> ();
			if( Objects.equals( parentElement, EXPORTED )) {
				for( RoboconfExportedVariable var : ((RoboconfFacet) this.input).getExports())
					result.add( var );

				if( result.isEmpty())
					result.add( NO_EXPORTS );

			} else if( Objects.equals( parentElement, IMPORTED )) {
				for( RoboconfImportedVariable var : ((RoboconfComponent) this.input).getImports())
					result.add( var );

				if( result.isEmpty())
					result.add( NO_IMPORTS );
			}

			return result.toArray( new Object[ result.size()]);
		}


		@Override
		public Object getParent( Object element ) {

			return element instanceof RoboconfExportedVariable
					? EXPORTED : element instanceof RoboconfImportedVariable
					? IMPORTED : element instanceof String
					? this.root : null;
		}


		@Override
		public boolean hasChildren( Object element ) {

			// Both components and facets are... facets.
			boolean hasChildren = element instanceof RoboconfFacet;
			if( ! hasChildren && element instanceof String )
				hasChildren = Objects.equals( element, EXPORTED ) || Objects.equals( element, IMPORTED );

			return hasChildren;
		}
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class VariablesLabelProvider extends LabelProvider {

		private static final String SEP = "   ";
		private final Image listImg, varImg;


		/**
		 * Constructor.
		 */
		public VariablesLabelProvider() {
			this.listImg = RoboconfModelerPlugin.findImage( "icons/16x16/list_16x16.gif" );
			this.varImg = RoboconfModelerPlugin.findImage( "icons/16x16/task_16x16.gif" );
		}


		@Override
		public void dispose() {

			EclipseUtils.dispose( this.listImg );
			EclipseUtils.dispose( this.varImg );

			super.dispose();
		}


		@Override
		public String getText( Object element ) {

			String text = "";
			if( element instanceof String ) {
				text = (String) element;
			}

			// Imported variable
			else if( element instanceof RoboconfImportedVariable ) {
				RoboconfImportedVariable var = (RoboconfImportedVariable) element;
				StringBuilder sb = new StringBuilder();
				sb.append( var.getName());

				if( var.isExternal()) {
					sb.append( this.SEP );
					sb.append( "(external" );
					if( var.isOptional())
						sb.append( ", optional)" );

				} else if( var.isOptional()) {
					sb.append( this.SEP );
					sb.append( " (optional)" );
				}

				text = sb.toString();
			}

			// Exported variable
			else if( element instanceof RoboconfExportedVariable ) {
				RoboconfExportedVariable var = (RoboconfExportedVariable) element;
				StringBuilder sb = new StringBuilder();
				sb.append( var.getName());

				if( ! Utils.isEmptyOrWhitespaces( var.getDefaultValue())) {
					sb.append( " = " );
					sb.append( var.getDefaultValue());
				}

				if( ! Utils.isEmptyOrWhitespaces( var.getExternalAlias())) {
					sb.append( this.SEP );
					sb.append( "(alias for external applications: " );
					sb.append( var.getExternalAlias());
					sb.append( ")" );
				}

				text = sb.toString();
			}

			return text;
		}


		@Override
		public Image getImage( Object element ) {

			Image result = this.varImg;
			if( IMPORTED.equalsIgnoreCase( String.valueOf( element ))
					|| EXPORTED.equalsIgnoreCase( String.valueOf( element )))
				result = this.listImg;

			else if( element instanceof String )
				result = null;

			return result;
		}
	}
}
