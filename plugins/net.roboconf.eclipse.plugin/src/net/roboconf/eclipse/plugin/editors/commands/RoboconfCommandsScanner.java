/**
 * Copyright 2014-2017 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.plugin.editors.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;

import net.roboconf.eclipse.plugin.editors.commons.editors.ColorManager;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfCommandsScanner extends RuleBasedScanner {

	private static final Token CMD_PART_TOKEN = new Token( 99 );


	/**
	 * Constructor.
	 * @param manager
	 */
	public RoboconfCommandsScanner( ColorManager manager ) {

		IToken hl = new Token( new TextAttribute( manager.getColor( ColorManager.HL_KEYWORD ), null, SWT.BOLD ));

		List<IRule> rules = new ArrayList<IRule> ();
		rules.add( new CommandRule( hl,
				createCmdPattern( Arrays.asList( "create", "as", "under" )),
				createCmdPattern( Arrays.asList( "create", "as" )),
				createCmdPattern( Arrays.asList( "replicate", "as" )),
				createCmdPattern( Arrays.asList( "rename", "as" )),
				createCmdPattern( Arrays.asList( "associate", "with" )),
				createCmdPattern( Arrays.asList( "change status of", "to" )),
				createCmdPattern( Arrays.asList( "deploy and start all" )),
				createCmdPattern( Arrays.asList( "stop all" )),
				createCmdPattern( Arrays.asList( "undeploy all" )),
				createCmdPattern( Arrays.asList( "delete" )),
				createCmdPattern( Arrays.asList( "define" )),
				createCmdPattern( Arrays.asList( "email", "with" )),
				createCmdPattern( Arrays.asList( "write", "into" ))));

		setRules( rules.toArray( new IRule[ 0 ]));
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class CommandRule implements IRule {

		private final IToken token;
		private final Pattern[] cmdPatterns;

		private String line;
		private StringBuilder previousRead;


		/**
		 * Constructor.
		 * @param cmdPatterns
		 * @param token
		 */
		public CommandRule( IToken token, Pattern... cmdPatterns ) {
			this.token = token;
			this.cmdPatterns = cmdPatterns;
		}


		@Override
		public IToken evaluate( ICharacterScanner scanner ) {

			// Either we already have read the entire line...
			// ... or we need to do it.
			if( this.line == null ) {
				this.line = readLine( scanner );
				this.previousRead = new StringBuilder();
			}

			// Does it match the pattern?
			IToken result = Token.UNDEFINED;
			patterns: for( Pattern cmdPattern : this.cmdPatterns ) {
				Matcher m = cmdPattern.matcher( this.line.toString());

				// Not matching this pattern? Try the next one.
				if( ! m.matches()) {
					continue;
				}

				// Good pattern. Highlight the keyword for this command.
				// Identify whether the scanner is reading a keyword or something else...
				int offset = this.previousRead.length();
				for( int gp=1; gp<=m.groupCount(); gp++ ) {

					// Is the keyword before the current scanner position?
					if( m.end( gp ) <= offset )
						continue;

					// We found a keyword if and only if the keyword is at the
					// beginning of the offset.
					if( m.start( gp ) == offset ) {
						result = this.token;
						for( int j=offset; j<m.end( gp ); j++ ) {
							this.previousRead.append((char) scanner.read());
						}
					}

					// Otherwise, we are in the middle of the pattern.
					// We keep the default token and read the required characters from the scanner.
					else {
						result = CMD_PART_TOKEN;
						for( int j=offset; j<m.start( gp ); j++ )
							this.previousRead.append((char) scanner.read());
					}

					break patterns;
				}
			}

			// Did we reach the end of line?
			if( isEnd( scanner.read())) {
				this.line = null;
			}

			// End check => read => unread
			scanner.unread();
			return result;
		}
	}


	/**
	 * Reads an entire line from a scanner and rewinds the scanner.
	 * @param scanner
	 * @return a string builder
	 */
	private static String readLine( ICharacterScanner scanner ) {

		StringBuilder sb = new StringBuilder();
		int readChar = 0, previousReadChar = '#', readCharCount = 0;

		// Read the line.
		// Split lines are handled here.
		while( readChar != ICharacterScanner.EOF
				&& ( ! isEnd( readChar ) || previousReadChar == '\\' )) {

			previousReadChar = (char) readChar;
			readChar = scanner.read();

			sb.append((char) readChar);
			readCharCount ++;
		}

		// Reset the scanner
		for( int i=0; i<readCharCount; i++ )
			scanner.unread();

		return sb.toString().trim();
	}


	/**
	 * Determines whether a character indicates an end.
	 * @param readChar
	 * @return true if it is an "end"
	 */
	private static boolean isEnd( int readChar ) {

		char asChar = (char) readChar;
		return readChar == ICharacterScanner.EOF
				|| asChar == '\n'
				|| asChar == '\r';
	}


	/**
	 * Creates a flexible pattern from keywords.
	 * @param keywords a non-null list of keywords
	 * @return a non-null string
	 */
	private static Pattern createCmdPattern( List<String> keywords ) {

		StringBuilder sb = new StringBuilder( "^" );
		for( String keyword : keywords ) {
			sb.append( "\\b(" );
			sb.append( keyword );
			sb.append( ")\\b.*" );
		}

		sb.append( "$" );
		return Pattern.compile( sb.toString(), Pattern.CASE_INSENSITIVE | Pattern.DOTALL );
	}
}
