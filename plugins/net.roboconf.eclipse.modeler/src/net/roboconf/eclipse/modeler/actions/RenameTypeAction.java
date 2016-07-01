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

package net.roboconf.eclipse.modeler.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Display;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.modeler.emfconstraints.TypeNameConstraint;
import net.roboconf.eclipse.modeler.emfconstraints.UniqueNameConstraint;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RenameTypeAction implements IExternalJavaAction {

	private RoboconfFacet facetOrComponent;


	@Override
	public boolean canExecute( Collection<? extends EObject> selections ) {

		this.facetOrComponent = null;
		if( selections.size() == 1 ) {
			EObject eo = EclipseUtils.resolve( selections.iterator().next());
			if( eo instanceof RoboconfFacet )
				this.facetOrComponent = (RoboconfFacet) eo;
		}

		return this.facetOrComponent != null;
	}


	@Override
	public void execute( Collection<? extends EObject> selections, Map<String,Object> parameters ) {

		IInputValidator validator = new IInputValidator() {
			@Override
			public String isValid( String newText ) {

				String msg = new TypeNameConstraint().validate( newText );
				if( msg == null )
					msg = new UniqueNameConstraint().validate( RenameTypeAction.this.facetOrComponent, newText );

				return msg;
			}
		};

		InputDialog dlg = new InputDialog(
				Display.getDefault().getActiveShell(),
				"New Name",
				"Change the name of the selected element.",
				this.facetOrComponent.getName(),
				validator );

		if( dlg.open() == Window.OK ) {
			String newName = dlg.getValue();
			String oldName = this.facetOrComponent.getName();

			// Rename the image
			IFolder imgFolder = EclipseUtils.findImagesDirectoryFrom( this.facetOrComponent );
			IFile imgFile = EclipseUtils.findImageOf( imgFolder, oldName );

			IFile targetFile = null;
			if( imgFile != null && imgFile.exists()) {
				String targetFileName = newName + "." + imgFile.getFileExtension();
				targetFile = imgFile.getParent().getFile( new Path( targetFileName ));
			}

			// TargetFile can only be defined if the
			// source image exists.
			try {
				if( targetFile != null
						&& ! targetFile.exists()) {

					imgFile.move(
							targetFile.getFullPath(),
							true, new NullProgressMonitor());
				}

			} catch( CoreException e ) {
				RoboconfModelerPlugin.log( e, IStatus.ERROR );
			}

			// Perform the modifications within a transactional command
			EditingDomain domain = EclipseUtils.findEditingDomain( this.facetOrComponent );
			CompoundCommand cmd = new CompoundCommand();

			// Rename the component
			cmd.append( new SetCommand( domain, this.facetOrComponent, RoboconfEmfPackage.Literals.ROBOCONF_FACET__NAME, newName ));

			// Rename all the imported variables that need it
			for( RoboconfComponent component : ((RoboconfGraphs) this.facetOrComponent.eContainer()).getComponents()) {
				for( RoboconfImportedVariable var : component.getImports()) {
					if( ! var.getName().startsWith( oldName + "." ))
						continue;

					String newVarName = var.getName().replace( oldName + ".", newName + "." );
					cmd.append( new SetCommand( domain, var, RoboconfEmfPackage.Literals.ROBOCONF_IMPORTED_VARIABLE__NAME, newVarName ));
				}
			}

			// Execute the command
			domain.getCommandStack().execute( cmd );
		}
	}
}
