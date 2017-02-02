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

package net.roboconf.eclipse.modeler.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import net.roboconf.core.dsl.ParsingModelIo;
import net.roboconf.core.dsl.converters.FromGraphs;
import net.roboconf.core.dsl.parsing.FileDefinition;
import net.roboconf.core.model.beans.AbstractType;
import net.roboconf.core.model.beans.Component;
import net.roboconf.core.model.beans.ExportedVariable;
import net.roboconf.core.model.beans.Facet;
import net.roboconf.core.model.beans.Graphs;
import net.roboconf.core.model.beans.ImportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.plugin.wizards.NewRoboconfProjectWizard;

/**
 * @author Vincent Zurczak - Linagora
 */
public class GenerateRoboconfFilesWizard extends NewRoboconfProjectWizard {

	private IStructuredSelection selection;
	private RoboconfGraphs emfGraphs;

	private GenerateRoboconfFilesWizardPage choicePage;
	private WizardNewFileCreationPage singleFilePage;


	@Override
	public void init( IWorkbench workbench, IStructuredSelection selection ) {
		this.selection = selection;

		if( ! selection.isEmpty()) {
			Object o = selection.getFirstElement();
			if( o instanceof IFile ) {
				URI uri = URI.createURI(((IFile) o).getFullPath().toOSString());
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = resourceSet.getResource( uri, true );
				this.emfGraphs = (RoboconfGraphs) resource.getContents().get( 0 );
			}
		}

		if( this.emfGraphs == null )
			RoboconfModelerPlugin.log( "A *.graph-ui file was expected.", IStatus.ERROR );
	}


	@Override
	public void addPages() {

		// Choice page
		this.choicePage = new GenerateRoboconfFilesWizardPage( this.emfGraphs );
		addPage( this.choicePage );

		// Add the project page
		super.addPages();
		this.projectPage.setDescription( "Generate a new Roboconf project." );
		this.projectPage.setPageComplete( false );

		// Add another page for the file generation
		this.singleFilePage = new WizardNewFileCreationPage( "single.file.page", this.selection );
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

		if( this.emfGraphs == null ) {
			RoboconfModelerPlugin.log( "A *.graph-ui file was expected.", IStatus.ERROR );
			return;
		}

		// Convert the model.
		// Step one: create the Roboconf types and index them.
		// TODO: manage variables visible to other Roboconf applications.
		Map<RoboconfFacet,AbstractType> emfToNative = new HashMap<> ();
		for( RoboconfFacet facet : this.emfGraphs.getFacets()) {
			Facet f = new Facet( facet.getName());
			emfToNative.put( facet, f );

			for( RoboconfExportedVariable var : facet.getExports()) {
				ExportedVariable finalVar = new ExportedVariable( var.getName(), var.getDefaultValue());
				f.exportedVariables.put( finalVar.getName(), finalVar );
			}
		}

		for( RoboconfComponent comp : this.emfGraphs.getComponents()) {
			Component c = new Component( comp.getName()).installerName( comp.getInstallerName());
			emfToNative.put( comp, c );

			for( RoboconfExportedVariable var : comp.getExports()) {
				ExportedVariable finalVar = new ExportedVariable( var.getName(), var.getDefaultValue());
				c.exportedVariables.put( finalVar.getName(), finalVar );
			}

			for( RoboconfImportedVariable var : comp.getImports()) {
				ImportedVariable finalVar = new ImportedVariable( var.getName(), var.isOptional(), var.isExternal());
				c.importedVariables.put( finalVar.getName(), finalVar );
			}
		}

		// Step two: build the relations between types.
		// We only consider children and inheritance. Runtime is artificial
		// and is managed from imports and exports of variables.
		for( Map.Entry<RoboconfFacet,AbstractType> entry : emfToNative.entrySet()) {

			// Children.
			for( RoboconfFacet child : entry.getKey().getChildren()) {
				AbstractType genType = emfToNative.get( child );
				entry.getValue().addChild( genType );
			}

			// Inheritance for facets.
			if( entry.getValue() instanceof Facet ) {
				for( RoboconfFacet subType : entry.getKey().getSubTypes()) {
					AbstractType genType = emfToNative.get( subType );
					((Facet) entry.getValue()).extendFacet((Facet) genType);
				}
			}

			// Inheritance for components.
			else if( entry.getValue() instanceof Component ) {
				for( RoboconfFacet subType : entry.getKey().getSubTypes()) {
					AbstractType genType = emfToNative.get( subType );
					if( genType instanceof Facet )
						((Component) entry.getValue()).associateFacet((Facet) genType);
					else
						((Component) entry.getValue()).extendComponent((Component) genType);
				}
			}
		}

		// Step three: find roots components
		Graphs genGraphs = new Graphs();
		for( AbstractType type : emfToNative.values()) {
			if( type instanceof Facet )
				genGraphs.getFacetNameToFacet().put( type.getName(), (Facet) type);
			else if( type.getChildren().isEmpty())
				genGraphs.getRootComponents().add((Component) type);
		}

		// Serialize the model
		FileDefinition defToWrite = new FromGraphs().buildFileDefinition( genGraphs, mainGraphFile.getLocation().toFile(), true );
		try {
			ParsingModelIo.saveRelationsFile( defToWrite, true, "\n" );
			mainGraphFile.refreshLocal( IResource.DEPTH_ONE, new NullProgressMonitor());

		} catch( Exception e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}
	}


	@Override
	protected void overwriteInstancesFileContent( IFile instancesFile ) {

		try {
			// The instances file will be empty.
			instancesFile.setContents( new ByteArrayInputStream( new byte[ 0 ]), true, false, new NullProgressMonitor());

		} catch( CoreException e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}
	}
}
