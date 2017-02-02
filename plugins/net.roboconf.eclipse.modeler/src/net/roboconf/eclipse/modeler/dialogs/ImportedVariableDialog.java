/**
 * Copyright 2016-2017 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.modeler.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfFactory;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;

/**
 * FIXME: external imports are not handled here and should be managed differently.
 * @author Vincent Zurczak - Linagora
 */
public class ImportedVariableDialog extends TitleAreaDialog {

	private final Map<RoboconfImportedVariable,Boolean> importedVariablesToTaken = new LinkedHashMap<> ();
	private final Map<String,RoboconfImportedVariable> nameToImportedVariables = new TreeMap<> ();
	private final RoboconfComponent component;
	private final Image checked, unchecked;


	/**
	 * Constructor.
	 * @param component
	 */
	public ImportedVariableDialog( RoboconfComponent component ) {
		super( null );

		this.component = component;
		this.checked = RoboconfModelerPlugin.findImage( "icons/16x16/checked.gif" );
		this.unchecked = RoboconfModelerPlugin.findImage( "icons/16x16/unchecked.gif" );

		setShellStyle( SWT.TITLE | SWT.RESIZE );
	}


	/**
	 * @return the importedVariablesToTaken map
	 */
	public Map<RoboconfImportedVariable,Boolean> getImportedVariablesToTaken() {
		return this.importedVariablesToTaken;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog
	 * #createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea( Composite parent ) {

		// Global UI
		Composite bigContainer = (Composite) super.createDialogArea( parent );
		GridLayoutFactory.swtDefaults().margins( 5, 0 ).applyTo( bigContainer );
		bigContainer.setLayoutData( new GridData( GridData.FILL_BOTH ));

		getShell().setText( "Imported Variables" );
		setTitle( "Imported Variables" );
		setMessage( "Edit the variables to import." );

		// Find all the variables
		for( RoboconfFacet type : findAllFacetsAndComponents()) {

			Collection<String> varNames = findAllExportedVariables( type );
			if( ! type.getExports().isEmpty())
				varNames.add( type.getName() + ".*" );

			for( String varName : varNames ) {
				RoboconfImportedVariable var = RoboconfEmfFactory.eINSTANCE.createRoboconfImportedVariable();
				var.setName( varName );
				if( var.getName().startsWith( this.component.getName() + "." ))
					var.setOptional( true );

				this.nameToImportedVariables.put( varName, var );
			}
		}

		// Update the map that will act as our model.
		// We do this in two steps because...
		// 1. nameToImportedVariables is a tree map. Variables are sorted alphabetically.
		// 2. importedVariablesToTaken is our model for the UI. Since it is a linked hash map,
		// it preserves insertion order. So, we preserve the order from the tree map.
		//
		// And we cannot directly use a tree map with imported variables.
		// The class was generated by EMF and there is no natural ordering.
		for( RoboconfImportedVariable var : this.nameToImportedVariables.values()) {
			this.importedVariablesToTaken.put( var, Boolean.FALSE );
		}

		// Should they be marked as used?
		updateImportedVariablesStates();

		// Display them in a table viewer
		final TableViewer viewer = new TableViewer( bigContainer, SWT.BORDER | SWT.SINGLE );
		viewer.getTable().setLayoutData( new GridData( GridData.FILL_BOTH ));
		viewer.getTable().setHeaderVisible( true );
		viewer.getTable().setLinesVisible( true );

		TableLayout tlayout = new TableLayout();
		tlayout.addColumnData( new ColumnWeightData( 12, 90, true ));
		tlayout.addColumnData( new ColumnWeightData( 40, 200, true ));
		tlayout.addColumnData( new ColumnWeightData( 12, 90, true ));
		viewer.getTable().setLayout( tlayout );

		String[] columnTitles = { "Import", "Variable Name", "Optional" };
		for( int i=0; i<columnTitles.length; i++ ) {
			int style = i == 1 ? SWT.LEFT : SWT.CENTER;
			TableColumn column = new TableColumn( viewer.getTable(), style );
			column.setText( columnTitles[ i ]);
		}

		viewer.setLabelProvider( new ImportedVariableLabelProvider( this.checked, this.unchecked ));
		viewer.setContentProvider( new ArrayContentProvider());
		viewer.setInput( this.importedVariablesToTaken.entrySet());
		viewer.getTable().addListener( SWT.MouseDoubleClick, new Listener() {

			@Override
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void handleEvent( Event event ) {

				Point p = new Point( event.x, event.y );
				ViewerCell cell = viewer.getCell( p );

				Map.Entry<RoboconfImportedVariable,Boolean> entry = (Map.Entry) cell.getElement();
				RoboconfImportedVariable var = entry.getKey();

				if( cell.getColumnIndex() == 0 ) {
					entry.setValue( ! entry.getValue());

				} else if( cell.getColumnIndex() == 2 ) {
					var.setOptional( ! var.isOptional());
				}

				viewer.refresh( entry );
			}
		});

		return bigContainer;
	}


