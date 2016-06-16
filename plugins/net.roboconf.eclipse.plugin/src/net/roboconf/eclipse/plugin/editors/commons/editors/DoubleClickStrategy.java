/**
 * Copyright 2014-2016 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.plugin.editors.commons.editors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;

import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public class DoubleClickStrategy implements ITextDoubleClickStrategy {

	@Override
	public void doubleClicked( ITextViewer part ) {

		try {
			int caret = part.getSelectedRange().x;
			if( caret >= 0 ) {
				IDocument doc = part.getDocument();
				int startPos = caret, endPos = caret;

				// Find the word
				while( endPos < doc.getLength() && isValidWordCharacter( doc.getChar( endPos )))
					endPos ++;

				while( startPos > 0 && isValidWordCharacter( doc.getChar( startPos )))
					startPos --;

				// When the caret is at the document beginning
				if( startPos > 0 )
					startPos ++;

				part.setSelectedRange( startPos, endPos - startPos );
			}

		} catch( BadLocationException e ) {
			RoboconfEclipsePlugin.log( e, IStatus.WARNING );
		}
	}


	private boolean isValidWordCharacter( char c ) {
		return Character.isJavaIdentifierPart( c ) || c == '-';
	}
}
