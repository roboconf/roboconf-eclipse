/**
 * Copyright 2014-2015 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.plugin.editors;

import net.roboconf.eclipse.plugin.Activator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;

/**
 * FIXME: work on this class.
 * @author Vincent Zurczak - Linagora
 */
public class NonRuleBasedDamagerRepairer implements IPresentationDamager, IPresentationRepairer {

	protected IDocument fDocument;
	protected TextAttribute fDefaultTextAttribute;


	/**
	 * Constructor.
	 */
	public NonRuleBasedDamagerRepairer( TextAttribute defaultTextAttribute ) {
		Assert.isNotNull( defaultTextAttribute );
		this.fDefaultTextAttribute = defaultTextAttribute;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.presentation.IPresentationDamager
	 * #setDocument(org.eclipse.jface.text.IDocument)
	 */
	@Override
	public void setDocument( IDocument document ) {
		this.fDocument = document;
	}


	/**
	 * Returns the end offset of the line that contains the specified offset or
	 * if the offset is inside a line delimiter, the end offset of the next
	 * line.
	 *
	 * @param offset the offset whose line end offset must be computed
	 * @return the line end offset for the given offset
	 * @exception BadLocationException if offset is invalid in the current document
	 */
	protected int endOfLineOf( int offset ) throws BadLocationException {

		int result;
		IRegion info = this.fDocument.getLineInformationOfOffset( offset );
		if( offset <= info.getOffset() + info.getLength())
			result = info.getOffset() + info.getLength();

		int line = this.fDocument.getLineOfOffset( offset );
		try {
			info = this.fDocument.getLineInformation( line + 1 );
			result = info.getOffset() + info.getLength();

		} catch( BadLocationException x ) {
			result = this.fDocument.getLength();
		}

		return result;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.presentation.IPresentationDamager
	 * #getDamageRegion(org.eclipse.jface.text.ITypedRegion,org.eclipse.jface.text.DocumentEvent, boolean)
	 */
	@Override
	public IRegion getDamageRegion( ITypedRegion partition, DocumentEvent event, boolean documentPartitioningChanged ) {

		if( ! documentPartitioningChanged ) {
			try {
				IRegion info = this.fDocument.getLineInformationOfOffset( event.getOffset());
				int start = Math.max( partition.getOffset(), info.getOffset());

				int end = event.getOffset();
				end += event.getText() == null ? event.getLength() : event.getText().length();

				if( info.getOffset() <= end
						&& end <= info.getOffset() + info.getLength()) {
					// optimize the case of the same line
					end = info.getOffset() + info.getLength();
				} else {
					end = endOfLineOf( end );
				}

				end = Math.min( partition.getOffset() + partition.getLength(), end );
				return new Region( start, end - start );

			} catch( BadLocationException e ) {
				Activator.log( e, IStatus.WARNING );
			}
		}

		return partition;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.text.presentation.IPresentationRepairer
	 * #createPresentation(org.eclipse.jface.text.TextPresentation,
	 * org.eclipse.jface.text.ITypedRegion)
	 */
	@Override
	public void createPresentation( TextPresentation presentation, ITypedRegion region ) {
		addRange( presentation, region.getOffset(), region.getLength(), this.fDefaultTextAttribute );
	}


	/**
	 * Adds style information to the given text presentation.
	 *
	 * @param presentation the text presentation to be extended
	 * @param offset the offset of the range to be styled
	 * @param length the length of the range to be styled
	 * @param attr the attribute describing the style of the range to be styled
	 */
	protected void addRange( TextPresentation presentation, int offset, int length, TextAttribute attr ) {

		if( attr != null ) {
			StyleRange sr = new StyleRange( offset, length, attr .getForeground(), attr.getBackground(), attr.getStyle());
			presentation.addStyleRange( sr );
		}
	}
}
