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

package net.roboconf.eclipse.plugin.editors.commons.contentassist;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.link.EditorLinkedModeUI;

import net.roboconf.tooling.core.SelectionRange;
import net.roboconf.tooling.core.autocompletion.ICompletionProposer.RoboconfCompletionProposal;

/**
 * @author Vincent Zurczak - Linagora
 */
public class CompletionProposalWithSelection implements ICompletionProposal {

	private final String replacementString, displayString, additionalProposalInfo;
	private final List<SelectionRange> ranges;
	private final int offset, length;
	private final ITextViewer viewer;


	/**
	 * Constructor.
	 * @param viewer
	 * @param proposal
	 * @param offset
	 */
	public CompletionProposalWithSelection(
			ITextViewer viewer,
			RoboconfCompletionProposal proposal,
			int offset ) {

		// Basic fields
		this.replacementString = proposal.getProposalString();
		this.displayString = proposal.getProposalName();
		this.additionalProposalInfo = proposal.getProposalDescription();
		this.ranges = proposal.getSelection();
		this.viewer = viewer;

		// More tricky ones
		this.length = proposal.getReplacementOffset();
		this.offset = offset - proposal.getReplacementOffset();

		// Update the ranges' offset (relative => absolute)
		for( SelectionRange range : this.ranges )
			range.setOffset( range.getOffset() + offset );
	}


	@Override
	public void apply( IDocument document ) {

		// Replacement...
		try {
			document.replace( this.offset, this.length, this.replacementString );

		} catch( BadLocationException x ) {
			// nothing
		}

		// Select "place holders" (those that can be selected automatically by typing in "tab")
		if( this.ranges.size() == 0 )
			return;

		try {
			LinkedModeModel model = new LinkedModeModel();
			for( int i=0; i<this.ranges.size(); i++ ) {
				SelectionRange range = this.ranges.get( i );
				LinkedPositionGroup group = new LinkedPositionGroup();
				group.addPosition( new LinkedPosition( document, range.getOffset(), range.getLength(), i ));
				model.addGroup( group );
			}

			model.forceInstall();

			LinkedModeUI ui = new EditorLinkedModeUI( model, this.viewer );
			ui.setExitPolicy( new DeleteBlockingExitPolicy(document));
			ui.setExitPosition( this.viewer, this.offset, 0, LinkedPositionGroup.NO_STOP );
			ui.enter();

		} catch( BadLocationException e ) {
			// nothing
		}
	}


	@Override
	public Point getSelection( IDocument document ) {

		Point result;
		if( this.ranges.size() > 0 )
			result = new Point( this.ranges.get( 0 ).getOffset(), this.ranges.get( 0 ).getLength());
		else
			result = new Point( this.offset + this.replacementString.length(), 0 );

		return result;
	}


	@Override
	public String getAdditionalProposalInfo() {
		return this.additionalProposalInfo;
	}


	@Override
	public String getDisplayString() {
		return this.displayString;
	}


	@Override
	public Image getImage() {
		return null;
	}


	@Override
	public IContextInformation getContextInformation() {
		return null;
	}


	/**
	 * Copied from tern.java plug-ins.
	 * <p>
	 * An exit policy that skips Backspace and Delete at the beginning and at the end
	 * of a linked position, respectively.
	 * </p>
	 *
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=183925 .
	 */
	private static class DeleteBlockingExitPolicy implements IExitPolicy {
		private final IDocument fDocument;

		public DeleteBlockingExitPolicy(IDocument document) {
			this.fDocument= document;
		}

		@Override
		public ExitFlags doExit(LinkedModeModel model, VerifyEvent event, int offset, int length) {
			if (length == 0 && (event.character == SWT.BS || event.character == SWT.DEL)) {
				LinkedPosition position= model.findPosition(new LinkedPosition(this.fDocument, offset, 0, LinkedPositionGroup.NO_STOP));
				if (position != null) {
					if (event.character == SWT.BS) {
						if (offset - 1 < position.getOffset()) {
							//skip backspace at beginning of linked position
							event.doit= false;
						}
					} else /* event.character == SWT.DEL */ {
						if (offset + 1 > position.getOffset() + position.getLength()) {
							//skip delete at end of linked position
							event.doit= false;
						}
					}
				}
			}

			return null; // don't change behavior
		}
	}
}
