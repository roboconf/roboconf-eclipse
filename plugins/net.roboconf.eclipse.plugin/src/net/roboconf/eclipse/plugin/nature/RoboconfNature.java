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

package net.roboconf.eclipse.plugin.nature;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import net.roboconf.eclipse.plugin.RoboconfEclipseConstants;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfNature implements IProjectNature {

	private IProject project;


	@Override
	public void configure() throws CoreException {

		IProjectDescription desc = this.project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		ICommand[] newCommands = new ICommand[ commands.length + 1 ];
		System.arraycopy( commands, 0, newCommands, 0, commands.length );
		ICommand command = desc.newCommand ();
		command.setBuilderName( RoboconfEclipseConstants.BUILDER_ID );
		newCommands[ newCommands.length - 1 ] = command;

		desc.setBuildSpec( newCommands );
		this.project.setDescription( desc, null );
	}


	@Override
	public void deconfigure() throws CoreException {

		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();

		for( int i=0; i<commands.length; ++i ) {
			if( commands[i].getBuilderName().equals( RoboconfEclipseConstants.BUILDER_ID )) {
				ICommand[] newCommands = new ICommand[ commands.length - 1 ];
				System.arraycopy( commands, 0, newCommands, 0, i );
				System.arraycopy( commands, i + 1, newCommands, i, commands.length - i - 1 );
				description.setBuildSpec( newCommands );
				break;
			}
		}
	}


	@Override
	public IProject getProject() {
		return this.project;
	}


	@Override
	public void setProject( IProject project ) {
		this.project = project;
	}
}
