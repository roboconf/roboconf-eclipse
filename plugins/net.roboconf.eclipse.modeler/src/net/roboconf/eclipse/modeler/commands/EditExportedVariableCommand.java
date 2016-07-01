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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.modeler.dialogs.ExportedVariableDialog;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import net.roboconf.eclipse.modeler.views.VariablesView;

/**
 * @author Vincent Zurczak - Linagora
 */
public class EditExportedVariableCommand extends AbstractHandler {

	private RoboconfExportedVariable var;


	/**
	 * Constructor.
	 */
	public EditExportedVariableCommand() {
		// nothing
	}


	/**
	 * Constructor.
	 * @param var the "selected" variable
	 */
	public EditExportedVariableCommand( RoboconfExportedVariable var ) {
		this.var = var;
	}


	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		ExportedVariableDialog dlg = new ExportedVariableDialog(
				this.var.getName(),
				this.var.getDefaultValue(),
				this.var.getExternalAlias(),
				(RoboconfFacet) this.var.eContainer());

		if( dlg.open() == Window.OK ) {

			// Perform the modifications within a transactional command
			Command cmd = new UpdateExportedVariabledCommand( this.var, dlg.getName(), dlg.getValue(), dlg.getAlias());
			EclipseUtils.findEditingDomain( this.var ).getCommandStack().execute( cmd );
			VariablesView.refreshElement( this.var, this.var );
		}

		return null;
	}


	@Override
	public void setEnabled( Object evaluationContext ) {

		boolean enabled = false;
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		if( selection != null
				&& ! selection.isEmpty()) {
			EObject eo = EclipseUtils.findEObjectFromSelection( selection );
			enabled = eo instanceof RoboconfExportedVariable;
			this.var = enabled ? (RoboconfExportedVariable) eo : null;
		}

		super.setBaseEnabled( enabled );
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class UpdateExportedVariabledCommand extends AbstractCommand implements Command {

		private final RoboconfExportedVariable var;
		private final String name, value, alias;
		private final String oldName, oldValue, oldAlias;


		/**
		 * Constructor.
		 * @param var
		 * @param name
		 * @param value
		 * @param alias
		 */
		public UpdateExportedVariabledCommand( RoboconfExportedVariable var, String name, String value, String alias ) {
			this.var = var;
			this.alias = alias;
			this.name = name;
			this.value = value;

			this.oldName = var.getName();
			this.oldValue = var.getDefaultValue();
			this.oldAlias = var.getExternalAlias();
		}

		@Override
		public void execute() {
			this.var.setName( this.name );
			this.var.setExternalAlias( this.alias );
			this.var.setDefaultValue( this.value );
		}

		@Override
		public void undo() {
			this.var.setName( this.oldName );
			this.var.setExternalAlias( this.oldAlias );
			this.var.setDefaultValue( this.oldValue );
		}

		@Override
		public void redo() {
			execute();
		}

		@Override
		public boolean canExecute() {
			return true;
		}
	}
}
