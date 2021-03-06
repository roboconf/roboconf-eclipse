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

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.source.ISourceViewer;

import net.roboconf.eclipse.plugin.editors.commons.editors.ColorManager;
import net.roboconf.eclipse.plugin.editors.commons.editors.RoboconfBaseConfiguration;

/**
 * @author Vincent Zurczak - Linagora
 */
public class AutonomicRulesConfiguration extends RoboconfBaseConfiguration {

	/**
	 * Constructor.
	 * @param colorManager
	 */
	public AutonomicRulesConfiguration( ColorManager colorManager ) {
		super( colorManager );
	}


	@Override
	protected RuleBasedScanner buildScanner( ColorManager colorManager ) {
		return new AutonomicRulesScanner( this.colorManager );
	}


	@Override
	public IPresentationReconciler getPresentationReconciler( ISourceViewer sourceViewer ) {

		PresentationReconciler reconciler = new PresentationReconciler();
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer( findScanner( false ));
		reconciler.setDamager( dr, IDocument.DEFAULT_CONTENT_TYPE );
		reconciler.setRepairer( dr, IDocument.DEFAULT_CONTENT_TYPE );

		DefaultDamagerRepairer ndr = new DefaultDamagerRepairer( findScanner( true ));
		reconciler.setDamager( ndr, AutonomicRulesPartitionScanner.SINGLE_LINE_COMMENT_SHARP );
		reconciler.setRepairer( ndr, AutonomicRulesPartitionScanner.SINGLE_LINE_COMMENT_SHARP );

		ndr = new DefaultDamagerRepairer( findScanner( true ));
		reconciler.setDamager( ndr, AutonomicRulesPartitionScanner.SINGLE_LINE_COMMENT_SS );
		reconciler.setRepairer( ndr, AutonomicRulesPartitionScanner.SINGLE_LINE_COMMENT_SS );

		ndr = new DefaultDamagerRepairer( findScanner( true ));
		reconciler.setDamager( ndr, AutonomicRulesPartitionScanner.MULTILINE_COMMENT );
		reconciler.setRepairer( ndr, AutonomicRulesPartitionScanner.MULTILINE_COMMENT );

		return reconciler;
	}
}