	/**
	 * Finds which variables are effectively imported by the selected facet or component.
	 */
	private void updateImportedVariablesStates() {

		for( RoboconfImportedVariable realVar : this.component.getImports()) {
			String name = realVar.getName();
			RoboconfImportedVariable var = this.nameToImportedVariables.get( name );
			if( var == null ) {
				RoboconfModelerPlugin.log( "Variable not found: " + name, IStatus.WARNING );
				continue;
			}

			this.importedVariablesToTaken.put( var, Boolean.TRUE );
			var.setOptional( realVar.isOptional());
		}
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	@Override
	public boolean close() {

		if( this.checked != null && ! this.checked.isDisposed())
			this.checked.dispose();

		if( this.unchecked != null && ! this.unchecked.isDisposed())
			this.unchecked.dispose();

		return super.close();
	}


	/**
	 * @param type a Roboconf type
	 * @return a non-null collection of exported variables
	 */
	private Collection<String> findAllExportedVariables( RoboconfFacet type ) {

		Set<String> result = new TreeSet<> ();
		for( RoboconfExportedVariable var : type.getExports())
			result.add( type.getName() + "." + var.getName());

		return result;
	}


	/**
	 * @return a non-null list of Roboconf types
	 */
	private List<RoboconfFacet> findAllFacetsAndComponents() {

		List<RoboconfFacet> result = new ArrayList<> ();
		result.addAll(((RoboconfGraphs) this.component.eContainer()).getFacets());
		result.addAll(((RoboconfGraphs) this.component.eContainer()).getComponents());

		return result;
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class ImportedVariableLabelProvider implements ITableLabelProvider {

		private final Image checked, unchecked;


		/**
		 * Constructor.
		 * @param checked
		 * @param unchecked
		 */
		public ImportedVariableLabelProvider( Image checked, Image unchecked ) {
			this.checked = checked;
			this.unchecked = unchecked;
		}

		@Override
		public void addListener( ILabelProviderListener listener ) {
			// nothing
		}

		@Override
		public void dispose() {
			// nothing
		}

		@Override
		public boolean isLabelProperty( Object element, String property ) {
			return false;
		}

		@Override
		public void removeListener( ILabelProviderListener listener ) {
			// nothing
		}

		@Override
		public Image getColumnImage( Object element, int columnIndex ) {

			Image result = null;
			if( element instanceof Map.Entry<?,?> ) {
				Map.Entry<?,?> entry = (Map.Entry<?,?>) element;
				RoboconfImportedVariable var = (RoboconfImportedVariable) entry.getKey();
				if( columnIndex == 0 )
					result = (Boolean) entry.getValue() ? this.checked : this.unchecked;
				else if( columnIndex == 2 )
					result = var.isOptional() ? this.checked : this.unchecked;
			}

			return result;
		}

		@Override
		public String getColumnText( Object element, int columnIndex ) {

			String result = "";
			if( element instanceof Map.Entry<?,?> && columnIndex == 1 ) {
				Map.Entry<?,?> entry = (Map.Entry<?,?>) element;
				RoboconfImportedVariable var = (RoboconfImportedVariable) entry.getKey();
				result = var.getName();
			}

			return result;
		}
	}
}
