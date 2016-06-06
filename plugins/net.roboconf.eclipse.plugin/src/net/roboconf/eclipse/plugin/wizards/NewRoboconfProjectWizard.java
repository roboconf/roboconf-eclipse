/**
 * Copyright 2015-2016 Linagora, Université Joseph Fourier, Floralis
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;

import net.roboconf.eclipse.plugin.RoboconfEclipseConstants;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;
import net.roboconf.tooling.core.ProjectUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class NewRoboconfProjectWizard extends Wizard implements INewWizard {

	private static final String PROJECTS_VIEW = "org.eclipse.ui.navigator.ProjectExplorer";
	private static final String PACKAGES_VIEW = "org.eclipse.jdt.ui.PackageExplorer";

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

			// Open the graph file
			String projectName = this.projectPage.getCreationBean().getArtifactId();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( projectName );

			String loc = "graph/main.graph";
			if( this.projectPage.getCreationBean().isMavenProject())
				loc = RoboconfEclipseConstants.SRC_MAIN_MODEL + loc;

			final IFile graphFile = project.getFile( loc );
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				IDE.openEditor( page, graphFile );

			} catch( PartInitException e ) {
				RoboconfEclipsePlugin.log( e, IStatus.ERROR );

			} finally {
				selectFileInResourceExplorer( graphFile );
			}

		} catch( Exception e ) {
			RoboconfEclipsePlugin.log( e, IStatus.ERROR );
			result = false;
		}

		return result;
	}


	/**
	 * Selects the graph file in an explorer.
	 * @param graphFile
	 */
	private void selectFileInResourceExplorer( IFile graphFile ) {

		// Show a view with the workspace as model
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart viewPart = null;
		try {
			viewPart = page.showView( PROJECTS_VIEW );

		} catch( PartInitException e ) {
			try {
				viewPart = page.showView( PACKAGES_VIEW );

			} catch( PartInitException e1 ) {
				RoboconfEclipsePlugin.log( e1, IStatus.ERROR );
			}
		}

		// Select and expand
		if( viewPart != null ) {
			viewPart.getViewSite().getSelectionProvider().setSelection( new StructuredSelection( graphFile ));
		}
	}
}
