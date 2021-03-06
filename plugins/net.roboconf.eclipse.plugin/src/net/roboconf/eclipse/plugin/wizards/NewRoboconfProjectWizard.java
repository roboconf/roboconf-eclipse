/**
 * Copyright 2015-2017 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.plugin.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;

import net.roboconf.core.Constants;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;
import net.roboconf.tooling.core.ProjectUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class NewRoboconfProjectWizard extends Wizard implements INewWizard {

	protected NewRoboconfProjectWizardPage projectPage;


	/**
	 * Constructor.
	 */
	public NewRoboconfProjectWizard() {

		super();
		setNeedsProgressMonitor( true );
		setWindowTitle( "New Roboconf Project" );

		ImageDescriptor desc = RoboconfEclipsePlugin.getImageDescriptor( "icons/roboconf_75x66.png" );
		setDefaultPageImageDescriptor( desc );
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard
	 * #init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init( IWorkbench workbench, IStructuredSelection selection ) {
		// nothing
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		this.projectPage = new NewRoboconfProjectWizardPage();
		addPage( this.projectPage );
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #performFinish()
	 */
	@Override
	public boolean performFinish() {

		// Define the wizard completion process.
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			@Override
			protected void execute( IProgressMonitor monitor )
			throws CoreException, InvocationTargetException, InterruptedException {

				try {
					// Create the project
					monitor.beginTask( "Creating the project...", 6 );
					File target = NewRoboconfProjectWizard.this.projectPage.getTargetDirectory();
					String name = NewRoboconfProjectWizard.this.projectPage.getCreationBean().getArtifactId();
					if( target == null )
						target = new File( ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString(), name );

					ProjectUtils.createProjectSkeleton( target, NewRoboconfProjectWizard.this.projectPage.getCreationBean());
					monitor.worked( 4 );
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( name );

					// Setting the location
					target = NewRoboconfProjectWizard.this.projectPage.getTargetDirectory();
					if( target != null ) {
						IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription( name );
						projectDescription.setLocationURI( target.toURI());
						project.create( projectDescription, monitor );

					} else {
						project.create( monitor );
					}

					// Open the project
					project.open( monitor );
					monitor.worked( 1 );

					// Add the required nature
					monitor.subTask( "Adding the project nature" );
					RoboconfEclipseUtils.addRoboconfNature( project, monitor );
					monitor.worked( 1 );

				} catch( Exception e ) {
					throw new InvocationTargetException( e );

				} finally {
					monitor.done();
				}
			}
		};

		boolean result = true;
		try {
			// Run the operation.
			getContainer().run( true, false, op );

			// Overwrite the instances file?
			String projectName = this.projectPage.getCreationBean().getArtifactId();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( projectName );

			String loc = Constants.PROJECT_DIR_INSTANCES + "/" + ProjectUtils.INSTANCES_EP;
			if( this.projectPage.getCreationBean().isMavenProject())
				loc = Constants.MAVEN_SRC_MAIN_MODEL + loc;

			final IFile instancesFile = project.getFile( loc );
			overwriteInstancesFileContent( instancesFile );

			// Overwrite the graph file?
			loc = Constants.PROJECT_DIR_GRAPH + "/" + ProjectUtils.GRAPH_EP;
			if( this.projectPage.getCreationBean().isMavenProject())
				loc = Constants.MAVEN_SRC_MAIN_MODEL + loc;

			final IFile graphFile = project.getFile( loc );
			overwriteGraphFileContent( graphFile );

			// Open the graph file
			showFile( graphFile );

		} catch( Exception e ) {
			RoboconfEclipsePlugin.log( e, IStatus.ERROR );
			result = false;
		}

		return result;
	}


	/**
	 * Show the graph file.
	 * @param graphFile the graph file
	 */
	protected void showFile( IFile graphFile ) {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			IDE.openEditor( page, graphFile );

		} catch( PartInitException e ) {
			RoboconfEclipsePlugin.log( e, IStatus.ERROR );

		} finally {
			RoboconfEclipseUtils.selectFileInResourceExplorer( graphFile );
		}
	}


	/**
	 * @param graphFile the main graph file, whose content can be overwritten
	 */
	protected void overwriteGraphFileContent( IFile graphFile ) {
		// nothing
	}


	/**
	 * @param instancesFile the main instances file, whose content can be overwritten
	 */
	protected void overwriteInstancesFileContent( IFile instancesFile ) {
		// nothing
	}
}
