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

package net.roboconf.eclipse.modeler.utilities;

import java.util.Objects;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.graphics.Image;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public final class EclipseUtils {

	/**
	 * Private empty constructor.
	 */
	private EclipseUtils() {
		// nothing
	}


	/**
	 * Resolves an EObject from a Sirius diagram.
	 * @param eo the object to resolve
	 * @return the underlying model object if it is a Sirius element, or the original object
	 */
	public static EObject resolve( EObject eo ) {

		if( eo instanceof DSemanticDecorator )
			eo  = ((DSemanticDecorator) eo).getTarget();

		return eo;
	}


	/**
	 * Finds an EObject from the selection.
	 * @param selection the selection (can be null)
	 * @return an EMF object, or null if the selection did not contain one
	 */
	public static EObject findEObjectFromSelection( ISelection selection ) {

		Object o = null;
		if( selection instanceof IStructuredSelection )
			o = ((IStructuredSelection) selection).getFirstElement();

		EObject eo = null;
		if( o instanceof IAdaptable ) {
			eo = ((IAdaptable) o).getAdapter( EObject.class );
			eo = EclipseUtils.resolve( eo );

		} else if( o instanceof EObject ) {
			eo = (EObject) o;
		}

		return eo;
	}


	/**
	 * Finds the Eclipse project containing a given EMF resource.
	 * @param eo an EMF object
	 * @return the Eclipse project that contains this resource
	 */
	public static IProject findProjectFrom( EObject eo ) {

		URI uri = eo.eResource().getURI();
		IPath path = new Path( uri.toPlatformString( true ));
		IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile( path );

		return iFile.getProject();
	}


	/**
	 * Finds the Eclipse project containing a given EMF resource.
	 * @param eo an EMF object
	 * @return the Eclipse directory that contains this resource
	 */
	public static IFolder findImagesDirectoryFrom( EObject eo ) {
		return findProjectFrom( eo ).getFolder( "images" );
	}


	/**
	 * Verifies if a resource is an image associated with the given name.
	 * @param res a workspace resource
	 * @param baseName the name of a Roboconf component or facet
	 * @return true if the image is associated with the name, false otherwise
	 */
	public static boolean isImageOf( IResource res, String baseName ) {

		String resName = Utils.removeFileExtension( res.getName());
		return Objects.equals( baseName, resName );
	}


	/**
	 * Deletes the image of a given facet or component.
	 * @param imgFolder the image folder
	 * @param baseName the name of a Roboconf component or facet
	 */
	public static void deleteImageOf( IContainer imgFolder, String baseName ) {

		try {
			IProgressMonitor monitor = new NullProgressMonitor();
			for( IResource res : imgFolder.members()) {
				if( isImageOf( res, baseName ))
					res.delete( true, monitor );
			}

		} catch( CoreException e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}
	}


	/**
	 * Finds the image associated with a Robconf type.
	 * @param imgFolder the folder containing images
	 * @param baseName the type's name
	 * @return the associated file, or null of no image was found
	 */
	public static IFile findImageOf( IContainer imgFolder, String baseName ) {

		IFile result = null;
		try {
			IResource[] members = new IResource[ 0 ];
			if( imgFolder.exists())
				members = imgFolder.members();

			for( IResource res : members ) {
				if( isImageOf( res, baseName )) {
					result = (IFile) res;
					break;
				}
			}

		} catch( CoreException e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}

		return result;
	}


	/**
	 * Finds the editing domain for an EMF object.
	 * @param eo an EMF object
	 * @return the editing domain, on null if none was found
	 */
	public static EditingDomain findEditingDomain( EObject eo ) {

		IEditingDomainProvider editingDomainProvider = null;
		if( eo != null && eo.eResource() != null ) {

			editingDomainProvider = (IEditingDomainProvider) EcoreUtil.getExistingAdapter(
					eo.eResource(),
					IEditingDomainProvider.class );

			if( editingDomainProvider == null
					&& eo.eResource().getResourceSet() instanceof IEditingDomainProvider ) {
				editingDomainProvider = (IEditingDomainProvider) eo.eResource().getResourceSet();

			} else {
				editingDomainProvider = (IEditingDomainProvider) EcoreUtil.getExistingAdapter(
						eo.eResource().getResourceSet(),
						IEditingDomainProvider.class );
			}
		}

		return editingDomainProvider == null ? null : editingDomainProvider.getEditingDomain();
	}


	/**
	 * Disposes a SWT image.
	 * @param img the image to dispose (can be null or already disposed)
	 */
	public static void dispose( Image img ) {

		if( img != null && ! img.isDisposed())
			img.dispose();
	}
}
