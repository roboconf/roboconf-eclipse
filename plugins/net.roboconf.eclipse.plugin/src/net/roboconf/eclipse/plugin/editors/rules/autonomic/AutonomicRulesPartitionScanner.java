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

package net.roboconf.eclipse.plugin.editors.rules.autonomic;

import net.roboconf.core.dsl.ParsingConstants;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * @author Vincent Zurczak - Linagora
 */
public class AutonomicRulesPartitionScanner extends RuleBasedPartitionScanner {

	public final static String SINGLE_LINE_COMMENT_SHARP = "__comment_#";
	public final static String SINGLE_LINE_COMMENT_SS = "__comment_//";
	public final static String MULTILINE_COMMENT = "__comment_/* */";


	public AutonomicRulesPartitionScanner() {

		IPredicateRule[] rules = new IPredicateRule[ 3 ];
		rules[ 0 ] = new EndOfLineRule( ParsingConstants.COMMENT_DELIMITER, new Token( SINGLE_LINE_COMMENT_SHARP ));
		rules[ 1 ] = new EndOfLineRule( "//", new Token( SINGLE_LINE_COMMENT_SS ));
		rules[ 2 ] = new MultiLineRule( "/*", "*/", new Token( MULTILINE_COMMENT ));

		setPredicateRules( rules );
	}
}
