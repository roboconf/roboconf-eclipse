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

package net.roboconf.eclipse.modeler.services;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ImageSelectionService {

	/**
	 * Gets the image for a Roboconf type.
	 * @param o the EMF object (to resolve the directory)
	 * @param name the type's name
	 * @param suffix "component" or "facet"
	 * @return the image's location
	 */
	private String findImage( EObject o, String name, String suffix ) {

		// Default
		String result = "/net.roboconf.eclipse.modeler/icons/default-" + suffix + ".svg";

		// Find the image in the project
		try {
			IFolder imgFolder = EclipseUtils.findImagesDirectoryFrom( o );
			IFile imgFile = EclipseUtils.findImageOf( imgFolder, name );
			if( imgFile != null && imgFile.exists())
				result = imgFile.getFullPath().toString();

		} catch( Exception e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}

		return result;
	}


	/**
	 * Gets the image for a component.
	 * @param comp the component
	 * @return the image's location
	 */
	public String getImage( RoboconfComponent comp ) {
		return findImage( comp, comp.getName(), "component" );
	}


	/**
	 * Gets the image for a facet.
	 * @param facet the facet
	 * @return the image's location
	 */
	public String getImage( RoboconfFacet facet ) {

		String result;
		if( facet instanceof RoboconfComponent )
			result = getImage((RoboconfComponent) facet);
		else
			result = findImage( facet, facet.getName(), "facet" );

		return result;
	}
}
