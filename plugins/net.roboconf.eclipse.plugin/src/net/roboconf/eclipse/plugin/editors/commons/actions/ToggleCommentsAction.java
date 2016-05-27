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

import org.eclipse.ui.editors.text.TextEditor;

import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.core.utils.Utils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ToggleCommentsAction extends AbstractCommentAction {

	private int uncommented = 0;


	/**
	 * Constructor.
	 * @param textEditor
	 */
	public ToggleCommentsAction( TextEditor textEditor ) {
		super( "Toggle Comments", textEditor );
	}


	@Override
	public void analyzeLine( String line ) {

		if( ! Utils.isEmptyOrWhitespaces( line )
				&& ! line.trim().startsWith( ParsingConstants.COMMENT_DELIMITER ))
			this.uncommented ++;
	}


	@Override
	public String processLine( String line ) {

		// If there are uncommented lines, toggle means comment them all.
		// Otherwise, uncomment them.
		String result = line;
		if( this.uncommented > 0 )
			result = CommentAction.commentLine( line );
		else
			result = UncommentAction.uncommentLine( line );

		return result;
	}
}
