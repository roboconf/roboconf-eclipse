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

package net.roboconf.eclipse.plugin.editors.graphs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.eclipse.plugin.editors.commons.contentassist.CompletionProposalWithSelection;
import net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils;
import net.roboconf.tooling.core.autocompletion.GraphsCompletionProposer;
import net.roboconf.tooling.core.autocompletion.ICompletionProposer.RoboconfCompletionProposal;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfGraphCompletionProcessor implements IContentAssistProcessor {

	@Override
	public ICompletionProposal[] computeCompletionProposals( ITextViewer viewer, int offset ) {

		// Proposals finding is handled in roboconf-tooling-core
		List<RoboconfCompletionProposal> proposals;
		File appDirectory = ContentAssistUtils.findApplicationDirectory();
		File editedFile = ContentAssistUtils.findEditedFile();

		if( editedFile == null ) {
			RoboconfEclipsePlugin.log( "The edited file coud not be retrieved.", IStatus.ERROR );
			proposals = new ArrayList<>( 0 );

		} else {
			GraphsCompletionProposer proposer = new GraphsCompletionProposer( appDirectory, editedFile );
			try {
				String text = viewer.getDocument().get( 0, offset );
				proposals = proposer.findProposals( text );

			} catch( BadLocationException e ) {
				RoboconfEclipsePlugin.log( e, IStatus.ERROR );
				proposals = new ArrayList<>( 0 );
			}
		}

		// Now, build the Eclipse proposals
		ICompletionProposal[] result = new ICompletionProposal[ proposals.size()];
		for( int i=0; i<result.length; i++ ) {
			RoboconfCompletionProposal p = proposals.get( i );
			result[ i ] = new CompletionProposalWithSelection( viewer, p, offset );
		}

		return result;
	}


	@Override
	public IContextInformation[] computeContextInformation( ITextViewer viewer, int offset ) {
		return new IContextInformation[ 0 ];
	}


	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[ 0 ];
	}


	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return new char[ 0 ];
	}


	@Override
	public String getErrorMessage() {
		return null;
	}


	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
}
