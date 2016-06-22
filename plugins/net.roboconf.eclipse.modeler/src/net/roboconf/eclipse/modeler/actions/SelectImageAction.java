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

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet;

/**
 * @author Vincent Zurczak - Linagora
 */
public class SelectImageAction implements IExternalJavaAction {

	private static final String[] EXTENSIONS = {
			"*.jpg;*.jpeg;*.gif;*.svg;*.png",
			"*.jpg", "*.jpeg", "*.gif", "*.png", "*.svg"
	};

	private static final String[] NAMES = {
			"All images (" + EXTENSIONS[ 0 ] + ")",
			"JPG images (" + EXTENSIONS[ 1 ] + ")",
			"JPEG images (" + EXTENSIONS[ 2 ] + ")",
			"GIF images (" + EXTENSIONS[ 3 ] + ")",
			"PNG images (" + EXTENSIONS[ 4 ] + ")",
			"SVG images (" + EXTENSIONS[ 5 ] + ")",
	};


	@Override
	public boolean canExecute( Collection<? extends EObject> selections ) {

		boolean canExecute = false;
		if( selections.size() == 1 ) {
			EObject eo = EclipseUtils.resolve( selections.iterator().next());
			canExecute = eo instanceof RoboconfComponent || eo instanceof RoboconfFacet;
		}

		return canExecute;
	}


	@Override
	public void execute( Collection<? extends EObject> selections, Map<String,Object> parameters ) {

		// Open a selection dialog
		FileDialog dialog = new FileDialog( new Shell(), SWT.OPEN );
		dialog.setFilterExtensions( EXTENSIONS );
		dialog.setFilterNames( NAMES );
		String result = dialog.open();

		// If a file was selected, import it in the project
		if( result != null ) {
			EObject eo = EclipseUtils.resolve( selections.iterator().next());
			IFolder imgFolder = EclipseUtils.findImagesDirectoryFrom( eo );
			try {
				if( ! imgFolder.exists())
					imgFolder.create( true, true, new NullProgressMonitor());

				// We can only select a component or a facet, and a component inherits from a facet.
				int index = result.lastIndexOf( '.' );
				String ext = result.substring( index );
				String name = ((RoboconfFacet) eo).getName();
				IFile targetFile = imgFolder.getFile( name + ext );

				// Delete the old image, if any
				EclipseUtils.deleteImageOf( imgFolder, name );

				// Copy the content then.
				Utils.copyStream( new File( result ), targetFile.getLocation().toFile());

				// Refresh the images directory.
				imgFolder.refreshLocal( IResource.DEPTH_ONE, new NullProgressMonitor());

			} catch( Exception e ) {
				RoboconfModelerPlugin.log( e, IStatus.ERROR );
			}
		}
	}
}
