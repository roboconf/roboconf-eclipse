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

package net.roboconf.eclipse.modeler.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ShowVariablesAction implements IExternalJavaAction {

	private static final String VIEW_ID = "net.roboconf.eclipse.modeler.views.variablesView";


	@Override
	public boolean canExecute( Collection<? extends EObject> selections ) {

		return selections.size() == 1
				&& EclipseUtils.resolve( selections.iterator().next()) instanceof RoboconfFacet;
	}


	@Override
	public void execute( Collection<? extends EObject> selections, Map<String,Object> parameters ) {

		try {
			IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView( VIEW_ID );
			editor.setFocus();

		} catch( PartInitException e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}
	}
}
