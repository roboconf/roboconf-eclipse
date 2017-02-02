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

package net.roboconf.eclipse.plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

/**
 * @author Vincent Zurczak - Linagora
 */
public final class RoboconfEclipseUtils {

	/**
	 * Private constructor.
	 */
	private RoboconfEclipseUtils() {
		// nothing
	}


	/**
	 * Removes the comments from a line.
	 * @param line a non-null line
	 * @return a non-null line
	 */
	public static String removeComments( String line ) {
		return line.replaceAll( "\\s*#[^\n]*", "" );
	}


	/**
	 * Adds the Roboconf nature to a project, if it does not already has it.
	 * @param project a non-null project and open project
	 * @param monitor a progress monitor
	 * @throws CoreException if something went wrong
	 */
	public static void addRoboconfNature( IProject project, IProgressMonitor monitor )
	throws CoreException {

		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		if( Arrays.asList( natures ).contains( RoboconfEclipseConstants.NATURE_ID ))
			return;

		String[] newNatures = new String[ natures.length + 1 ];
		System.arraycopy( natures, 0, newNatures, 0, natures.length );
		newNatures[ natures.length ] = RoboconfEclipseConstants.NATURE_ID;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = workspace.validateNatureSet( newNatures );

		if( status.getCode() == IStatus.OK ) {
			description.setNatureIds( newNatures );
			project.setDescription( description, monitor );
		}
	}


	/**
	 * Removes the Roboconf nature from a project, if it has it.
	 * @param project a non-null project and open project
	 * @param monitor a progress monitor
	 * @throws CoreException if something went wrong
	 */
	public static void removeRoboconfNature( IProject project, IProgressMonitor monitor )
	throws CoreException {

		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		List<String> naturesAsList = new ArrayList<>( Arrays.asList( natures ));

		if( naturesAsList.remove( RoboconfEclipseConstants.NATURE_ID )) {

			// Update the natures list
			String[] newNatures = naturesAsList.toArray( new String[ naturesAsList.size()]);
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IStatus status = workspace.validateNatureSet( newNatures );

			if( status.getCode() == IStatus.OK ) {
				description.setNatureIds( newNatures );
				project.setDescription( description, monitor );
			}

			// Delete Roboconf markers
			project.deleteMarkers( RoboconfEclipseConstants.MARKER_ID, true, IResource.DEPTH_INFINITE );
		}
	}
}
