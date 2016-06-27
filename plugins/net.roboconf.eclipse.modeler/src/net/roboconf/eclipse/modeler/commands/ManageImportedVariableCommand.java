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

package net.roboconf.eclipse.modeler.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;
import net.roboconf.eclipse.modeler.dialogs.ImportedVariableDialog;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import net.roboconf.eclipse.modeler.views.VariablesView;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ManageImportedVariableCommand extends AbstractHandler {

	private RoboconfComponent component;


	/**
	 * Constructor.
	 */
	public ManageImportedVariableCommand() {
		// nothing
	}


	/**
	 * Constructor.
	 * @param component the "selected" facet or component
	 */
	public ManageImportedVariableCommand( RoboconfComponent component ) {
		this.component = component;
	}


	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		ImportedVariableDialog dlg = new ImportedVariableDialog( this.component );
		if( dlg.open() == Window.OK ) {

			// Perform the modifications within a transactional command
			Command cmd = new NewImportedVariabledCommand( this.component, dlg.getImportedVariablesToTaken());
			EclipseUtils.findEditingDomain( this.component ).getCommandStack().execute( cmd );
			VariablesView.refreshElement( this.component, VariablesView.IMPORTED );
		}

		return null;
	}


	@Override
	public void setEnabled( Object evaluationContext ) {

		boolean enabled = false;
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = activePage.getSelection();

		String partId = null;
		if( activePage.getActivePartReference() != null )
			partId = activePage.getActivePartReference().getId();

		// The handler is enabled in two cases.
		// 1. The view with the focus is the variables view, and a facet or a component
		// was previously selected.
		if( VariablesView.VIEW_ID.equals( partId ) && this.component != null ) {
			enabled = true;
		}

		// 2. The current selection is facet or a component.
		else if( selection != null
				&& ! selection.isEmpty()) {

			EObject eo = EclipseUtils.findEObjectFromSelection( selection );
			enabled = eo instanceof RoboconfComponent;
			this.component = enabled ? (RoboconfComponent) eo : null;
		}

		super.setBaseEnabled( enabled );
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class NewImportedVariabledCommand extends AbstractCommand implements Command {

		private final RoboconfComponent component;
		private final Map<RoboconfImportedVariable,Boolean> varToTaken;


		/**
		 * Constructor.
		 * @param component
		 * @param varToTaken
		 */
		public NewImportedVariabledCommand( RoboconfComponent component, Map<RoboconfImportedVariable,Boolean> varToTaken ) {
			this.component = component;
			this.varToTaken = varToTaken;
		}

		@Override
		public void execute() {

			Map<String,RoboconfImportedVariable> cache = new HashMap<> ();
			for( RoboconfImportedVariable var : this.varToTaken.keySet())
				cache.put( var.getName(), var );

			// Delete what is unnecessary.
			List<EObject> toDelete = new ArrayList<> ();
			for( RoboconfImportedVariable var : this.component.getImports()) {

				// We reference a variable that is not part of those listed in the dialog.
				// => Delete it.
				// FIXME: currently, we do not deal correctly with variables exported by other
				// applications. We only list variables that are exported within the application.
				// We should have more flexibility when defining imported variables.

				// Notice we "get and remove" the verified variables from the cache.
				RoboconfImportedVariable dlgVar = cache.remove( var.getName());
				if( dlgVar == null ) {
					toDelete.add( var );
					continue;
				}

				// The variable is not marked as taken.
				// => Delete it.
				Boolean taken = this.varToTaken.get( dlgVar );
				if( taken == null || ! taken ) {
					toDelete.add( var );
					continue;
				}

				// Otherwise, we keep it. We simply update its attributes.
				var.setOptional( dlgVar.isOptional());
				var.setExternal( dlgVar.isExternal());
			}

			// Delete them all
			for( EObject eo : toDelete )
				EcoreUtil.delete( eo );

			// Now, add the missing variables.
			// "cache" only contains variables that did not already exist first.
			for( RoboconfImportedVariable var : cache.values()) {
				Boolean taken = this.varToTaken.get( var );
				if( taken != null && taken )
					this.component.getImports().add( var );
			}
		}

		@Override
		public void redo() {
			// nothing
		}

		@Override
		public void undo() {
			// nothing, no undo
		}

		@Override
		public boolean canExecute() {
			return true;
		}
	}
}
