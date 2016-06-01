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

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

import net.roboconf.eclipse.plugin.editors.commons.actions.CommentAction;
import net.roboconf.eclipse.plugin.editors.commons.actions.CorrectIndentationAction;
import net.roboconf.eclipse.plugin.editors.commons.actions.ToggleCommentsAction;
import net.roboconf.eclipse.plugin.editors.commons.actions.UncommentAction;

/**
 * @author Vincent Zurczak - Linagora
 */
public class AbstractRoboconfTextEditor extends TextEditor {

	protected final ColorManager colorManager;

	private CommentAction commentAction;
	private UncommentAction uncommentAction;
	private ToggleCommentsAction toggleCommentsAction;
	private CorrectIndentationAction correctIndentationAction;


	/**
	 * Constructor.
	 */
	public AbstractRoboconfTextEditor() {
		super();
		this.colorManager = new ColorManager();
	}


	@Override
	public void dispose() {
		this.colorManager.dispose();
		super.dispose();
	}


	@Override
	protected void createActions() {
		super.createActions();

		this.commentAction = new CommentAction( this );
		this.uncommentAction = new UncommentAction( this );
		this.toggleCommentsAction = new ToggleCommentsAction( this );
		this.correctIndentationAction = new CorrectIndentationAction( this );
	}


	@Override
	protected void editorContextMenuAboutToShow( IMenuManager menu ) {
		super.editorContextMenuAboutToShow( menu );

		boolean enabled = ((ITextSelection) getSelectionProvider().getSelection()).getLength() > 0;
		if( enabled ) {
			MenuManager sourceMenu = new MenuManager( "Source" );
			menu.appendToGroup( ITextEditorActionConstants.GROUP_EDIT, sourceMenu );

			sourceMenu.add( this.commentAction );
			sourceMenu.add( this.uncommentAction );
			sourceMenu.add( this.toggleCommentsAction );

			sourceMenu.add( new Separator());
			sourceMenu.add( this.correctIndentationAction );
		}
	}


	@Override
	public void doSave( IProgressMonitor progressMonitor ) {

		// Remove trailing spaces, except for the line currently edited
		IDocumentProvider dp = getDocumentProvider();
		IDocument doc = dp.getDocument( getEditorInput());
		ITextSelection textSelection = (ITextSelection) getSelectionProvider().getSelection();
		String text = doc.get();

		List<String> lines = Arrays.asList( text.split( "\\n" ));
		StringBuilder sb = new StringBuilder();

		int currentLine = 0, newOffset = 0;
		boolean currentLineWasFound = false;
		for( String line : lines ) {

			// Not the current line? Remove trailing spaces.
			if( currentLine != textSelection.getStartLine()) {
				line = line.replaceAll( "( |\t)*$", "" );
			}

			// Do not remove the trailing spaces AND keep track of the new offset.
			else {
				currentLineWasFound = true;
				newOffset += line.length();
			}

			currentLine ++;
			sb.append( line );
			sb.append( "\n" );

			// Update the new selection offset after update
			if( ! currentLineWasFound )
				newOffset += line.length() + 1;
		}

		// Update the document's content
		if( ! sb.toString().equals( text )) {
			doc.set( sb.toString());
			getSelectionProvider().setSelection( new TextSelection( doc, newOffset, 0 ));
		}

		// Save...
		super.doSave( progressMonitor );
	}
}
