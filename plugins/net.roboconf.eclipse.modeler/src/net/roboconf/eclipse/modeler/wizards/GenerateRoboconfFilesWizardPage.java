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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;

/**
 * @author Vincent Zurczak - Linagora
 */
public class GenerateRoboconfFilesWizardPage extends WizardPage {

	public boolean generateProject = true;
	private final RoboconfGraphs emfGraphs;


	/**
	 * Constructor.
	 * @param emfGraphs the model that will be converted
	 */
	public GenerateRoboconfFilesWizardPage( RoboconfGraphs emfGraphs ) {
		super( "choice.page" );
		this.emfGraphs = emfGraphs;

		setTitle( "Generate Roboconf Files" );
		setDescription( "Select the generation options." );
	}


	@Override
	public void createControl( Composite parent ) {

		// Basic fields
		getShell().setText( "Generate Roboconf Files" );
		final Composite container = new Composite( parent, SWT.NONE );
		GridLayoutFactory.swtDefaults().numColumns( 2 ).extendedMargins( 15, 15, 20, 0 ).spacing( 15, 15 ).applyTo( container );
		container.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		setControl( container );

		// Project
		final Button projectButton = new Button( container, SWT.RADIO );
		projectButton.setSelection( this.generateProject );
		projectButton.setLayoutData( new GridData( SWT.TOP, SWT.TOP, false, false ));

		StringBuilder sb = new StringBuilder();
		sb.append( "Generate a new Eclipse project." );
		sb.append( "\n" );
		sb.append( "Generate a new project with various options: application name, output location, Maven properties, etc." );
		sb.append( "" );

		Label label1 = new Label( container, SWT.NONE );
		label1.setText( sb.toString());
		label1.setData( projectButton );

		// Graph(s) file
		final Button fileButton = new Button( container, SWT.RADIO );
		fileButton.setSelection( ! this.generateProject );
		fileButton.setLayoutData( new GridData( SWT.TOP, SWT.TOP, false, false ));

		sb = new StringBuilder();
		sb.append( "Generate a graph(s) file." );
		sb.append( "\n" );
		sb.append( "Generate a single file that contains the whole graph definitions" );
		sb.append( "" );

		Label label2 = new Label( container, SWT.NONE );
		label2.setText( sb.toString());
		label2.setData( fileButton );

		// Call backs
		Listener buttonListener = new Listener() {
			@Override
			public void handleEvent( Event event ) {
				GenerateRoboconfFilesWizardPage.this.generateProject = event.widget == projectButton;
				getWizard().getContainer().updateButtons();
			}
		};

		projectButton.addListener( SWT.Selection, buttonListener );
		fileButton.addListener( SWT.Selection, buttonListener );

		Listener labelListener = new Listener() {
			@Override
			public void handleEvent( Event event ) {
				projectButton.setSelection( false );
				fileButton.setSelection( false );

				((Button) event.widget.getData()).setSelection( true );
				Event evt = new Event();
				evt.widget = event.widget;
				((Button) event.widget.getData()).notifyListeners( SWT.Selection, evt );
			}
		};

		label1.addListener( SWT.MouseDown, labelListener );
		label2.addListener( SWT.MouseDown, labelListener );

		// Validate the page
		if( this.emfGraphs == null ) {
			setErrorMessage( "The selected file contains errors and could not be loaded." );
			setPageComplete( false );

		} else {
			IStatus status = ModelValidationService.getInstance().newValidator( EvaluationMode.BATCH ).validate(this.emfGraphs);
			if( status.getSeverity() == IStatus.WARNING ) {
				setErrorMessage( "The selected file contains minor errors (warnings)." );

			} else if( status.getSeverity() == IStatus.ERROR ) {
				setErrorMessage( "The selected file contains errors." );
				setPageComplete( false );
			}
		}
	}
}
