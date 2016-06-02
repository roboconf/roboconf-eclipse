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

package net.roboconf.eclipse.modeler.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Extension;
import org.occiware.clouddesigner.occi.OCCIFactory;
import org.occiware.clouddesigner.occi.OCCIRegistry;
import org.occiware.clouddesigner.occi.design.utils.WizardUtils;

import com.google.common.collect.Maps;

import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public class NewModelProjectWizard extends BasicNewProjectResourceWizard {

	private IProject project;
	private WizardNewProjectCreationPage page;


	@Override
	public boolean performFinish() {

		// The workspace operation
		final IRunnableWithProgress op = new WorkspaceModifyOperation( null ) {
			@Override
			protected void execute( IProgressMonitor monitor ) throws CoreException, InterruptedException {

				final String modelFileName = NewModelProjectWizard.this.project.getName() + "." + WizardConstants.EXT_MODEL;
				final InitExtensionModel init = new InitExtensionModel( NewModelProjectWizard.this.project, modelFileName );
				try {
					getContainer().run( false, true, init );

				} catch( InterruptedException e ) {
					// nothing

				} catch( InvocationTargetException e ) {
					RoboconfModelerPlugin.log( e, IStatus.ERROR );
				}

				// Get the newly created file
				final IResource newModelFile = NewModelProjectWizard.this.project.findMember( "/model/" + modelFileName );
				selectAndReveal( newModelFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());

				// Switch to the modeling perspective
				PlatformUI.getWorkbench().showPerspective(
						WizardUtils.MODELING_PERSPECTIVE_ID,
						PlatformUI.getWorkbench().getActiveWorkbenchWindow());

				Session session = ModelingProject.asModelingProject( NewModelProjectWizard.this.project ).get().getSession();
				EObject rootObject = WizardUtils.getRoot( session, init.semanticModelURI );
				WizardUtils.openDiagram(
						monitor, NewModelProjectWizard.this.project,
						"Diagram",	// A representation kind, as defined in the odesign file.
						modelFileName,
						rootObject );
			}
		};

		// Create the runnable
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

				// Create the project
				try {
					NewModelProjectWizard.this.project = ModelingProjectManager.INSTANCE.createNewModelingProject(
							NewModelProjectWizard.this.page.getProjectName(),
							NewModelProjectWizard.this.page.getLocationPath(),
							true, monitor);

					ModelingProject.asModelingProject( NewModelProjectWizard.this.project ).get().getSession().getSelectedViewpoints( false );

				} catch( CoreException e ) {
					RoboconfModelerPlugin.log( e, IStatus.ERROR );
				}

				// Verify the project was correctly created.
				if( NewModelProjectWizard.this.project == null )
					throw new IllegalArgumentException();

				// Update the workspace
				try {
					getContainer().run( false, true, op );
					NewModelProjectWizard.this.project.refreshLocal( IResource.DEPTH_INFINITE, monitor );

				} catch( InvocationTargetException e ) {
					if( e.getTargetException() instanceof CoreException ) {
						CoreException ce = (CoreException) e.getTargetException();
						ErrorDialog.openError( getContainer().getShell(), "Error", "An error occured while completing the wizard.", ce.getStatus());

					} else {
						RoboconfModelerPlugin.log( e, IStatus.ERROR );
					}

				} catch( Exception e ) {
					RoboconfModelerPlugin.log( e, IStatus.ERROR );
				}
			}
		};

		// Execute it
		try {
			getContainer().run( false, false, runnable );

		} catch( Exception e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}

		return true;
	}


	@Override
	public void addPages() {

		this.page = new WizardNewProjectCreationPage( "New Diagram Project for Roboconf Graph(s)" );
		this.page.setInitialProjectName( "" );
		this.page.setTitle( "New Project" );
		this.page.setDescription( "Create a new graphical modeling project for Roboconf." );

		addPage( this.page );
	}



	/**
	 * Widely inspired from OCCIware's extension project wizard.
	 * @author Vincent Zurczak - Linagora
	 */
	private static class InitExtensionModel extends WorkspaceModifyOperation {

		private final IProject project;
		private final String modelFileName;
		private URI semanticModelURI;


		/**
		 * Constructor.
		 */
		public InitExtensionModel( IProject project, String modelFileName ) {
			super( null );
			this.project = project;
			this.modelFileName = modelFileName;
		}


		@Override
		protected void execute( IProgressMonitor monitor )
		throws CoreException, InterruptedException {

			final Option<ModelingProject> created = ModelingProject.asModelingProject( this.project );
			if( created.some()) {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						// Create default empty Extension model
						createSemanticResource();

						// Enable OCCI viewpoints
						final ModelingProject modelingProject = created.get();
						WizardUtils.enableViewpoint( modelingProject.getSession(), WizardConstants.VIEWPOINT_ID );
					}
				});
			}
		}


		/**
		 * @return
		 */
		private Option<IFile> createSemanticResource() {

			final Configuration rootObject = OCCIFactory.eINSTANCE.createConfiguration();
			rootObject.setDescription( "Graph(s) model for " + this.project.getName());

			final Option<ModelingProject> modelingProject = ModelingProject.asModelingProject( this.project );
			final Session session = modelingProject.get().getSession();
			final String platformPath = "/" + this.project.getName() + "/model/" + this.modelFileName;
			session.getTransactionalEditingDomain().getCommandStack().execute(
					new RecordingCommand( session.getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {

					// Load the (empty) model
					InitExtensionModel.this.semanticModelURI = URI.createPlatformResourceURI( platformPath, true );
					final Resource res = session.getSessionResource().getResourceSet().createResource( InitExtensionModel.this.semanticModelURI );

					// Populate the model
					String[] refSchemes = {
							"http://schemas.ogf.org/occi/core#",
							//"http://roboconf.net/graph/ecore"
					};

					for( String scheme : refSchemes ) {
						String refExtensionURI = OCCIRegistry.getInstance().getExtensionURI( scheme );
						final Resource refExtensionResource = res.getResourceSet().getResource(URI.createURI(refExtensionURI, true), true);
						final Extension refExtension = (Extension) refExtensionResource.getContents().get(0);
						rootObject.getUse().add(refExtension);
					}

					res.getContents().add( rootObject );

					// Save the model
					try {
						res.save( Maps.newHashMap());

					} catch (final IOException e) {
						RoboconfModelerPlugin.log( e, IStatus.ERROR );
					}

					session.addSemanticResource( InitExtensionModel.this.semanticModelURI, new NullProgressMonitor());
					session.save( new NullProgressMonitor());
				}
			});

			return Options.newSome( ResourcesPlugin.getWorkspace().getRoot().getFile(new Path( platformPath )));
		}
	}
}
