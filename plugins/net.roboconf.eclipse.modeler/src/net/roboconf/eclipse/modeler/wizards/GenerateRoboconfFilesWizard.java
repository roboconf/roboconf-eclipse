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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import net.roboconf.core.dsl.ParsingModelIo;
import net.roboconf.core.dsl.converters.FromGraphs;
import net.roboconf.core.dsl.parsing.FileDefinition;
import net.roboconf.core.model.beans.Graphs;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.plugin.wizards.NewRoboconfProjectWizard;

/**
 * @author Vincent Zurczak - Linagora
 */
public class GenerateRoboconfFilesWizard extends NewRoboconfProjectWizard {

	private final ISelection selection;
	private GenerateRoboconfFilesWizardPage choicePage;
	private WizardNewFileCreationPage singleFilePage;


	/**
	 * Constructor.
	 */
	public GenerateRoboconfFilesWizard() {
		this.selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
	}


	@Override
	public void addPages() {

		// Choice page
		this.choicePage = new GenerateRoboconfFilesWizardPage();
		addPage( this.choicePage );

		// Add the project page
		super.addPages();
		this.projectPage.setDescription( "Generate a new Roboconf project." );
		this.projectPage.setPageComplete( false );

		// Add another page for the file generation
		IStructuredSelection ss = new StructuredSelection();
		if( this.selection instanceof IStructuredSelection )
			ss = (IStructuredSelection) this.selection;

		this.singleFilePage = new WizardNewFileCreationPage( "single.file.page", ss );
		this.singleFilePage.setAllowExistingResources( true );
		this.singleFilePage.setTitle( "Generate a Roboconf Graph" );
		this.singleFilePage.setDescription( "Generate the definition of a Roboconf graph." );
		this.singleFilePage.setFileExtension( "graph" );
		this.singleFilePage.setFileName( "main.graph" );

		addPage( this.singleFilePage );
	}


	@Override
	public IWizardPage getNextPage( IWizardPage page ) {

		IWizardPage nextPage = null;
		if( page == this.choicePage ) {
			nextPage = this.choicePage.generateProject ? this.projectPage : this.singleFilePage;
		}

		return nextPage;
	}


	@Override
	public boolean canFinish() {
		return this.choicePage.generateProject ? this.projectPage.isPageComplete() : this.singleFilePage.isPageComplete();
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard
	 * #performFinish()
	 */
	@Override
	public boolean performFinish() {
		boolean result = true;

		// Generate a whole project
		if( this.choicePage.generateProject ) {
			result = super.performFinish();
		}

		// Generate a single file
		else {
			IPath filePath = this.singleFilePage.getContainerFullPath().append( this.singleFilePage.getFileName());
			final IFile fileToCreate = ResourcesPlugin.getWorkspace().getRoot().getFile( filePath );

			WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
				@Override
				protected void execute( IProgressMonitor monitor )
				throws CoreException, InvocationTargetException, InterruptedException {

					try {
						monitor.beginTask( "Creating the file cotnent...", 6 );
						overwriteGraphFileContent( fileToCreate );
						monitor.worked( 6 );

					} catch( Exception e ) {
						throw new InvocationTargetException( e );

					} finally {
						monitor.done();
					}
				}
			};

			try {
				// Run the operation.
				getContainer().run( true, false, op );

				// Open the graph file
				showFile( fileToCreate );

			} catch( Exception e ) {
				RoboconfModelerPlugin.log( e, IStatus.ERROR );
				result = false;
			}
		}

		return result;
	}


