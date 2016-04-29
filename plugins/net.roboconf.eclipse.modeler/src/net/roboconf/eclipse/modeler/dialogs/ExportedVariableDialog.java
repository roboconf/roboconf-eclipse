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

package net.roboconf.eclipse.modeler.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.roboconf.core.Constants;
import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.core.utils.Utils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ExportedVariableDialog extends TitleAreaDialog {

	private String name, value, alias;


	/**
	 * Constructor.
	 * @param name
	 * @param value
	 * @param alias
	 */
	public ExportedVariableDialog( String name, String value, String alias ) {
		super( Display.getDefault().getActiveShell());
		this.name = name;
		this.value = value;
		this.alias = alias;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog
	 * #createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea( Composite parent ) {

		// Global UI
		Composite bigContainer = (Composite) super.createDialogArea( parent );
		GridLayoutFactory.swtDefaults().margins( 5, 0 ).applyTo( bigContainer );
		bigContainer.setLayoutData( new GridData( GridData.FILL_BOTH ));

		Composite container = new Composite( bigContainer, SWT.NONE );
		GridLayoutFactory.swtDefaults().margins( 0, 0 ).numColumns( 2 ).applyTo( container );
		container.setLayoutData( new GridData( GridData.FILL_BOTH ));

		getShell().setText( "Exported Variable" );
		setTitle( "Exported Variable" );
		setMessage( "Edit the properties of an exported variable." );

		// Add labels and so on...
		Label l = new Label( container, SWT.NONE );
		l.setText( "Name:" );
		l.setToolTipText( "The variable name" );

		Text nameText = new Text( container, SWT.SINGLE | SWT.BORDER );
		nameText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		if( this.name != null )
			nameText.setText( this.name );

		l = new Label( container, SWT.NONE );
		l.setText( "Default Value:" );
		l.setToolTipText( "The variable's default value" );

		Text valueText = new Text( container, SWT.SINGLE | SWT.BORDER );
		valueText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		if( this.value != null )
			valueText.setText( this.value );

		l = new Label( container, SWT.NONE );
		l.setText( "Alias (optional):" );
		l.setToolTipText( "The variable's alias, if it must be visible from other applications" );

		Text aliasText = new Text( container, SWT.SINGLE | SWT.BORDER );
		aliasText.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ));
		if( this.alias != null )
			aliasText.setText( this.alias );

		// Call-backs
		nameText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				ExportedVariableDialog.this.name = ((Text) e.widget).getText().trim();
				validate();
			}
		});

		valueText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				ExportedVariableDialog.this.value = ((Text) e.widget).getText().trim();
				validate();
			}
		});

		aliasText.addModifyListener( new ModifyListener() {
			@Override
			public void modifyText( ModifyEvent e ) {
				ExportedVariableDialog.this.alias = ((Text) e.widget).getText().trim();
				validate();
			}
		});

		return bigContainer;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}


	/**
	 * @return the alias
	 */
	public String getAlias() {
		return this.alias;
	}


	/**
	 * Validates the variable.
	 */
	private void validate() {

		String msg = null;
		if( Utils.isEmptyOrWhitespaces( this.name ))
			msg = "The variable name cannot be empty.";

		else if( ! this.name.matches( ParsingConstants.PATTERN_ID ))
			msg = "The variable name cannot contain spaces or special characters.";

		else if( Utils.isEmptyOrWhitespaces( this.value )
				&& ! Constants.SPECIFIC_VARIABLE_IP.equalsIgnoreCase( this.name ))
			msg = "The default's value cannot be empty.";

		else if( ! Utils.isEmptyOrWhitespaces( this.alias )
				&& ! this.alias.matches( ParsingConstants.PATTERN_ID ))
			msg = "When set, the public alias cannot contain white or special characters.";

		setErrorMessage( msg );
		getButton( IDialogConstants.OK_ID ).setEnabled( msg == null );
	}
}
