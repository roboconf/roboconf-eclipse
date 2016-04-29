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

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import net.roboconf.eclipse.plugin.wizards.NewProjectWizard;

/**
 * @author Vincent Zurczak - Linagora
 */
public class GenerateRoboconfFilesWizard extends NewProjectWizard {

	private ChoiceWizardPage choicePage;
	private SingleFileWizardPage singleFilePage;


	@Override
	public void addPages() {

		// Choice page
		this.choicePage = new ChoiceWizardPage();
		addPage( this.choicePage );

		// Add the project page
		super.addPages();
		this.projectPage.setDescription( "Generate a new Roboconf project." );
		this.projectPage.setPageComplete( false );

		// Add another page for the file generation
		this.singleFilePage = new SingleFileWizardPage();
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
		if( this.choicePage.generateProject )
			result = super.performFinish();

		// TODO: generate the graph from the model

		return result;
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class ChoiceWizardPage extends WizardPage {

		private boolean generateProject = true;


		/**
		 * Constructor.
		 */
		public ChoiceWizardPage() {
			super( "choice.page" );

			setTitle( "Generate Roboconf Files" );
			setDescription( "Select the generation options." );
		}


		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.IDialogPage
		 * #createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl( Composite parent ) {

			// Basic fields
			getShell().setText( "Generate Roboconf Files" );
			final Composite container = new Composite( parent, SWT.NONE );
			GridLayoutFactory.swtDefaults().numColumns( 2 ).extendedMargins( 15, 15, 20, 0 ).spacing( 15, 15 ).applyTo( container );
			container.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));

			// Project
			final Button projectButton = new Button( container, SWT.RADIO );
			//projectButton.setImage( this.projectImg );
			projectButton.setSelection( this.generateProject );
			projectButton.setLayoutData( new GridData( SWT.TOP, SWT.TOP, false, false ));

			StringBuilder sb = new StringBuilder();
			sb.append( "Generate a new Eclipse project." );
			sb.append( "\n" );
			sb.append( "Generate a new project with various options: application name, output location, Maven properties, etc." );
			sb.append( "" );
			new Label( container, SWT.NONE ).setText( sb.toString());

			// Graph(s) file
			Button fileButton = new Button( container, SWT.RADIO );
			//fileButton.setImage( this.fileImg );
			fileButton.setSelection( ! this.generateProject );
			fileButton.setLayoutData( new GridData( SWT.TOP, SWT.TOP, false, false ));

			sb = new StringBuilder();
			sb.append( "Generate a graph(s) file." );
			sb.append( "\n" );
			sb.append( "Generate a single file that contains the whole graph definitions" );
			sb.append( "" );
			new Label( container, SWT.NONE ).setText( sb.toString());

			// Call backs
			Listener listener = new Listener() {
				@Override
				public void handleEvent( Event event ) {
					ChoiceWizardPage.this.generateProject = event.widget == projectButton;
					getWizard().getContainer().updateButtons();
				}
			};

			projectButton.addListener( SWT.Selection, listener );
			fileButton.addListener( SWT.Selection, listener );

			setControl( container );
		}
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class SingleFileWizardPage extends WizardPage {

		/**
		 * Constructor.
		 */
		public SingleFileWizardPage() {
			super( "single.file.page" );

			setTitle( "Generate a Roboconf Graph" );
			setDescription( "Generate the definition of a Roboconf graph." );
		}


		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.IDialogPage
		 * #createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl( Composite parent ) {

			// Basic fields
			final Composite container = new Composite( parent, SWT.NONE );
			GridLayoutFactory.swtDefaults().numColumns( 2 ).extendedMargins( 15, 15, 20, 0 ).spacing( 15, 5 ).applyTo( container );
			container.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));

			// TODO: Project
			Label l = new Label( container, SWT.NONE );
			l.setText( "Not implemented" );
			setPageComplete( false );

			setControl( container );
		}
	}
}