	@Override
	protected void overwriteGraphFileContent( IFile mainGraphFile ) {

		// Find the selected file
		IFile graphUiFile = null;
		if( this.selection instanceof IStructuredSelection
				&& ! this.selection.isEmpty()) {

			Object o = ((IStructuredSelection) this.selection).getFirstElement();
			if( o instanceof IFile )
				graphUiFile = (IFile) o;
		}

		if( graphUiFile == null ) {
			RoboconfModelerPlugin.log( "A *.graph-ui file was expected.", IStatus.ERROR );
			return;
		}

		// Load the model
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource( URI.createURI( graphUiFile.getFullPath().toOSString()), true );
		RoboconfGraphs config = (RoboconfGraphs) resource.getContents().get( 0 );

		List<RoboconfFacet> allTypes = new ArrayList<> ();
		allTypes.addAll( config.getFacets());
		allTypes.addAll( config.getComponents());

		// Convert the model.
		// Step one: create the Roboconf types.
//		Map<String,AbstractType> typeNameToType = new HashMap<> ();
//		for( RoboconfFacet type : allTypes ) {
//
//			// Start the conversion
//			boolean isComp = type instanceof RoboconfComponent;
//			AbstractType finalType = isComp ? new Component() : new Facet();
//			finalType.setName( type.getName());
//			typeNameToType.put( type.getName(), finalType );
//
//			// Exports
//			for( RoboconfExportedVariable var : type.getExports()) {
//				RoboconfExportedVariable rawVar = (RoboconfExportedVariable) link.getTarget();
//				ExportedVariable finalVar = new ExportedVariable( rawVar.getName(), rawVar.getDefaultValue());
//				finalType.exportedVariables.put( finalVar.getName(), finalVar );
//			}
//
//			if( ! isComp )
//				continue;
//
//			// Imports => only if we have a component
//			for( RoboconfImportedVariable var : ((RoboconfComponent) type).getImports()) {
//				ImportedVariable finalVar = new ImportedVariable( var.getName(), var.isOptional(), var.isExternal());
//				((Component) finalType).importedVariables.put( finalVar.getName(), finalVar );
//			}
//		}
//
//		// Step two: build the relations between types.
//		for( RoboconfFacet type : allTypes ) {
//
//			// Start the conversion
//			boolean isComp = type instanceof RoboconfComponent;
//
//			AbstractType sourceType = typeNameToType.get( rawType.getName());
//			if( sourceType == null ) {
//				RoboconfModelerPlugin.log( "Type not found during conversion (source): " + rawType.getName(), IStatus.ERROR );
//				continue;
//			}
//
//			for( Link link : rawType.getLinks()) {
//				if( !( link.getTarget() instanceof RoboconfFacet )) {
//					// Ignore (can be a owner link).
//					continue;
//				}
//
//				RoboconfFacet target = (RoboconfFacet) link.getTarget();
//				AbstractType targetType = typeNameToType.get( target.getName());
//				if( targetType == null ) {
//					RoboconfModelerPlugin.log( "Type not found during conversion (target): " + target.getName(), IStatus.ERROR );
//					continue;
//				}
//
//				// Inheritance
//				if( link instanceof RoboconfInheritanceLink ) {
//					if( isComp && targetType instanceof Facet )
//						((Component) sourceType).associateFacet((Facet) targetType);
//					else if( targetType instanceof Facet )
//						((Facet) sourceType).extendFacet((Facet) targetType);
//					else if( isComp )
//						((Component) sourceType).extendComponent((Component) targetType);
//				}
//
//				// Children
//				else if( link instanceof RoboconfChildrenLink ) {
//					sourceType.addChild( targetType );
//				}
//			}
//		}
//
//		// Step three: find roots components
//		Graphs graphs = new Graphs();
//		for( Map.Entry<String,AbstractType> entry : typeNameToType.entrySet()) {
//			if( entry.getValue() instanceof Facet )
//				graphs.getFacetNameToFacet().put( entry.getKey(), (Facet) entry.getValue());
//			else if( entry.getValue().getChildren().isEmpty())
//				graphs.getRootComponents().add((Component) entry.getValue());
//		}

		// Serialize the model
		Graphs graphs = new Graphs();
		FileDefinition defToWrite = new FromGraphs().buildFileDefinition( graphs, mainGraphFile.getLocation().toFile(), true );
		try {
			ParsingModelIo.saveRelationsFile( defToWrite, true, "\n" );
			mainGraphFile.refreshLocal( IResource.DEPTH_ONE, new NullProgressMonitor());

		} catch( Exception e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}
	}
}
