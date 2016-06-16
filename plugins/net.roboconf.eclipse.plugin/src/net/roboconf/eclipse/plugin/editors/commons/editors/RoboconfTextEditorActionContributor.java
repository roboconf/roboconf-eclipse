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

package net.roboconf.eclipse.plugin.editors.commons.editors;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.BasicTextEditorActionContributor;

import net.roboconf.eclipse.plugin.editors.commons.actions.EclipseCommentAction;
import net.roboconf.eclipse.plugin.editors.commons.actions.EclipseToggleCommentsAction;
import net.roboconf.eclipse.plugin.editors.commons.actions.EclipseUncommentAction;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfTextEditorActionContributor extends BasicTextEditorActionContributor {

	private final EclipseCommentAction commentAction;
	private final EclipseUncommentAction uncommentAction;
	private final EclipseToggleCommentsAction toggleCommentsAction;


	/**
	 * Constructor.
	 */
	public RoboconfTextEditorActionContributor() {
		super();
		this.commentAction = new EclipseCommentAction( null );
		this.uncommentAction = new EclipseUncommentAction( null );
		this.toggleCommentsAction = new EclipseToggleCommentsAction( null );
	}


	@Override
	public void contributeToMenu( IMenuManager menuManager ) {
		super.contributeToMenu( menuManager );

		MenuManager sourceMenu = new MenuManager( "Source" );
		menuManager.insertAfter( IWorkbenchActionConstants.MB_ADDITIONS, sourceMenu );
		sourceMenu.add( this.commentAction );
		sourceMenu.add( this.uncommentAction );
		sourceMenu.add( this.toggleCommentsAction );
	}


	@Override
	public void setActiveEditor( IEditorPart part ) {
		super.setActiveEditor( part );

		if( part instanceof TextEditor ) {
			this.commentAction.setTextEditor((TextEditor) part);
			this.uncommentAction.setTextEditor((TextEditor) part);
			this.toggleCommentsAction.setTextEditor((TextEditor) part);
		}
	}
}
