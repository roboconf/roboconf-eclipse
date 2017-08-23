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

package net.roboconf.eclipse.plugin.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import net.roboconf.core.Constants;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;
import net.roboconf.tooling.core.ProjectUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class CreateRecipesDirectories extends AbstractHandler {

	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		IStatus result = Status.OK_STATUS;
		ISelection currentSelection = HandlerUtil.getCurrentSelection( event );
		if( currentSelection instanceof IStructuredSelection ) {

			Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
			IAdapterManager adapterManager = Platform.getAdapterManager();
			IResource resourceAdapter = adapterManager.getAdapter( firstElement, IResource.class );

			if( resourceAdapter != null ) {
				IResource applicationFolder = resourceAdapter.getProject().getFolder( Constants.MAVEN_SRC_MAIN_MODEL );
				if( ! applicationFolder.exists())
					applicationFolder = resourceAdapter.getProject();

				// Create the directories
				List<File> createdDirectories = null;
				try {
					createdDirectories = ProjectUtils.createRecipeDirectories( applicationFolder.getLocation().toFile());

				} catch( IOException e ) {
					RoboconfEclipsePlugin.log( e, IStatus.ERROR );
					result = new Status( Status.ERROR, RoboconfEclipsePlugin.PLUGIN_ID, "Recipe directories could not be created." );
				}

				// Refresh that part of the workspace
				try {
					applicationFolder.refreshLocal( IResource.DEPTH_INFINITE, new NullProgressMonitor());

				} catch( Exception e ) {
					RoboconfEclipsePlugin.log( e, IStatus.ERROR );
				}

				// Show the created directories, or the graph directory otherwise
				applicationFolder = ((IContainer) applicationFolder).getFolder( new Path( Constants.PROJECT_DIR_GRAPH ));
				List<IResource> selection = new ArrayList<> ();
				if( createdDirectories == null || createdDirectories.isEmpty())
					selection.add( applicationFolder );
				else for( File f : createdDirectories )
					selection.add(((IContainer) applicationFolder).findMember( f.getName()));

				// Select and reveal
				RoboconfEclipseUtils.selectFileInResourceExplorer( selection.toArray( new IResource[ 0 ]));
			}
		}

		return result;
	}
}
