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

package net.roboconf.eclipse.modeler.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import net.roboconf.eclipse.modeler.wizards.GenerateRoboconfFilesWizard;

/**
 * @author Vincent Zurczak - Linagora
 */
public class GenerateFilesCommand extends AbstractHandler {

	@Override
	public Object execute( ExecutionEvent event ) throws ExecutionException {

		// Get the workbench's selection
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		IStructuredSelection ss;
		if( selection instanceof IStructuredSelection )
			ss = (IStructuredSelection) selection;
		else
			ss = new StructuredSelection();

		// Create the wizard and initialize it
		GenerateRoboconfFilesWizard wizard = new GenerateRoboconfFilesWizard();
		wizard.init( null, ss );

		// Show it in a new dialog
		WizardDialog wd = new  WizardDialog( Display.getDefault().getActiveShell(), wizard );
		wd.setTitle( wizard.getWindowTitle());
		wd.open();

		return null;
	}
}
