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

import java.util.ArrayList;
import java.util.List;

import net.roboconf.core.dsl.ParsingConstants;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfGraphScanner extends RuleBasedScanner {

	/**
	 * Constructor.
	 * @param manager
	 */
	public RoboconfGraphScanner( ColorManager manager ) {

		IToken hl = new Token( new TextAttribute( manager.getColor( ColorManager.HL_KEYWORD ), null, SWT.BOLD ));
		IToken properties = new Token( new TextAttribute( manager.getColor( ColorManager.PROPERTY_NAME )));

		WordRule keywordsRule = new WordRule( new WordDetector(), Token.UNDEFINED, true );
		keywordsRule.addWord( ParsingConstants.KEYWORD_FACET, hl );
		keywordsRule.addWord( ParsingConstants.KEYWORD_IMPORT, hl );

		keywordsRule.addWord( ParsingConstants.PROPERTY_COMPONENT_FACETS, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_COMPONENT_IMPORTS, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_COMPONENT_INSTALLER, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_COMPONENT_OPTIONAL_IMPORT, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_GRAPH_EXTENDS, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_GRAPH_CHILDREN, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_GRAPH_EXPORTS, properties );

		List<IRule> rules = new ArrayList<IRule> ();
		rules.add( new WhitespaceRule( new WhitespaceDetector()));
		rules.add( keywordsRule );

		setRules( rules.toArray( new IRule[ 0 ]));
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	public static class WordDetector implements IWordDetector {

		@Override
		public boolean isWordStart( char c ) {
			return Character.isLetter( c );
		}

		@Override
		public boolean isWordPart( char c ) {
			return ! Character.isWhitespace( c ) && c != ':' && c != '{';
		}
	}
}
