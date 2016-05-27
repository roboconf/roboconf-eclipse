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

import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public abstract class AbstractCommentAction extends Action {

	private TextEditor textEditor;


	/**
	 * Constructor.
	 * @param actionName
	 * @param textEditor
	 */
	public AbstractCommentAction( String actionName, TextEditor textEditor ) {
		super( actionName );
		this.textEditor = textEditor;
	}


	/**
	 * @param textEditor the textEditor to set
	 */
	public void setTextEditor( TextEditor textEditor ) {
		this.textEditor = textEditor;
	}


	/**
	 * All the lines are pre-processed.
	 * @param line a non-null line
	 */
	public void analyzeLine( String line ) {
		// nothing
	}


	/**
	 * Processes / Updates a line.
	 * @param line a non-null line
	 * @return a non-null line
	 */
	public abstract String processLine( String line );


//	@Override
//	public boolean isEnabled() {
//		return this.textEditor != null
//				&& ! this.textEditor.getSelectionProvider().getSelection().isEmpty();
//	}


	@Override
	public void run() {

		ISelection selection = this.textEditor.getSelectionProvider().getSelection();
		if( selection instanceof ITextSelection ) {
			ITextSelection textSelection = ((ITextSelection) selection);
			String text = textSelection.getText();

			List<String> lines = Arrays.asList( text.split( "\\n" ));
			for( String line : lines )
				analyzeLine( line );

			StringBuilder sb = new StringBuilder();
			for( Iterator<String> it = lines.iterator(); it.hasNext(); ) {
				String newLine = processLine( it.next());
				sb.append( newLine );
				if( it.hasNext())
					sb.append( "\n" );
			}

			// Update only if there are changes
			if( ! sb.toString().equals( text )) {
				IDocumentProvider dp = this.textEditor.getDocumentProvider();
				IDocument doc = dp.getDocument( this.textEditor.getEditorInput());
				try {
					doc.replace( textSelection.getOffset(), textSelection.getLength(), sb.toString());

				} catch( BadLocationException e ) {
					RoboconfEclipsePlugin.log( e, IStatus.ERROR );
				}
			}
		}
	}
}
