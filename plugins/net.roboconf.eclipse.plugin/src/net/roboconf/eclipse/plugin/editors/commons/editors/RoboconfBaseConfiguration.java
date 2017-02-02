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

package net.roboconf.eclipse.plugin.editors.commons.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

/**
 * @author Vincent Zurczak - Linagora
 */
public abstract class RoboconfBaseConfiguration extends SourceViewerConfiguration {

	protected final ColorManager colorManager;

	private RuleBasedScanner scanner, commentScanner;
	private DoubleClickStrategy doubleClickStrategy;


	/**
	 * Constructor.
	 * @param colorManager
	 */
	public RoboconfBaseConfiguration( ColorManager colorManager ) {
		this.colorManager = colorManager;
	}


	@Override
	public String[] getConfiguredContentTypes( ISourceViewer sourceViewer ) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			RoboconfPartitionScanner.ROBOCONF_COMMENT
		};
	}


	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy( ISourceViewer sourceViewer, String contentType ) {
		if( this.doubleClickStrategy == null )
			this.doubleClickStrategy = new DoubleClickStrategy();

		return this.doubleClickStrategy;
	}


	@Override
	public IAnnotationHover getAnnotationHover( ISourceViewer sourceViewer ) {
		return new DefaultAnnotationHover();
	}


	@Override
	public IPresentationReconciler getPresentationReconciler( ISourceViewer sourceViewer ) {

		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer( findScanner( false ));
		reconciler.setDamager( dr, IDocument.DEFAULT_CONTENT_TYPE );
		reconciler.setRepairer( dr, IDocument.DEFAULT_CONTENT_TYPE );

		DefaultDamagerRepairer ndr = new DefaultDamagerRepairer( findScanner( true ));
		reconciler.setDamager( ndr, RoboconfPartitionScanner.ROBOCONF_COMMENT );
		reconciler.setRepairer( ndr, RoboconfPartitionScanner.ROBOCONF_COMMENT );

		return reconciler;
	}


	protected final RuleBasedScanner findScanner( boolean comment ) {

		if( this.scanner == null ) {
			this.scanner = buildScanner( this.colorManager );
			Color color = this.colorManager.getColor( ColorManager.DEFAULT );
			this.scanner.setDefaultReturnToken( new Token( new TextAttribute( color )));
		}

		if( this.commentScanner == null ) {
			this.commentScanner = new CommentScanner( this.colorManager );
			Color color = this.colorManager.getColor( ColorManager.COMMENT );
			this.commentScanner.setDefaultReturnToken( new Token( new TextAttribute( color )));
		}

		return comment ? this.commentScanner : this.scanner;
	}


	/**
	 * @param colorManager the color manager
	 * @return the scanner
	 */
	protected abstract RuleBasedScanner buildScanner( ColorManager colorManager );


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class CommentScanner extends RuleBasedScanner {

		/**
		 * Constructor.
		 * @param colorManager
		 */
		public CommentScanner( ColorManager colorManager ) {

			IToken todo = new Token( new TextAttribute( colorManager.getColor( ColorManager.TODO ), null, SWT.BOLD | TextAttribute.UNDERLINE ));
			IToken myDefaultToken = new Token( new TextAttribute( colorManager.getColor( ColorManager.COMMENT )));

			WordRule keywordsRule = new WordRule( new WordDetector(), myDefaultToken, true );
			keywordsRule.addWord( "todo", todo );
			keywordsRule.addWord( "fixme", todo );

			List<IRule> rules = new ArrayList<IRule> ();
			rules.add( new WhitespaceRule( new WhitespaceDetector()));
			rules.add( keywordsRule );

			setRules( rules.toArray( new IRule[ 0 ]));
		}
	}
}
