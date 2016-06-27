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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.ISetSelectionTarget;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public class NewModelFileWizard extends Wizard implements INewWizard {

	private WizardNewFileCreationPage newFileCreationPage;
	private IStructuredSelection selection;
	private ResourceSet resourceSet;

	private final String viewpointURI, fileExt, diagramName;


	/**
	 * Constructor.
	 */
	public NewModelFileWizard() {
		super();
		this.viewpointURI = WizardConstants.VIEWPOINT_ID;
		this.fileExt = WizardConstants.EXT_MODEL;
		this.diagramName = "Roboconf Graph(s) Representation";
	}


	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}


	@Override
	public void addPages() {

		// Create the page
		this.newFileCreationPage = new WizardNewFileCreationPage( "page", this.selection );
		this.newFileCreationPage.setAllowExistingResources( true );
		this.newFileCreationPage.setFileExtension( WizardConstants.EXT_MODEL );
		this.newFileCreationPage.setTitle( "title" );
		this.newFileCreationPage.setDescription( "desc" );
		this.newFileCreationPage.setFileName( "model." + this.fileExt ); // $NON-NLS-1$

		addPage( this.newFileCreationPage );

		// When possible, initialize the new file's location from the selection
		if( this.selection != null && !this.selection.isEmpty()) {

			Object selectedElement = this.selection.iterator().next();
			if( !( selectedElement instanceof IResource ))
				return;

			IResource selectedResource = (IResource) selectedElement;
			if( selectedResource.getType() == IResource.FILE )
				selectedResource = selectedResource.getParent();

			if( selectedResource instanceof IFolder
					|| selectedResource instanceof IProject )
				this.newFileCreationPage.setContainerFullPath( selectedResource.getFullPath());
		}
	}


	@Override
	public boolean performFinish() {

		// Create the operation to run
		final IFile modelFile = getModelFile();
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(final IProgressMonitor progressMonitor) {

				try {
					// Model creation
					NewModelFileWizard.this.resourceSet = new ResourceSetImpl();
					URI fileURI = URI.createPlatformResourceURI( modelFile.getFullPath().toString(), true);
					final Resource resource = NewModelFileWizard.this.resourceSet.createResource( fileURI );

					WizardUtils.createModel( resource );
					WizardUtils.save( resource );

					// File selection
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					final IWorkbenchPart activePart = page.getActivePart();
					if( activePart instanceof ISetSelectionTarget ) {
						getShell().getDisplay().asyncExec( new Runnable() {

							@Override
							public void run() {
								ISelection targetSelection = new StructuredSelection( modelFile );
								((ISetSelectionTarget) activePart).selectReveal( targetSelection );
							}
						});
					}

					// Show the right perspective
					PlatformUI.getWorkbench().showPerspective(
							WizardUtils.MODELING_PERSPECTIVE_ID,
							PlatformUI.getWorkbench().getActiveWorkbenchWindow());

					// Add the right project nature, if necessary
					IProject project = modelFile.getProject();
					if (!project.hasNature("org.eclipse.sirius.nature.modelingproject")) {
						ModelingProjectManager.INSTANCE.convertToModelingProject(project,
								new NullProgressMonitor());
					}

					// Prepare the diagram
					final Session session = ModelingProject.asModelingProject(project).get().getSession();
					session.getTransactionalEditingDomain().getCommandStack().
					execute( new RecordingCommand( session.getTransactionalEditingDomain()) {
						@Override
						protected void doExecute() {
							session.addSemanticResource( resource.getURI(), new NullProgressMonitor());
						}
					});

					WizardUtils.enableViewpoint( session, NewModelFileWizard.this.viewpointURI );
					String diagramInstanceName = Utils.removeFileExtension( modelFile.getName());
					EObject root = WizardUtils.getRoot( session, resource.getURI());

					WizardUtils.openDiagram(
							progressMonitor,
							modelFile.
							getProject(),
							NewModelFileWizard.this.diagramName,
							diagramInstanceName, root);

				} catch( Exception exception ) {
					RoboconfModelerPlugin.log( exception, IStatus.ERROR );

				} finally {
					progressMonitor.done();
				}
			}
		};

		// Run the operation
		try {
			getContainer().run( false, false, operation );

		} catch ( Exception exception ) {
			RoboconfModelerPlugin.log( exception, IStatus.ERROR );
		}

		return true;
	}


	/**
	 * @return the model file
	 */
	public IFile getModelFile() {
		IPath path = this.newFileCreationPage.getContainerFullPath();
		path = path.append( this.newFileCreationPage.getFileName());
		return ResourcesPlugin.getWorkspace().getRoot().getFile( path );
	}
}
