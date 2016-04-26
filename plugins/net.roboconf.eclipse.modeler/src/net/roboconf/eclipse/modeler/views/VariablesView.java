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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.occiware.clouddesigner.occi.Link;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import roboconfgraph.RoboconfComponent;
import roboconfgraph.RoboconfExportedVariable;
import roboconfgraph.RoboconfFacet;
import roboconfgraph.RoboconfImportedVariable;
import roboconfgraph.RoboconfOwnerLink;

/**
 * @author Vincent Zurczak - Linagora
 */
public class VariablesView extends ViewPart implements ISelectionListener {

	private static final String EXPORTED = "Exported Variables";
	private static final String IMPORTED = "Imported Variables";
	private TreeViewer viewer;


	@Override
	public void createPartControl( Composite parent ) {
		this.viewer = new TreeViewer( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		this.viewer.setContentProvider( new VariablesTreeContentProvider());
		this.viewer.setLabelProvider( new VariablesLabelProvider());

		getSite().getPage().addSelectionListener( this );
	}


	@Override
	public void setFocus() {
		this.viewer.getControl().setFocus();
	}


	@Override
	public void selectionChanged( IWorkbenchPart part, ISelection selection ) {

		EObject eo = EclipseUtils.findEObjectFromSelection( selection );
		if( this.viewer != null
				&& ! this.viewer.getTree().isDisposed()) {
			this.viewer.setInput( eo );
			this.viewer.refresh();
			this.viewer.expandAll();
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
				for( Link link : ((RoboconfComponent) this.input).getLinks()) {
					if( link instanceof RoboconfOwnerLink
							&& link.getTarget() instanceof RoboconfExportedVariable )
						result.add( link.getTarget());
				}

			} else if( Objects.equals( parentElement, IMPORTED )) {
				for( Link link : ((RoboconfComponent) this.input).getLinks()) {
					if( link instanceof RoboconfOwnerLink
							&& link.getTarget() instanceof RoboconfImportedVariable )
						result.add( link.getTarget());
				}
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
			return element instanceof String || element instanceof RoboconfFacet;
		}
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class VariablesLabelProvider extends LabelProvider {

		@Override
		public String getText( Object element ) {

			String text = "";
			if( element instanceof String ) {
				text = Utils.capitalize((String) element);
			}

			// Imported variable
			else if( element instanceof RoboconfImportedVariable ) {
				RoboconfImportedVariable var = (RoboconfImportedVariable) element;
				StringBuilder sb = new StringBuilder();
				sb.append( var.getName());

				if( var.isExternal()) {
					sb.append( " (external" );
					if( var.isOptional())
						sb.append( ", optional)" );

				} else if( var.isOptional()) {
					sb.append( "(optional)" );
				}

				text = sb.toString();
			}

			// Exported variable
			else if( element instanceof RoboconfExportedVariable ) {
				RoboconfExportedVariable var = (RoboconfExportedVariable) element;
				StringBuilder sb = new StringBuilder();
				sb.append( var.getName());
				if( ! Utils.isEmptyOrWhitespaces( var.getValue())) {
					sb.append( " = " );
					sb.append( var.getValue());
				}

				text = sb.toString();
			}

			return text;
		}
	}
}
