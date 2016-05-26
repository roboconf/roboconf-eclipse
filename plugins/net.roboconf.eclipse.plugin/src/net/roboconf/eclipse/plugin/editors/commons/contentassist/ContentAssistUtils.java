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

package net.roboconf.eclipse.plugin.editors.commons.contentassist;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

/**
 * @author Vincent Zurczak - Linagora
 */
public final class ContentAssistUtils {

	/**
	 * Constructor.
	 */
	private ContentAssistUtils() {
		// nothing
	}


	/**
	 * A convenience method to shorten the creation of a basic proposal.
	 * @param s
	 * @param lastWord
	 * @param offset
	 * @return a non-null proposal
	 */
	public static ICompletionProposal basicProposal( String s, String lastWord, int offset ) {
		return new CompletionProposal(
				s,
				offset - lastWord.length(),
				lastWord.length(),
				s.length());
	}


	/**
	 * @param s (not null)
	 * @param prefix (not null)
	 * @return true if s starts with prefix (case insensitively)
	 */
	public static boolean startsWith( String s, String prefix ) {
		return s.toLowerCase().startsWith( prefix.toLowerCase());
	}


	/**
	 * @return the file that contains the application to parse (can be null)
	 */
	public static File findApplicationDirectory() {

		File result = null;
		IEditorInput input = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		if( input instanceof IFileEditorInput ) {
			IProject p = ((IFileEditorInput) input).getFile().getProject();

			// We do not always have a Maven project
			IResource root = p.getFolder( new Path( "src/main/model" ));
			if( ! root.exists())
				root = p;

			result = root.getLocation().toFile();
		}

		return result;
	}


	/**
	 * @return the file that is being edited (can be null)
	 */
	public static File findEditedFile() {

		File result = null;
		IEditorInput input = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		if( input instanceof IFileEditorInput )
			result = ((IFileEditorInput) input).getFile().getLocation().toFile();

		return result;
	}
}
