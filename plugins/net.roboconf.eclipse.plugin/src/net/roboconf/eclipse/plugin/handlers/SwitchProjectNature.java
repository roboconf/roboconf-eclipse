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

package net.roboconf.eclipse.plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class SwitchProjectNature extends AbstractHandler {

	private static final String PARAM = "net.roboconf.eclipse.plugin.switchRoboconfNature.delete";


	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		IStatus result = Status.OK_STATUS;
		boolean delete = event.getParameter( PARAM ) != null;

		ISelection currentSelection = HandlerUtil.getCurrentSelection( event );
		if( currentSelection instanceof IStructuredSelection ) {

			Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
			IAdapterManager adapterManager = Platform.getAdapterManager();
			IResource resourceAdapter = adapterManager.getAdapter( firstElement, IResource.class );

			if( resourceAdapter != null ) {
				IResource resource = resourceAdapter;
				try {
					IProgressMonitor monitor = new NullProgressMonitor();
					if( delete )
						RoboconfEclipseUtils.removeRoboconfNature( resource.getProject(), monitor );
					else
						RoboconfEclipseUtils.addRoboconfNature( resource.getProject(), monitor );

				} catch( CoreException e ) {
					RoboconfEclipsePlugin.log( e, IStatus.ERROR );
					result = e.getStatus();
				}
			}
		}

		return result;
	}
}
