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
import java.util.ArrayList;
import java.util.List;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.tooling.core.ProjectUtils.CreationBean;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Vincent Zurczak - Linagora
 */
public class NewProjectWizardPage extends WizardPage {

	private final CreationBean creationBean = new CreationBean();
	private boolean atDefaultLocation = true;
	private String wkLocation;

	private Text wkText;
	private Button wkButton;
	private Button useDefaultLocButton;


	/**
	 * Constructor.
	 */
	public NewProjectWizardPage() {
		super( "main.page" );

		this.creationBean.projectVersion( "1.0-SNAPSHOT" );
		this.creationBean.mavenProject( true );
		this.creationBean.pluginVersion( "0.4" );

		setTitle( "New Roboconf Project" );
		setDescription( "Create a new Roboconf project." );
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

		createLabel( container, "Name:", "The project's name" );
		Text text = createText( container );

		// The project name => in which directory create the content (generally, no space)
		// The project alias => how it is displayed in Roboconf (can include spaces)
		createLabel( container, "Alias:", "The project's name as seen in Roboconf" );
		final Text aliasText = createText( container );
		text.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				String projectName = ((Text) e.widget).getText();
				NewProjectWizardPage.this.creationBean.artifactId( projectName );
				String alias = projectName.replaceAll( "(_|-|\\s)+", " " );
				aliasText.setText( alias );

				IPath path = ResourcesPlugin.getWorkspace().getRoot().getLocation().append( projectName );
				NewProjectWizardPage.this.wkText.setText( path.toOSString());
				validate();
			}
		});

		aliasText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewProjectWizardPage.this.creationBean.projectName(((Text) e.widget).getText());
				validate();
			}
		});

		createLabel( container, "Description:", "The project's description" );
		text = createText( container );
		text.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewProjectWizardPage.this.creationBean.projectDescription(((Text) e.widget).getText());
				validate();
			}
		});

		createLabel( container, "Version:", "The project's version" );
		text = createText( container );
		text.setText( this.creationBean.getProjectVersion());
		text.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewProjectWizardPage.this.creationBean.projectVersion(((Text) e.widget).getText());
				validate();
			}
		});

		Button mavenButton = new Button( container, SWT.CHECK );
		mavenButton.setText( "Make this project a Maven project" );
		mavenButton.setSelection( this.creationBean.isMavenProject());
		GridDataFactory.swtDefaults().span( 2, 1 ).applyTo( mavenButton );

		final List<Control> controls = new ArrayList<Control> ();
		mavenButton.addSelectionListener( new SelectionAdapter() {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				boolean selection = ((Button) e.widget).getSelection();
				NewProjectWizardPage.this.creationBean.mavenProject( selection );
				updateWidgets( container, controls );
			}
		});

		updateWidgets( container, controls );


		// Project location
		this.useDefaultLocButton = new Button( container, SWT.CHECK );
		this.useDefaultLocButton.setText( "Create the project in the default location" );
		GridDataFactory.swtDefaults().indent( 0, 17 ).span( 2, 1 ).applyTo( this.useDefaultLocButton );
		this.useDefaultLocButton.setSelection( this.atDefaultLocation );

		final Label locLabel = createLabel( container, "Project location:", null );
		GridDataFactory.swtDefaults().span( 2, 1 ).applyTo( locLabel );

		createDirectoryBrowser( container );
		this.useDefaultLocButton.addSelectionListener( new SelectionAdapter () {
			@Override
			public void widgetSelected( SelectionEvent e ) {
				NewProjectWizardPage.this.atDefaultLocation = NewProjectWizardPage.this.useDefaultLocButton.getSelection();

				boolean use = ! NewProjectWizardPage.this.useDefaultLocButton.getSelection();
				locLabel.setEnabled( use );
				NewProjectWizardPage.this.wkButton.setEnabled( use );
				NewProjectWizardPage.this.wkText.setEnabled( use );
				NewProjectWizardPage.this.wkText.setFocus();
			}
		});


		// Last steps in the UI definition
		this.useDefaultLocButton.notifyListeners( SWT.Selection, new Event());
		setControl( container );
	}


	/**
	 * Display the error message provided as parameter and prevent the user from going further in the wizard.
	 * @param message the error message to display, or null to display nothing.
	 * @return always false
	 */
	protected final boolean updateStatus( String message ) {
		setErrorMessage( message );
		setPageComplete( message == null );
		return false;
	}


	/**
	 * Validate the page fields.
	 * @return true if all the elements are valid, false otherwise.
	 */
	protected boolean validate() {

		setMessage( null, INFORMATION );

		// Handle problems with the Maven configuration at the beginning of the wizard
//		if( ! PreferencesManager.isMavenTemplateConfigurationValid()) {
//			updateStatus( "There is an error in your preferences about custom POM templates." );
//			this.helpTooltip.show();
//			return false;
//		}

		boolean valid = true;
		try {
			if( Utils.isEmptyOrWhitespaces( this.creationBean.getArtifactId()))
				valid = updateStatus( "The project's name cannot be empty." );
			else if( Utils.isEmptyOrWhitespaces( this.creationBean.getProjectName()))
				valid = updateStatus( "The project's alias cannot be empty." );
			else if( Utils.isEmptyOrWhitespaces( this.creationBean.getProjectVersion()))
				valid = updateStatus( "The project's version cannot be empty." );

			else if( this.creationBean.isMavenProject() && Utils.isEmptyOrWhitespaces( this.creationBean.getPluginVersion()))
				valid = updateStatus( "The Maven plug-in's version cannot be empty." );

			else if( this.creationBean.isMavenProject()
					&& Utils.isEmptyOrWhitespaces( this.creationBean.getGroupId()))
				valid = updateStatus( "The project's group ID cannot be empty." );

			else if( this.creationBean.isMavenProject()
					&& this.creationBean.getGroupId().endsWith( "." ))
				valid = updateStatus( "The project's group ID cannot end with a dot." );

			else if( this.creationBean.isMavenProject()
					&& this.creationBean.getGroupId().startsWith( "." ))
				valid = updateStatus( "The project's group ID cannot start with a dot." );

			else for( IResource resource : ResourcesPlugin.getWorkspace().getRoot().members()) {
				if( resource.getName().equalsIgnoreCase( this.creationBean.getProjectName())) {
					valid = updateStatus( "A project called '" + this.creationBean.getProjectName() + "' already exists in the workspace." );
					break;
				}
			}

		} catch( CoreException e ) {
			RoboconfEclipsePlugin.log( e, IStatus.ERROR );
		}

		// Project location
		String projectName = this.creationBean.getArtifactId();
		if( ! this.atDefaultLocation && valid ) {
			if( Utils.isEmptyOrWhitespaces( this.wkText.getText()))
				valid = updateStatus( "You have to specify the project's location." );

			else try {
				File targetDirectory = new File( this.wkText.getText());
				IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject( projectName );
				IStatus status = ResourcesPlugin.getWorkspace().validateProjectLocationURI( p, targetDirectory.toURI());
				if( status.getCode() != IStatus.OK )
					valid = updateStatus( status.getMessage());

			} catch( Exception e ) {
				valid = updateStatus( "The specified location is not a valid file location." );
			}
		}

		// Clear the dialog's error message if necessary
		if( valid )
			updateStatus( null );

		return valid;
	}


	/**
	 * @return the target directory
	 */
	public File getTargetDirectory() {
		return this.atDefaultLocation ? null : new File( this.wkLocation );
	}


	/**
	 * @return the creationBean
	 */
	public CreationBean getCreationBean() {
		return this.creationBean;
	}


	/**
	 * Updates the widgets related to Maven.
	 * @param container
	 * @param controls
	 */
	private void updateWidgets( Composite container, List<Control> controls ) {

		for( Control control : controls )
			control.dispose();

		controls.clear();
		if( this.creationBean.isMavenProject()) {

			controls.add( createLabel( container, "Group ID:", "The project's group ID" ));
			Text text = createText( container );
			controls.add( text );
			text.addModifyListener( new ModifyListener() {
				@Override
				public void modifyText( ModifyEvent e ) {
					String s = ((Text) e.widget).getText();
					NewProjectWizardPage.this.creationBean.groupId( s );
					validate();
				}
			});

			controls.add( createLabel( container, "Plug-in version:", "The version of the Roboconf Maven plug-in" ));
			text = createText( container );
			controls.add( text );
			if( ! Utils.isEmptyOrWhitespaces( this.creationBean.getPluginVersion()))
				text.setText( this.creationBean.getPluginVersion());

			text.addModifyListener( new ModifyListener() {
				@Override
				public void modifyText( ModifyEvent e ) {
					NewProjectWizardPage.this.creationBean.pluginVersion(((Text) e.widget).getText());
					validate();
				}
			});
		}

		// Put these widgets at the right location
		if( this.useDefaultLocButton != null ) {
			for( Control control : controls )
				control.moveAbove( this.useDefaultLocButton );
		}

		container.layout();
	}


	/**
	 * Creates a directory browser, with a text and a button to open a directory dialog.
	 * @param parent the parent
	 * @return the created composite, with a text containing the file selection
	 */
	private void createDirectoryBrowser( final Composite parent ) {

		Composite container = new Composite( parent, SWT.NONE );
		GridLayoutFactory.swtDefaults().numColumns( 2 ).margins( 0, 0 ).applyTo( container );
		GridDataFactory.swtDefaults().span( 2, 1 ).align( SWT.FILL, SWT.TOP ).grab( true, false ).applyTo( container );

		this.wkText = new Text( container, SWT.SINGLE | SWT.BORDER );
		this.wkText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		this.wkText.setText( ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
		this.wkText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				NewProjectWizardPage.this.wkLocation = ((Text) e.widget).getText();
			}
		});

		this.wkButton = new Button( container, SWT.PUSH );
		this.wkButton.setText( "Browse..." );
		this.wkButton.addSelectionListener( new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				DirectoryDialog dlg = new DirectoryDialog( parent.getShell(), SWT.NONE );
				dlg.setText( "Select a Directory" );
				String fn = dlg.open();

				if( fn != null ) {
					NewProjectWizardPage.this.wkText.setText( fn );
					NewProjectWizardPage.this.wkText.setSelection( fn.length());
				}
			}
		});
	}


	/**
	 * @param container
	 * @param text
	 * @param tooltip
	 * @return
	 */
	static Label createLabel( Composite container, String text, String tooltip ) {

		Label label = new Label( container, SWT.NONE );
		label.setText( text );
		label.setToolTipText( tooltip );

		return label;
	}


	/**
	 * @param container
	 * @return
	 */
	static Text createText( Composite container ) {

		Text text = new Text( container, SWT.SINGLE | SWT.BORDER );
		text.setLayoutData( new GridData( SWT.FILL, SWT.TOP, true, false ));

		return text;
	}
}
