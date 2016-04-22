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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public class GenerationDialog extends TitleAreaDialog {

	private Image image;


	/**
	 * Constructor.
	 * @param parentShell
	 * @param facet
	 */
	public GenerationDialog( Shell parentShell ) {
		super( parentShell );
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
		GridLayoutFactory.swtDefaults().margins( 0, 0 ).applyTo( container );
		container.setLayoutData( new GridData( GridData.FILL_BOTH ));

		getShell().setText( "Workspace Explorer" );
		setTitle( "Workspace Explorer" );
		setMessage( "Browse the workspace." );

		// Add labels and so on...
		new Label( container, SWT.DEFAULT ).setText( "Current Image:" );
		Label previewLabel = new Label( container, SWT.DEFAULT );

		Composite buttonsContainer = new Composite( container, SWT.DEFAULT );
		GridLayoutFactory.swtDefaults().margins( 0, 0 ).numColumns( 2 ).applyTo( buttonsContainer );

		Button deleteButton = new Button( buttonsContainer, SWT.PUSH );
		deleteButton.setText( "Delete this Image" );
		deleteButton.setToolTipText( "The default image will be used then" );

		Button editButton = new Button( buttonsContainer, SWT.PUSH );
		editButton.setText( "Select another Image" );
		editButton.setToolTipText( "Use another image" );



		return bigContainer;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	@Override
	public boolean close() {

		boolean result = super.close();
		try {
			if( this.image != null
					&& ! this.image.isDisposed())
				this.image.dispose();

		} catch( Exception e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}

		return result;
	}
}
