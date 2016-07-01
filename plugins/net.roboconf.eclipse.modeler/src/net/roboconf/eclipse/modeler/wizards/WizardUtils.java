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

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.ui.IEditorPart;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfFactory;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.modeler.RoboconfModelerPlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public final class WizardUtils {

	/**
	 * Private empty constructor.
	 */
	private WizardUtils() {
		// nothing
	}


	/**
	 * Gets a representation description.
	 * @param eObject the model
	 * @param sessionthe Sirius session
	 * @param representationDescriptionId
	 * @return Representation description
	 */
	public static RepresentationDescription getRepresentationDescription(
			EObject eObject,
			Session session,
			String representationDescriptionId ) {

		final Collection<RepresentationDescription> representationDescriptions =
				DialectManager.INSTANCE
				.getAvailableRepresentationDescriptions( session.getSelectedViewpoints( true ), eObject );

		RepresentationDescription result = null;
		for( final RepresentationDescription representationDescription : representationDescriptions ) {
			if( representationDescriptionId.equals( representationDescription.getName())) {
				result = representationDescription;
				break;
			}
		}

		return result;
	}


	/**
	 * Opens a diagram (the perspective must be the modeling one).
	 */
	public static void openDiagram(
			final IProgressMonitor monitor,
			IProject project,
			String diagramName,
			final String diagramInstanceName,
			final EObject rootObject) {

		final Option<ModelingProject> optionalModelingProject = ModelingProject.asModelingProject(project);
		if( optionalModelingProject.some()) {
			final Session session = optionalModelingProject.get().getSession();
			final RepresentationDescription representationDescription = getRepresentationDescription( rootObject, session, diagramName );

			RecordingCommand createcommand = new RecordingCommand( session.getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {
					DRepresentation representation = DialectManager.INSTANCE.createRepresentation(
							diagramInstanceName, rootObject,
							representationDescription, session, monitor
					);

					// Open the editor.
					IEditorPart part = DialectUIManager.INSTANCE.openEditor( session, representation, monitor );

					// Sometimes, the editor is marked as dirty.
					part.doSave( monitor );
				}
			};
			try {
				session.getTransactionalEditingDomain().getCommandStack().execute( createcommand );

			} catch( Exception e ) {
				RoboconfModelerPlugin.log( e, IStatus.ERROR );
			}
		}
	}


	/**
	 * Enables a viewpoint.
	 * @param session
	 */
	public static void enableViewpoint( final Session session, final String viewpointURI ) {

		if( session == null)
			return;

		session.getTransactionalEditingDomain().getCommandStack()
		.execute(new RecordingCommand( session.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {

				final ViewpointSelectionCallback selection = new ViewpointSelectionCallback();
				URI uri = URI.createURI(viewpointURI);
				selection.selectViewpoint(
						ViewpointRegistry.getInstance().getViewpoint( uri ), session,
						new NullProgressMonitor());
			}
		});
	}


	/**
	 * Gets the root object.
	 * @param session the Sirius session
	 * @param resourceURI the resource's URI
	 * @return the model's root object
	 */
	public static EObject getRoot( Session session, URI resourceURI ) {

		EObject result = null;
		for( Resource resource : session.getSemanticResources()) {
			if( resource.getURI().equals( resourceURI )) {
				result = resource.getContents().get( 0 );
				break;
			}
		}

		return result;
	}


	/**
	 * Creates a model and associates it with a resource.
	 * @param resource a non-null resource
	 */
	public static void createModel( Resource resource ) {

		RoboconfGraphs graphs = RoboconfEmfFactory.eINSTANCE.createRoboconfGraphs();
		resource.getContents().add( graphs );
	}


	/**
	 * Saves the model associated with a resource.
	 * @param resource a non-null resource
	 */
	public static void save( Resource resource ) {

		Map<Object,Object> saveOptions = new HashMap<> ();
		saveOptions.put( XMIResource.OPTION_ENCODING, "UTF-8" );
		try {
			resource.save( saveOptions );

		} catch( IOException e ) {
			RoboconfModelerPlugin.log( e, IStatus.ERROR );
		}
	}
}
