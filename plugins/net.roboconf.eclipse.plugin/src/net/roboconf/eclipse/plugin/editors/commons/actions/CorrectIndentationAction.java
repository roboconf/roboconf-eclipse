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

package net.roboconf.eclipse.plugin.editors.commons.actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class CorrectIndentationAction extends Action {

	private static final int LB_INDENT = 1;
	private TextEditor textEditor;


	/**
	 * Constructor.
	 * @param textEditor
	 */
	public CorrectIndentationAction( TextEditor textEditor ) {
		super( "Correct Indentation" );
		this.textEditor = textEditor;
	}


	/**
	 * @param textEditor the textEditor to set
	 */
	public void setTextEditor( TextEditor textEditor ) {
		this.textEditor = textEditor;
	}


	@Override
	public void run() {

		ISelection selection = this.textEditor.getSelectionProvider().getSelection();
		if( selection instanceof ITextSelection ) {
			ITextSelection textSelection = ((ITextSelection) selection);
			String text = textSelection.getText();

			List<String> lines = Arrays.asList( text.split( "\\n" ));
			StringBuilder sb = new StringBuilder();

			// Find the previous indentation
			IDocumentProvider dp = this.textEditor.getDocumentProvider();
			IDocument doc = dp.getDocument( this.textEditor.getEditorInput());
			int indent = 0;
			try {
				indent = findPreviousIndentation( doc.get( 0, textSelection.getOffset()));

			} catch( BadLocationException e ) {
				RoboconfEclipsePlugin.log( e, IStatus.ERROR );
			}

			// Update lines
			boolean splitLine = false;
			for( Iterator<String> it = lines.iterator(); it.hasNext(); ) {
				String line = it.next();

				// Pre-fix
				String workLine = RoboconfEclipseUtils.removeComments( line ).trim();
				if( workLine.startsWith( "}" ))
					indent --;

				// Add the line
				for( int i=0; i<indent; i++ )
					sb.append( "\t" );

				sb.append( line.replaceFirst( "^\\s*", "" ));
				if( it.hasNext())
					sb.append( "\n" );

				// Post-fix: find the next indentation
				if( workLine.endsWith( "{" )) {
					indent ++;

				} else if( ! splitLine && workLine.endsWith( "\\" )) {
					indent += LB_INDENT;
					splitLine = true;

				} else if( splitLine && workLine.endsWith( ";" )) {
					indent -= LB_INDENT;
					splitLine = false;
				}
			}

			// Update only if there are changes
			if( ! sb.toString().equals( text )) {
				try {
					doc.replace( textSelection.getOffset(), textSelection.getLength(), sb.toString());

				} catch( BadLocationException e ) {
					RoboconfEclipsePlugin.log( e, IStatus.ERROR );
				}
			}
		}
	}


	/**
	 * @param text a non-null text
	 * @return a null or positive integer
	 */
	private int findPreviousIndentation( String text ) {

		int indent = 0;
		List<String> lines = Arrays.asList( text.split( "\\n" ));
		Collections.reverse( lines );
		for( String line : lines ) {

			// Find a non-empty line
			if( Utils.isEmptyOrWhitespaces( line ))
				continue;

			// Count the number of tabulations at the beginning
			for( char c : line.toCharArray()) {
				if( c == '\t' )
					indent ++;
				else
					break;
			}

			// If we end with an opening curly bracket, increment by one
			String workLine = RoboconfEclipseUtils.removeComments( line ).trim();
			if( workLine.endsWith( "{" ))
				indent ++;

			break;
		}

		return indent;
	}
}
