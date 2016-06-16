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

package net.roboconf.eclipse.modeler;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfModelerPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "net.roboconf.eclipse.modeler";

	// The shared instance
	private static RoboconfModelerPlugin plugin;
	private Set<Viewpoint> viewpoints;


	/**
	 * Constructor.
	 */
	public RoboconfModelerPlugin() {
		// nothing
	}


	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		this.viewpoints = new HashSet<> ();
		this.viewpoints.addAll( ViewpointRegistry.getInstance().registerFromPlugin(
				PLUGIN_ID + "/description/graph.odesign" ));
	}


	@Override
	public void stop(BundleContext context) throws Exception {

		plugin = null;
		if (this.viewpoints != null) {
			for (final Viewpoint viewpoint: this.viewpoints) {
				ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
			}

			this.viewpoints.clear();
			this.viewpoints = null;
		}

		super.stop(context);
	}


	/**
	 * @return the shared instance
	 */
	public static RoboconfModelerPlugin getDefault() {
		return plugin;
	}


	/**
	 * Logs an exception.
	 * @param e the exception to log
	 * @param severity the severity, given as one of the {@link IStatus} constants
	 */
	public static void log( Exception e, int severity ) {

		String msg = e.getMessage();
		if( msg == null || msg.trim().length() == 0 )
			msg = "An error occurred.";

		IStatus status = new Status( severity, PLUGIN_ID, msg, e );
		getDefault().getLog().log( status );
	}


	/**
	 * Logs a message.
	 * @param message the message to log
	 * @param severity the severity, given as one of the {@link IStatus} constants
	 */
	public static void log( String message, int severity ) {
		IStatus status = new Status( severity, PLUGIN_ID, message );
		getDefault().getLog().log( status );
	}


	public static Image findImage( String filePath ) {

		ImageDescriptor desc = imageDescriptorFromPlugin( PLUGIN_ID, filePath );
		Image img = null;
		try {
			img = desc.createImage();

		} catch( Exception e ) {
			log( "Image " + filePath + " could not be found.", IStatus.ERROR );
		}

		return img;
	}
}
