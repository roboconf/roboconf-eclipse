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

package net.roboconf.eclipse.plugin.editors.instances;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.eclipse.plugin.editors.commons.editors.ColorManager;
import net.roboconf.eclipse.plugin.editors.commons.editors.WhitespaceDetector;
import net.roboconf.eclipse.plugin.editors.commons.editors.WordDetector;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfInstancesScanner extends RuleBasedScanner {

	/**
	 * Constructor.
	 * @param manager
	 */
	public RoboconfInstancesScanner( ColorManager manager ) {

		// Our tokens with their styles.
		IToken hl = new Token( new TextAttribute( manager.getColor( ColorManager.HL_KEYWORD ), null, SWT.BOLD ));
		IToken properties = new Token( new TextAttribute( manager.getColor( ColorManager.PROPERTY_NAME )));

		// The default token cannot be Token.UNDEFINED.
		// Otherwise, expressions like "testExternal" will see the "External" keyword be highlighted.
		// In fact, when Token.UNDEFINED is returned (by default), the buffer rewinds and it's a mess.
		// So, we use our own default token.
		IToken myDefaultToken = new Token( null );

		// Create and complete the first rule.
		WordRule keywordsRule = new WordRule( new WordDetector(), myDefaultToken, true );
		keywordsRule.addWord( ParsingConstants.KEYWORD_IMPORT, hl );

		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_CHANNELS, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_COUNT, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_DATA, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_NAME, properties );
		keywordsRule.addWord( ParsingConstants.PROPERTY_INSTANCE_STATE, properties );

		// Add all the rules.
		List<IRule> rules = new ArrayList<IRule> ();
		rules.add( new WhitespaceRule( new WhitespaceDetector()));
		rules.add( new InstanceOfRule( hl ));
		rules.add( new PropertyRule( properties ));

		// The key word rule is more strict.
		// The buffer does not rewind when it recognizes nothing.
		// So, we add it in last position.
		rules.add( keywordsRule );

		setRules( rules.toArray( new IRule[ rules.size()]));
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class InstanceOfRule implements IRule {
		private int comparedLength;
		private final IToken token;


		public InstanceOfRule( IToken token ) {
			this.token = token;
		}

		@Override
		public IToken evaluate( ICharacterScanner scanner ) {
			this.comparedLength = 0;

			// Find the key word
			int readChar = 0;
			char asChar = '#';
			while( readChar != ICharacterScanner.EOF
					&& asChar != '\n'
					&& asChar != '\r'
					&& this.comparedLength < ParsingConstants.KEYWORD_INSTANCE_OF.length()) {

				readChar = scanner.read();
				asChar = (char) readChar;

				char expectedChar = ParsingConstants.KEYWORD_INSTANCE_OF.charAt( this.comparedLength );
				if( expectedChar == Character.toLowerCase( asChar ))
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

			return result;
		}
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class PropertyRule implements IRule {
		private final IToken token;
		private int read = 0;;


		public PropertyRule( IToken token ) {
			this.token = token;
		}

		@Override
		public IToken evaluate( ICharacterScanner scanner ) {
			this.read = 0;

			// Read characters
			int readChar = 0;
			char asChar = '#';
			while( readChar != ICharacterScanner.EOF
					&& asChar != '\n'
					&& asChar != '\r'
					&& asChar != ':' ) {

				readChar = scanner.read();
				asChar = (char) readChar;
				this.read ++;
			}

			// If the last character is a colon, then we have a property
			IToken result = Token.UNDEFINED;
			if( asChar == ':' )
				result = this.token;
			else for( int i = this.read; i != 0; i-- )
				scanner.unread();

			return result;
		}
	}
}
