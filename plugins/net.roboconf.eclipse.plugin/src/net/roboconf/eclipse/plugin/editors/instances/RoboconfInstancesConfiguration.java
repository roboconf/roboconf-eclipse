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

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.source.ISourceViewer;

import net.roboconf.eclipse.plugin.editors.commons.autoedit.AutoTagClosingStrategy;
import net.roboconf.eclipse.plugin.editors.commons.editors.ColorManager;
import net.roboconf.eclipse.plugin.editors.commons.editors.RoboconfBaseConfiguration;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfInstancesConfiguration extends RoboconfBaseConfiguration {

	/**
	 * Constructor.
	 * @param colorManager
	 */
	public RoboconfInstancesConfiguration( ColorManager colorManager ) {
		super( colorManager );
	}


	@Override
	protected RuleBasedScanner buildScanner( ColorManager colorManager ) {
		return new RoboconfInstancesScanner( this.colorManager );
	}


	@Override
	public IContentAssistant getContentAssistant( ISourceViewer sourceViewer ) {

		ContentAssistant ca = new ContentAssistant();
		IContentAssistProcessor cap = new RoboconfInstancesCompletionProcessor();
		ca.setContentAssistProcessor( cap, IDocument.DEFAULT_CONTENT_TYPE );
		ca.setInformationControlCreator( getInformationControlCreator( sourceViewer ));

		return ca;
	}


	@Override
	public IAutoEditStrategy[] getAutoEditStrategies( ISourceViewer sourceViewer, String contentType ) {

		return new IAutoEditStrategy[] {
			new DefaultIndentLineAutoEditStrategy(),
			new AutoTagClosingStrategy()
		};
	}
}
