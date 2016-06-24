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

package net.roboconf.eclipse.plugin.builder;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;

import net.roboconf.core.Constants;
import net.roboconf.core.ErrorCode;
import net.roboconf.core.ErrorCode.ErrorLevel;
import net.roboconf.core.RoboconfError;
import net.roboconf.core.model.ApplicationTemplateDescriptor;
import net.roboconf.core.model.ParsingError;
import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.plugin.RoboconfEclipseConstants;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.tooling.core.validation.ProjectValidator;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfIncrementalBuilder extends IncrementalProjectBuilder {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder
	 * #build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IProject[] build( int kind, Map<String,String> args, IProgressMonitor monitor )
	throws CoreException {

		// We do not validate files separately.
		// We perform a full build every time.
		// This is (partially) because the validation is handled externally.
		try {
			clean( monitor );

			IFolder rootFolder = findApplicationRootLocation();
			if( rootFolder != null ) {
				File appRoot = rootFolder.getLocation().toFile();
				Collection<RoboconfError> errors = ProjectValidator.validateProject( appRoot );
				mapRoboconfErrors( errors, monitor );
			}

		} catch( CoreException e ) {
			RoboconfEclipsePlugin.log( e, IStatus.ERROR );
		}

		return null;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder
	 * #clean(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected final void clean( IProgressMonitor monitor ) throws CoreException {

		// Remove markers from the file.
		if( getProject() != null )
			getProject().deleteMarkers( RoboconfEclipseConstants.MARKER_ID, true, IResource.DEPTH_INFINITE );

		super.clean( monitor );
	}


	/**
	 * Finds the pplication's root location.
	 * <p>
	 * Depending on the configuration, this can be "src/main/model"
	 * or it can be under "target".
	 * </p>
	 *
	 * @return a non-null file
	 */
	private IFolder findApplicationRootLocation() {
		// FIXME: it can be under "target" too.
		return (IFolder) getProject().findMember( "src/main/model/" );
	}


	/**
	 * Checks if the user selected the "cancel" button in the progress monitor.
	 * @param monitor the progress monitor
	 * @return true if the build was canceled, false otherwise
	 */
	private boolean checkCancel( IProgressMonitor monitor ) {

		boolean canceled = false;
		if( monitor != null && monitor.isCanceled()) {
			canceled = true;
			forgetLastBuiltState();
			throw new OperationCanceledException();
		}

		return canceled;
	}


	/**
	 * Maps Roboconf errors to the workspace resources.
	 * @param errors a non-null list of errors
	 * @param monitor the progress monitor
	 */
	private void mapRoboconfErrors( Collection<RoboconfError> errors, IProgressMonitor monitor ) {

		final IFolder mainFolder = findApplicationRootLocation();
		for( RoboconfError error : errors ) {

			// Build canceled?
			if( checkCancel( monitor ))
				break;

			// Create the error message
			StringBuilder sb = new StringBuilder();
			sb.append( error.getErrorCode().getMsg());
			if( ! Utils.isEmptyOrWhitespaces( error.getDetails()))
				sb.append( " " + error.getDetails());

			if( ! sb.toString().endsWith( "." ))
				sb.append( "." );

			// Resolve the location
			IResource res = null;
			int line = 1;
			if( error instanceof ParsingError ) {
				String name = ((ParsingError) error).getFile().getName();
				res = mainFolder.findMember( Constants.PROJECT_DIR_GRAPH + "/" + name );
				line = ((ParsingError) error).getLine();
			}

			// Special case: CO_GRAPH_COULD_NOT_BE_BUILT
			else if( error.getErrorCode() == ErrorCode.CO_GRAPH_COULD_NOT_BE_BUILT ) {
				File appFile = new File( mainFolder.getLocation().toFile(), Constants.PROJECT_DIR_DESC + "/" + Constants.PROJECT_FILE_DESCRIPTOR );
				try {
					ApplicationTemplateDescriptor appDesc = ApplicationTemplateDescriptor.load( appFile );
					String graphFile = appDesc.getGraphEntryPoint();
					res = mainFolder.findMember( Constants.PROJECT_DIR_GRAPH + "/" + graphFile );

				} catch( IOException e ) {
					RoboconfEclipsePlugin.log( e, IStatus.ERROR );
				}
			}

			// Otherwise, put the error on the project
			if( res == null || ! res.exists())
				res = getProject();

			// Create the marker
			try {
				int severity = IMarker.SEVERITY_ERROR;
				if( error.getErrorCode().getLevel() == ErrorLevel.WARNING )
					severity = IMarker.SEVERITY_WARNING;

				IMarker marker = res.createMarker( RoboconfEclipseConstants.MARKER_ID );
				marker.setAttribute( IMarker.LINE_NUMBER, line );
				marker.setAttribute( IMarker.PRIORITY, IMarker.PRIORITY_NORMAL );
				marker.setAttribute( IMarker.SEVERITY, severity );
				marker.setAttribute( IMarker.MESSAGE, sb.toString());
				marker.setAttribute( RoboconfEclipseConstants.MARKER_ERROR_CODE, error.getErrorCode().toString());

			} catch( CoreException e ) {
				RoboconfEclipsePlugin.log( e, IStatus.WARNING );
			}
		}
	}
}
