/**
 * Copyright 2014 Linagora, Université Joseph Fourier, Floralis
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

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfConfiguration extends SourceViewerConfiguration {

	private DoubleClickStrategy doubleClickStrategy;
	private RoboconfScanner scanner;
	private final ColorManager colorManager;


	/**
	 * Constructor.
	 * @param colorManager
	 */
	public RoboconfConfiguration( ColorManager colorManager ) {
		this.colorManager = colorManager;
	}


	@Override
	public String[] getConfiguredContentTypes( ISourceViewer sourceViewer ) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			PartitionScanner.ROBOCONF_COMMENT
		};
	}


	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy( ISourceViewer sourceViewer, String contentType) {
		if( this.doubleClickStrategy == null )
			this.doubleClickStrategy = new DoubleClickStrategy();

		return this.doubleClickStrategy;
	}


	protected RoboconfScanner getXMLScanner() {

		if( this.scanner == null ) {
			this.scanner = new RoboconfScanner( this.colorManager );
			this.scanner.setDefaultReturnToken( new Token( new TextAttribute( this.colorManager.getColor( ColorConstants.DEFAULT ))));
		}

		return this.scanner;
	}


	@Override
	public IPresentationReconciler getPresentationReconciler( ISourceViewer sourceViewer ) {

		PresentationReconciler reconciler = new PresentationReconciler();
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer( getXMLScanner());
		reconciler.setDamager( dr, IDocument.DEFAULT_CONTENT_TYPE );
		reconciler.setRepairer( dr, IDocument.DEFAULT_CONTENT_TYPE );

		NonRuleBasedDamagerRepairer ndr =
			new NonRuleBasedDamagerRepairer( new TextAttribute( this.colorManager.getColor( ColorConstants.COMMENT )));

		reconciler.setDamager( ndr, PartitionScanner.ROBOCONF_COMMENT );
		reconciler.setRepairer( ndr, PartitionScanner.ROBOCONF_COMMENT );

		return reconciler;
	}

}