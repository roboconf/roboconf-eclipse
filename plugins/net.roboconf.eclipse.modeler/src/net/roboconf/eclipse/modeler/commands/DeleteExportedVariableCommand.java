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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.PlatformUI;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import net.roboconf.eclipse.modeler.views.VariablesView;

/**
 * @author Vincent Zurczak - Linagora
 */
public class DeleteExportedVariableCommand extends AbstractHandler {

	private RoboconfExportedVariable var;


	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		// Perform the modifications within a transactional command
		EObject container = this.var.eContainer();
		Command cmd = new DeleteExportedVariabledCommand( this.var );
		EclipseUtils.findEditingDomain( this.var ).getCommandStack().execute( cmd );
		VariablesView.refreshElement( container, null );

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
	private static class DeleteExportedVariabledCommand extends AbstractCommand implements Command {

		private final RoboconfExportedVariable var;


		/**
		 * Constructor.
		 * @param var
		 */
		public DeleteExportedVariabledCommand( RoboconfExportedVariable var ) {
			this.var = var;
		}

		@Override
		public void execute() {
			EcoreUtil.delete( this.var );
		}

		@Override
		public void redo() {
			execute();
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
