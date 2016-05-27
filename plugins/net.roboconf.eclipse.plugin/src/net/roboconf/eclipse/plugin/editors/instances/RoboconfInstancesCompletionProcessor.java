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

package net.roboconf.eclipse.plugin.editors.instances;

import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.basicProposal;
import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.findApplicationDirectory;
import static net.roboconf.eclipse.plugin.editors.commons.contentassist.ContentAssistUtils.startsWith;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Point;

import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.core.model.RuntimeModelIo;
import net.roboconf.core.model.RuntimeModelIo.ApplicationLoadResult;
import net.roboconf.core.model.beans.Component;
import net.roboconf.core.model.beans.ExportedVariable;
import net.roboconf.core.model.helpers.ComponentHelpers;
import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.plugin.RoboconfEclipseUtils;
import net.roboconf.eclipse.plugin.editors.commons.contentassist.CompletionProposalWithSelection;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfInstancesCompletionProcessor implements IContentAssistProcessor {

	private static final String COMPONENT_NAME = "component";
	private String errorMsg = null;



	@Override
	public ICompletionProposal[] computeCompletionProposals( ITextViewer viewer, int offset ) {

		// Find the text to insert
		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal> ();
		Ctx ctx = findContext( viewer, offset );

		switch( ctx.kind ) {
		case ATTRIBUTE:
			for( String exportedVariableName : findExportedVariableNames( ctx ))
				proposals.add( basicProposal( exportedVariableName, ctx.lastWord, offset ));

			// No break statement!

		case BEGINNING:
			String s = ParsingConstants.KEYWORD_INSTANCE_OF + " ";
			if( startsWith( s, ctx.lastWord )) {

				// Basic proposal: instance of
				proposals.add( basicProposal( s, ctx.lastWord, offset ));

				// More complex proposal: a full block
				StringBuilder sb = new StringBuilder( s );
				sb.append( "component" );
				sb.append( " {\n\t" );
				sb.append( ctx.parentIndentation );

				sb.append( ParsingConstants.PROPERTY_INSTANCE_NAME );
				sb.append( ": name;\n" );

				sb.append( ctx.parentIndentation );
				sb.append( "}" );

				s = sb.toString();
				Point sel1 = new Point( offset + ParsingConstants.KEYWORD_INSTANCE_OF.length() + 1, COMPONENT_NAME.length());
				Point sel2 = new Point( sel1.x + sel1.y + ParsingConstants.PROPERTY_INSTANCE_NAME.length() + 6, 4 );
				sel2.x += ctx.parentIndentation.length();

				proposals.add( new CompletionProposalWithSelection(
						viewer,
						s,
						ctx.lastWord,
						ParsingConstants.KEYWORD_INSTANCE_OF + " block",
						"New instance block\n\n" + s.trim(),
						Arrays.asList( sel1, sel2 ),
						offset ));
			}

			break;

		case COMPONENT_NAME:
			for( String componentName : findComponentNames( ctx ))
				proposals.add( basicProposal( componentName, ctx.lastWord, offset ));

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

		String msg = this.errorMsg;
		this.errorMsg = null;

		return msg;
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
		COMPONENT_NAME, // Right after "instance of"
		ATTRIBUTE, 		// At the beginning or right after a colon or an opening curly bracket
		BEGINNING; 		// We are at the very beginning of the document
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	private static class Ctx {

		CtxKind kind = CtxKind.NONE;
		String lastWord, parentInstanceType = "", parentIndentation = "";
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

		// Keep on simplifying the search: remove complete instances
		// Since instances can contain other instances (recursivity), we must
		// apply the pattern several times, until no more replacement is possible.
		int before = -1;
		int after = -2;
		while( before != after ) {
			before = text.length();
			text = text.replaceAll( "(?i)(?s)instance\\s+of[^{]*\\{[^{}]*\\}", "" );
			after = text.length();
		}

		// Remove white spaces at the beginning of the string.
		text = text.replaceAll( "^(\n|\r\n)+", "" );

		// Now, find our context.
		Ctx ctx = new Ctx();
		int n = -1;

		String lastWord = null;
		StringBuilder sb = new StringBuilder();

		for( n = text.length() - 1; n >= 0 && ctx.kind == CtxKind.NONE; n-- ) {
			char c = text.charAt( n );

			// After a "colon" => we are in a property, forget it...
			if( c == ':' )
				break;

			// White space? We have a our last word.
			if( Character.isWhitespace( c ) && lastWord == null )
				lastWord = sb.toString();

			// After a semicolon: we should suggest new attributes
			if( c == ';' )
				ctx.kind = CtxKind.ATTRIBUTE;

			// Same thing after a curly bracket
			else if( c == '{' )
				ctx.kind = CtxKind.ATTRIBUTE;

			else {
				sb.insert( 0, c );
				String cmp = sb.toString();
				if( lastWord != null )
					cmp = cmp.substring( 0, cmp.length() - lastWord.length());

				cmp = cmp.trim().replaceAll( "\\s{2,}", " " );
				if( cmp.equals( ParsingConstants.KEYWORD_INSTANCE_OF ))
					ctx.kind = CtxKind.COMPONENT_NAME;
			}
		}

		// If we reached the beginning of the document, we can only insert "instance of"
		if( ctx.kind == CtxKind.NONE && n == -1 )
			ctx.kind = CtxKind.BEGINNING;

		// Update the context
		ctx.lastWord = lastWord == null ? "" : lastWord;

		// Find the parent instance (which is the first declared instance at the end of 'text').
		Pattern p = Pattern.compile( "([\\t ]*)instance\\s+of\\s+([^{]+)", Pattern.CASE_INSENSITIVE );
		Matcher m = p.matcher( text );
		while( m.find()) {
			// instance of t| => 'lastWord == t' and 'm.group( 2 ) == t''
			// instance of => 'lastWord' is not relevant...
			if( ! Objects.equals( ctx.lastWord, m.group( 2 ))) {
				ctx.parentIndentation = m.group( 1 ) != null ? m.group( 1 ) : "";
				ctx.parentIndentation += "\t";
				ctx.parentInstanceType = m.group( 2 ).trim();
			}
		}

		return ctx;
	}


	/**
	 * @param ctx the current context
	 * @return a non-null list of component names
	 */
	private List<String> findComponentNames( Ctx ctx ) {

		List<String> result = new ArrayList<> ();
		File root = findApplicationDirectory();
		if( root != null ) {

			// Ignore parsing errors, propose the most accurate and possible results
			ApplicationLoadResult alr = RuntimeModelIo.loadApplicationFlexibly( root );
			if( alr.getApplicationTemplate().getGraphs() != null ) {

				// If there is a parent component...
				Component parentComponent = ComponentHelpers.findComponent( alr.getApplicationTemplate(), ctx.parentInstanceType );

				// ... then find out the right potential children.
				Collection<Component> candidates = Collections.emptyList();
				if( parentComponent != null )
					candidates = ComponentHelpers.findAllChildren( parentComponent );
				else if( Utils.isEmptyOrWhitespaces( ctx.parentInstanceType ))
					candidates = alr.getApplicationTemplate().getGraphs().getRootComponents();
				else
					this.errorMsg = "Component " + ctx.parentInstanceType + " does not exist.";

				for( Component c : candidates ) {
					if( startsWith( c.getName(), ctx.lastWord ))
						result.add(  c.getName());
				}
			}
		}

		return result;
	}


	/**
	 * @param ctx the current context
	 * @return a non-null list of variable names
	 */
	private Set<String> findExportedVariableNames( Ctx ctx ) {

		Set<String> result = new TreeSet<> ();
		if( startsWith( ParsingConstants.PROPERTY_INSTANCE_NAME, ctx.lastWord ))
			result.add( ParsingConstants.PROPERTY_INSTANCE_NAME + ": " );

		if( startsWith( ParsingConstants.PROPERTY_INSTANCE_CHANNELS, ctx.lastWord ))
			result.add( ParsingConstants.PROPERTY_INSTANCE_CHANNELS + ": " );

		File root = findApplicationDirectory();
		if( root != null ) {

			// Ignore parsing errors, propose the most accurate and possible results
			ApplicationLoadResult alr = RuntimeModelIo.loadApplicationFlexibly( root );
			if( alr.getApplicationTemplate().getGraphs() != null ) {

				// If there is a owner component...
				Component ownerComponent = ComponentHelpers.findComponent( alr.getApplicationTemplate(), ctx.parentInstanceType );

				// ... then find out the exported variables that can be overridden.
				if( ownerComponent == null ) {
					this.errorMsg = "Component " + ctx.parentInstanceType + " does not exist.";

				} else for( ExportedVariable var : ownerComponent.exportedVariables.values()) {
					if( startsWith( var.getName(), ctx.lastWord ))
						result.add( var.getName() + ": " );
				}
			}
		}

		return result;
	}
}
