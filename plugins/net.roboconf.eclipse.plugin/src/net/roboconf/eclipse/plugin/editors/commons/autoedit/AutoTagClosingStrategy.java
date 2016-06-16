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

package net.roboconf.eclipse.plugin.editors.commons.autoedit;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public class AutoTagClosingStrategy implements IAutoEditStrategy {

	@Override
	public void customizeDocumentCommand( IDocument document, DocumentCommand command ) {

		// "{" => insert "}" right after.
		if( command.text.equals( "{" )) {
			command.text += "}";
			command.caretOffset = command.offset + +1;
			command.shiftsCaret = false;
		}

		// We wrote an instance property but we forgot the semicolon at the end of the line.
		else if( command.text.startsWith( "\n" )) {
			StringBuilder sb = new StringBuilder();
			try {
				for( int i=command.offset - 1; i>=0; i-- ) {
					char c = document.getChar( i );
					if( c == '\n' || c == '\r' )
						break;

					sb.insert( 0, c );
				}

				String s = sb.toString().trim();
				if( s.contains( ":" )
						&& ! s.contains( "#" )
						&& ! s.endsWith( ";" ))
					command.text = ";" + command.text;

			} catch( BadLocationException e ) {
				// Should not happen
				RoboconfEclipsePlugin.log( e, IStatus.ERROR );
			}
		}
	}
}
