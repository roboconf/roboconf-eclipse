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
import net.roboconf.eclipse.plugin.editors.RoboconfGraphScanner.WordDetector;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfInstancesScanner extends RuleBasedScanner {

	/**
	 * Constructor.
	 * @param manager
	 */
	public RoboconfInstancesScanner( ColorManager manager ) {

		IToken hl = new Token( new TextAttribute( manager.getColor( ColorManager.HL_KEYWORD ), null, SWT.BOLD ));
		IToken properties = new Token( new TextAttribute( manager.getColor( ColorManager.PROPERTY_NAME )));

		WordRule keywordsRule = new WordRule( new WordDetector(), Token.UNDEFINED, true );
		keywordsRule.addWord( ParsingConstants.KEYWORD_IMPORT, hl );

		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_CHANNELS, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_COUNT, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_DATA, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_NAME, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_STATE, properties );

		List<IRule> rules = new ArrayList<IRule> ();
		rules.add( new WhitespaceRule( new WhitespaceDetector()));
		rules.add( keywordsRule );
		rules.add( new InstanceOfRule( hl ));

		setRules( rules.toArray( new IRule[ 0 ]));
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class InstanceOfRule implements IRule {
		private int comparedLength = 0;
		private final IToken token;


		public InstanceOfRule( IToken token ) {
			this.token = token;
		}

		@Override
		public IToken evaluate( ICharacterScanner scanner ) {

			// Find the key word
			char c = '#';
			while( c != ICharacterScanner.EOF
					&& c != '\n'
					&& c != '\r'
					&& this.comparedLength < ParsingConstants.KEYWORD_INSTANCE_OF.length()) {

				c = (char) scanner.read();
				char expectedChar = ParsingConstants.KEYWORD_INSTANCE_OF.charAt( this.comparedLength );
				if( expectedChar == Character.toLowerCase( c ))
					this.comparedLength ++;
				else
					break;
			}

			// Make sure it is not "instance oftruc"
			IToken result = null;
			if( this.comparedLength == ParsingConstants.KEYWORD_INSTANCE_OF.length()) {
				int read = scanner.read();
				this.comparedLength ++;
				if( Character.isWhitespace(( char) read )
						|| read == ICharacterScanner.EOF )
					result = this.token;
			}

			// Rewind if necessary
			if( result == null ) {
				result = Token.UNDEFINED;
				for( int i = this.comparedLength; i != 0; i-- )
					scanner.unread();
			}

			this.comparedLength = 0;
			return result;
		}
	}
}
