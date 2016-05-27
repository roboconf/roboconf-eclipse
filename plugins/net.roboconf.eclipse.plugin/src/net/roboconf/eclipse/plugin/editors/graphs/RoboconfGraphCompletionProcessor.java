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

package net.roboconf.eclipse.plugin.editors.graphs;

import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.basicProposal;
import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.buildProposalsFromMap;
import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.findAllExportedVariables;
import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.findTypeNames;
import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.startsWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Point;

import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;
import net.roboconf.eclipse.plugin.editors.commons.contentassist.CompletionProposalWithSelection;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfGraphCompletionProcessor implements IContentAssistProcessor {

	private static final String[] COMPONENT_PROPERTY_NAMES = {
			ParsingConstants.PROPERTY_GRAPH_CHILDREN,
			ParsingConstants.PROPERTY_GRAPH_EXPORTS,
			ParsingConstants.PROPERTY_GRAPH_EXTENDS,
			ParsingConstants.PROPERTY_COMPONENT_FACETS,
			ParsingConstants.PROPERTY_COMPONENT_IMPORTS,
			ParsingConstants.PROPERTY_COMPONENT_INSTALLER
	};

	private static final String[] FACET_PROPERTY_NAMES = {
			ParsingConstants.PROPERTY_GRAPH_CHILDREN,
			ParsingConstants.PROPERTY_GRAPH_EXPORTS,
			ParsingConstants.PROPERTY_GRAPH_EXTENDS
	};

	private static final String[] KNOWN_INSTALLERS = { "script", "puppet", "logger" };



	@Override
	public ICompletionProposal[] computeCompletionProposals( ITextViewer viewer, int offset ) {

		// Find the text to insert
		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal> ();
		Ctx ctx = findContext( viewer, offset );

		switch( ctx.kind ) {
		case NONE:
			if( startsWith( ParsingConstants.KEYWORD_FACET, ctx.property ))
				proposals.add( basicProposal( ParsingConstants.KEYWORD_FACET + " ", ctx.property, offset ));

			else if( startsWith( ParsingConstants.KEYWORD_IMPORT, ctx.property ))
				proposals.add( basicProposal( ParsingConstants.KEYWORD_IMPORT + " ", ctx.property, offset ));

			break;

		case ATTRIBUTE:
			String[] arr = ctx.facet ? FACET_PROPERTY_NAMES : COMPONENT_PROPERTY_NAMES;
			for( String s : arr ) {
				s += ": ";
				if( startsWith( s, ctx.lastWord ))
					proposals.add( basicProposal( s, ctx.lastWord, offset ));
			}

			break;

		case BEGINNING:

			// Facet
			String s = ParsingConstants.KEYWORD_FACET + " ";
			if( startsWith( s, ctx.lastWord )) {

				// Basic proposal: facet
				proposals.add( basicProposal( s, ctx.lastWord, offset ));

				// More complex proposal: a full block
				s = "facet name {\n\t\n}";
				proposals.add( new CompletionProposalWithSelection(
						viewer,
						s,
						ctx.lastWord,
						ParsingConstants.KEYWORD_FACET + " block",
						"New facet block\n\n" + s.trim(),
						Arrays.asList( new Point( offset + 6, 4 )),
						offset ));
			}

			// Component
			if( Utils.isEmptyOrWhitespaces( ctx.lastWord )) {

				// More complex proposal: a full block
				s = "name {\n\t\n}";
				proposals.add( new CompletionProposalWithSelection(
						viewer,
						s,
						ctx.lastWord,
						"component block",
						"New component block\n\n" + s.trim(),
						Arrays.asList( new Point( offset, 4 )),
						offset ));
			}

			break;

		case PROPERTY:
			Map<String,String> candidates = findPropertyCandidates( ctx );
			proposals.addAll( buildProposalsFromMap( viewer, candidates, ctx.lastWord, offset ));
			break;

		default:
			break;
		}

		// Convert it into an array of proposals
		return proposals.toArray( new ICompletionProposal[ proposals.size()]);
	}


	@Override
	public IContextInformation[] computeContextInformation( ITextViewer viewer, int offset ) {
		return new IContextInformation[ 0 ];
	}


	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[ 0 ];
	}


	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return new char[ 0 ];
	}


	@Override
	public String getErrorMessage() {
		return null;
	}


	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static enum CtxKind {
		NONE, 			// Default
		ATTRIBUTE,		// At the beginning or right after a colon or an opening curly bracket
		BEGINNING,		// We are at the very beginning of the document
		PROPERTY;		// We are defining a property
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class Ctx {

		CtxKind kind = CtxKind.NONE;
		String lastWord, property; //, parentIndentation = "";
		boolean facet = false;
	}


	/**
	 * Finds the context from the offset.
	 * @param viewer
	 * @param offset
	 * @return a context
	 */
	private Ctx findContext( ITextViewer viewer, int offset ) {

		// Simplify the search: remove all the comments.
		String text = viewer.getDocument().get().substring( 0, offset );
		text = RoboconfEclipseUtils.removeComments( text );

		// Keep on simplifying the search: remove complete components and facets
		// Since instances can contain other instances (recursivity), we must
		// apply the pattern several times, until no more replacement is possible.
		int before = -1;
		int after = -2;
		while( before != after ) {
			before = text.length();
			text = text.replaceAll( "(?i)(?s)(facet\\s+)?[^{]*\\{[^{}]*\\}", "" );
			after = text.length();
		}

		// Remove white spaces at the beginning of the string.
		text = text.replaceAll( "^(\n|\r\n)+", "" );

		// Now, find our context.
		// We go back until we find a '{'. Then, we keep rewinding
		// until we find a line break.
		Ctx ctx = new Ctx();
		int n = -1;

		String lastWord = null;
		String lastLine = null;
		StringBuilder sb = new StringBuilder();
		boolean bracketFound = false;

		for( n = text.length() - 1; n >= 0; n-- ) {
			char c = text.charAt( n );

			// White space? We have a our last word.
			if( Character.isWhitespace( c ) && lastWord == null ) {
				lastWord = sb.toString();
				sb.setLength( 0 );
			}

			// Same thing after a curly bracket
			else if( c == '{' )
				bracketFound = true;

			// If we find a closing bracket, then we are at the beginning of a declaration
			else if( c == '}' )
				break;

			// Line break? That depends...
			else if( c == '\n' || c == '\r' ) {
				if( bracketFound )
					break;

				if( lastLine == null ) {
					lastLine = sb.toString();
					sb.setLength( 0 );
				}
			}

			else {
				sb.insert( 0, c );
			}
		}

		// Update the context
		if( lastLine == null )
			lastLine = sb.toString();

		ctx.lastWord = lastWord == null ? "" : lastWord;
		ctx.property = lastLine.trim();

		// Time to analyze
		if( ctx.property.endsWith( ":" )
				|| ctx.property.endsWith( "," )) {
			ctx.kind = CtxKind.PROPERTY;

		} else if( ctx.property.isEmpty()) {
			if( Utils.isEmptyOrWhitespaces( sb.toString()))
				ctx.kind = CtxKind.BEGINNING;
			else if( bracketFound )
				ctx.kind = CtxKind.ATTRIBUTE;
		}

		if( sb.toString().matches( "(?i)\\s*" + ParsingConstants.KEYWORD_FACET + "\\s+.*" ))
			ctx.facet = true;

		// If we reached the beginning of the document, we can only insert "instance of"
		if( ctx.kind == CtxKind.NONE
				&& Utils.isEmptyOrWhitespaces( sb.toString())
				&& n == -1 )
			ctx.kind = CtxKind.BEGINNING;

		return ctx;
	}


	/**
	 * @param ctx the current context
	 * @return a non-null map of candidate values for this property
	 * <p>
	 * Key = value to insert, value = description.
	 * </p>
	 */
	private Map<String,String> findPropertyCandidates( Ctx ctx ) {

		Map<String,String> result = new TreeMap<> ();
		if( ctx.property.matches( ParsingConstants.PROPERTY_COMPONENT_INSTALLER + "\\s*:\\s*" )) {
			for( String installer : KNOWN_INSTALLERS )
				result.put( installer, null );

		} else if( ctx.property.matches( ParsingConstants.PROPERTY_GRAPH_CHILDREN + "\\s*:\\s*.*" )) {
			result.putAll( findTypeNames( true, true ));

		} else if( ctx.property.matches( ParsingConstants.PROPERTY_GRAPH_EXTENDS + "\\s*:\\s*.*" )) {
			result.putAll( findTypeNames( ctx.facet, ! ctx.facet ));

		} else if( ctx.property.matches( ParsingConstants.PROPERTY_COMPONENT_FACETS + "\\s*:\\s*.*" )) {
			result.putAll( findTypeNames( true, false ));

		} else if( ctx.property.matches( ParsingConstants.PROPERTY_COMPONENT_IMPORTS + "\\s*:\\s*.*" )) {
			result.putAll( findAllExportedVariables());
		}

		return result;
	}
}
