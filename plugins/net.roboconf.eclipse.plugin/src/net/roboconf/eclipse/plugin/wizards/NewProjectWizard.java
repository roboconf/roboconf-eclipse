/**
 * Copyright 2015 Linagora, Université Joseph Fourier, Floralis
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
import java.lang.reflect.Method;

import net.roboconf.eclipse.plugin.Activator;
import net.roboconf.tooling.core.ProjectUtils;

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
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;

/**
 * @author Vincent Zurczak - Linagora
 */
public class NewProjectWizard extends Wizard implements INewWizard {

	private static final String PROJECTS_VIEW = "org.eclipse.ui.navigator.ProjectExplorer";
	private static final String PACKAGES_VIEW = "org.eclipse.jdt.ui.PackageExplorer";

	private NewProjectWizardPage page;


	/**
	 * Constructor.
	 */
	public NewProjectWizard() {

		super();
		setNeedsProgressMonitor( true );
		setWindowTitle( "New Roboconf Project" );

		ImageDescriptor desc = Activator.getImageDescriptor( "icons/roboconf_75x66.png" );
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
		this.page = new NewProjectWizardPage();
		addPage( this.page );
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
					monitor.beginTask( "Creating the project...", 5 );
					File target = NewProjectWizard.this.page.getTargetDirectory();
					String name = NewProjectWizard.this.page.getCreationBean().getArtifactId();
					if( target == null )
						target = new File( ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString(), name );

					ProjectUtils.createProjectSkeleton( target, NewProjectWizard.this.page.getCreationBean());
					monitor.worked( 4 );
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( name );

					target = NewProjectWizard.this.page.getTargetDirectory();
					if( target != null ) {
						IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription( name );
						projectDescription.setLocationURI( target.toURI());
						project.create( projectDescription, monitor );

					} else {
						project.create( monitor );
					}

					project.open( monitor );
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
			String projectName = this.page.getCreationBean().getArtifactId();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject( projectName );

			String loc = this.page.getCreationBean().isMavenProject() ? "src/main/model/graph/main.graph" : "graph/main.graph";
			final IFile graphFile = project.getFile( loc );
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				IDE.openEditor( page, graphFile );

			} catch( PartInitException e ) {
				Activator.log( e, IStatus.ERROR );

			} finally {
				selectFileInResourceExplorer( graphFile );
			}

		} catch( Exception e ) {
			Activator.log( e, IStatus.ERROR );
			result = false;
		}

		return result;
	}


	/**
	 * Selects the graph file in an explorer.
	 * @param graphFile
	 */
	private void selectFileInResourceExplorer( IFile graphFile ) {

		// If possible, reuse an already open view
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart viewPart = page.findView( PROJECTS_VIEW );
		if( viewPart == null )
			viewPart = page.findView( PACKAGES_VIEW );

		try {
			// Otherwise, open it
			if( viewPart == null )
				viewPart = page.showView( PROJECTS_VIEW );

			// Select and expand
			try {
				Method getTreeViewerMethod = viewPart.getClass().getMethod( "getTreeViewer" );
				TreeViewer viewer = (TreeViewer) getTreeViewerMethod.invoke( viewPart );
				if( viewer != null )
					viewer.setSelection( new StructuredSelection( graphFile ), true );

			} catch( Exception e ) {
				viewPart.getViewSite().getSelectionProvider().setSelection( new StructuredSelection( graphFile ));
			}

		} catch( PartInitException e ) {
			Activator.log( e, IStatus.ERROR );
		}
	}
}
