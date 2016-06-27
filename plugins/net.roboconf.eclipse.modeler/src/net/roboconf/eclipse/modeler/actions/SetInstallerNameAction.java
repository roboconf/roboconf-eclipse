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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.Configuration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.PlatformUI;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class SetInstallerNameAction implements IExternalJavaAction {

	private static final String EOBJECT_KEY = "eobject";


	@Override
	public boolean canExecute( Collection<? extends EObject> selections ) {

		// If there is a selection, we only want components...
		boolean onlyComponents = true;
		for( Iterator<? extends EObject> it= selections.iterator(); it.hasNext() && onlyComponents; ) {
			EObject eo = EclipseUtils.resolve( it.next());
			onlyComponents = eo instanceof RoboconfComponent;
		}

		// Or, when we create a new component, the selection is made up
		// of a single "configuration" element
		boolean isConfiguration = selections.size() == 1
				&& selections.iterator().next() instanceof Configuration;

		return onlyComponents || isConfiguration;
	}


	@Override
	public void execute( Collection<? extends EObject> selections, Map<String,Object> parameters ) {

		// Get the components to update
		List<RoboconfComponent> components = new ArrayList<> ();
		for( EObject object : selections ) {
			EObject eo = EclipseUtils.resolve( object);
			if( eo instanceof RoboconfComponent )
				components.add((RoboconfComponent) eo);
		}

		Object o = parameters.get( EOBJECT_KEY );
		if( o instanceof RoboconfComponent )
			components.add((RoboconfComponent) o);

		// Installer name to suggest
		String defaultInstaller = "script";
		for( RoboconfComponent comp : components ) {

			if( comp.getInstallerName() != null
					&& ! comp.getInstallerName().trim().isEmpty())
				defaultInstaller = comp.getInstallerName().trim();
		}

		// Get the installer name
		InputDialog dlg = new InputDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Installer Name",
				"Please, type in the installer name for the selected components.",
				defaultInstaller,
				new MyValidator());

		// If we got a value, update the model
		if( dlg.open() == Window.OK ) {
			String installerName = dlg.getValue().trim();
			for( RoboconfComponent comp : components ) {

				// We don't use commands (history works without, at least in Sirius)
				comp.setInstallerName( installerName );
			}
		}
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static final class MyValidator implements IInputValidator {

		@Override
		public String isValid(String s) {

			String msg = null;
			if( s == null || s.trim().isEmpty())
				msg = "An installer name cannot be null or empty.";

			return msg;
		}
	}
}
