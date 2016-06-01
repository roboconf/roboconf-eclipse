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
import org.occiware.clouddesigner.occi.Configuration;

import net.roboconf.eclipse.modeler.dialogs.ExportedVariableDialog;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfExportedVariable;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfOwnerLink;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphFactory;

/**
 * @author Vincent Zurczak - Linagora
 */
public class CreateNewExportedVariableCommand extends AbstractHandler {

	private RoboconfFacet facetOrComponent;


	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		ExportedVariableDialog dlg = new ExportedVariableDialog( null, null, null );
		if( dlg.open() == Window.OK ) {

			// Perform the modifications within a transactional command
			Command cmd = new NewExportedVariabledCommand( this.facetOrComponent, dlg.getName(), dlg.getValue(), dlg.getAlias());
			EclipseUtils.findEditingDomain( this.facetOrComponent ).getCommandStack().execute( cmd );
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
			enabled = eo instanceof RoboconfFacet;
			this.facetOrComponent = enabled ? (RoboconfFacet) eo : null;
		}

		super.setBaseEnabled( enabled );
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class NewExportedVariabledCommand extends AbstractCommand implements Command {

		private final RoboconfFacet facetOrComponent;
		private final String name, value, alias;

		private RoboconfExportedVariable var;
		private RoboconfOwnerLink link;


		/**
		 * Constructor.
		 * @param facetOrComponent
		 * @param name
		 * @param value
		 * @param alias
		 */
		public NewExportedVariabledCommand( RoboconfFacet facetOrComponent, String name, String value, String alias ) {
			this.facetOrComponent = facetOrComponent;
			this.alias = alias;
			this.name = name;
			this.value = value;
		}

		@Override
		public void execute() {

			this.var = RoboconfgraphFactory.eINSTANCE.createRoboconfExportedVariable();
			this.var.setName( this.name );
			this.var.setPublicAlias( this.alias );
			this.var.setValue( this.value );

			this.link = RoboconfgraphFactory.eINSTANCE.createRoboconfOwnerLink();
			this.link.setTarget( this.var );
			this.link.setSource( this.facetOrComponent );
			redo();
		}

		@Override
		public void undo() {
			this.facetOrComponent.getLinks().remove( this.link );
			((Configuration) this.facetOrComponent.eContainer()).getResources().remove( this.var );
		}

		@Override
		public void redo() {
			((Configuration) this.facetOrComponent.eContainer()).getResources().add( this.var );
			this.facetOrComponent.getLinks().add( this.link );
		}

		@Override
		public boolean canExecute() {
			return true;
		}
	}
}
