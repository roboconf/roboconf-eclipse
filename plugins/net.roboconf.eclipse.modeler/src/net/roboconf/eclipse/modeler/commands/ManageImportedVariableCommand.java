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
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Link;

import net.roboconf.eclipse.modeler.dialogs.ImportedVariableDialog;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import net.roboconf.eclipse.modeler.views.VariablesView;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfImportedVariable;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfOwnerLink;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphFactory;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ManageImportedVariableCommand extends AbstractHandler {

	private RoboconfFacet facetOrComponent;


	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		ImportedVariableDialog dlg = new ImportedVariableDialog( this.facetOrComponent );
		if( dlg.open() == Window.OK ) {

			// Perform the modifications within a transactional command
			Command cmd = new NewImportedVariabledCommand( this.facetOrComponent, dlg.getImportedVariablesToTaken());
			EclipseUtils.findEditingDomain( this.facetOrComponent ).getCommandStack().execute( cmd );
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
		if( VariablesView.VIEW_ID.equals( partId ) && this.facetOrComponent != null ) {
			enabled = true;
		}

		// 2. The current selection is facet or a component.
		else if( selection != null
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
	private static class NewImportedVariabledCommand extends AbstractCommand implements Command {

		private final RoboconfFacet facetOrComponent;
		private final Map<RoboconfImportedVariable,Boolean> varToTaken;


		/**
		 * Constructor.
		 * @param facetOrComponent
		 * @param varToTaken
		 */
		public NewImportedVariabledCommand( RoboconfFacet facetOrComponent, Map<RoboconfImportedVariable,Boolean> varToTaken ) {
			this.facetOrComponent = facetOrComponent;
			this.varToTaken = varToTaken;
		}

		@Override
		public void execute() {

			Map<String,RoboconfImportedVariable> cache = new HashMap<> ();
			for( RoboconfImportedVariable var : this.varToTaken.keySet())
				cache.put( var.getName(), var );

			// Delete what is unnecessary.
			List<EObject> toDelete = new ArrayList<> ();
			for( Link link : this.facetOrComponent.getLinks()) {

				if( link instanceof RoboconfOwnerLink
						&& link.getTarget() instanceof RoboconfImportedVariable ) {

					// We reference a variable that is not part of those listed in the dialog.
					// => Delete it.
					// FIXME: currently, we do not deal correctly with variables exported by other
					// applications. We only list variables that are exported within the application.
					// We should have more flexibility when defining imported variables.
					RoboconfImportedVariable targetVar = (RoboconfImportedVariable) link.getTarget();

					// Notice we "get and remove" the verified variables from the cache.
					RoboconfImportedVariable dlgVar = cache.remove( targetVar.getName());
					if( dlgVar == null ) {
						toDelete.add( link );
						toDelete.add( targetVar );
						continue;
					}

					// The variable is not marked as taken.
					// => Delete it.
					Boolean taken = this.varToTaken.get( dlgVar );
					if( taken == null || ! taken ) {
						toDelete.add( link );
						toDelete.add( targetVar );
						continue;
					}

					// Otherwise, we keep it. We simply update its attributes.
					targetVar.setOptional( dlgVar.isOptional());
					targetVar.setExternal( dlgVar.isExternal());
				}
			}

			// Delete them all
			for( EObject eo : toDelete )
				EcoreUtil.delete( eo );

			// Now, add the missing variables.
			// "cache" only contains variables that did not already exist first.
			for( RoboconfImportedVariable var : cache.values()) {
				Boolean taken = this.varToTaken.get( var );
				if( taken == null || ! taken )
					continue;

				RoboconfOwnerLink link = RoboconfgraphFactory.eINSTANCE.createRoboconfOwnerLink();
				link.setTarget( var );
				link.setSource( this.facetOrComponent );

				((Configuration) this.facetOrComponent.eContainer()).getResources().add( var );
				this.facetOrComponent.getLinks().add( link );
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
