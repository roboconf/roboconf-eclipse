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

package net.roboconf.eclipse.plugin.editors.commons.contentassist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import net.roboconf.core.Constants;
import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.core.model.beans.ExportedVariable;
import net.roboconf.core.model.helpers.VariableHelpers;
import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.plugin.RoboconfEclipsePlugin;

/**
 * @author Vincent Zurczak - Linagora
 */
public final class ContentAssistUtils {

	/**
	 * Constructor.
	 */
	private ContentAssistUtils() {
		// nothing
	}


	/**
	 * A convenience method to shorten the creation of a basic proposal.
	 * @param s
	 * @param lastWord
	 * @param offset
	 * @return a non-null proposal
	 */
	public static ICompletionProposal basicProposal( String s, String lastWord, int offset ) {
		return new CompletionProposal(
				s,
				offset - lastWord.length(),
				lastWord.length(),
				s.length());
	}


	/**
	 * @param s (not null)
	 * @param prefix (not null)
	 * @return true if s starts with prefix (case insensitively)
	 */
	public static boolean startsWith( String s, String prefix ) {
		return s.toLowerCase().startsWith( prefix.toLowerCase());
	}


	/**
	 * @return the file that contains the application to parse (can be null)
	 */
	public static File findApplicationDirectory() {

		File result = null;
		IEditorInput input = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		if( input instanceof IFileEditorInput ) {
			IProject p = ((IFileEditorInput) input).getFile().getProject();

			// We do not always have a Maven project
			IResource root = p.getFolder( new Path( "src/main/model" ));
			if( ! root.exists())
				root = p;

			result = root.getLocation().toFile();
		}

		return result;
	}


	/**
	 * @return the file that is being edited (can be null)
	 */
	public static File findEditedFile() {

		File result = null;
		IEditorInput input = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		if( input instanceof IFileEditorInput )
			result = ((IFileEditorInput) input).getFile().getLocation().toFile();

		return result;
	}


	/**
	 * Finds all the Roboconf types.
	 * @return a non-null map of types (key = type name, value = type)
	 */
	public static Map<String,RoboconfTypeBean> findAllTypes() {

		List<File> graphFiles = new ArrayList<> ();
		File graphDirectory = findApplicationDirectory();
		if( graphDirectory != null )
			graphFiles = Utils.listAllFiles( graphDirectory, "graph" );

		final Pattern typePattern = Pattern.compile( "^(#[^#\n]+\n)?([^\n#{]+)\\{([^}]+)\\}", Pattern.MULTILINE );
		final Pattern exportsPattern = Pattern.compile( ParsingConstants.PROPERTY_GRAPH_EXPORTS + "\\s*:([^;]+);", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE );

		Map<String,RoboconfTypeBean> result = new HashMap<> ();
		for( File f : graphFiles ) {
			try {
				String s = Utils.readFileContent( f );
				Matcher m = typePattern.matcher( s );
				while( m.find()) {

					String name = m.group( 2 ).trim();
					String lastComment = m.group( 1 );
					if( lastComment != null )
						lastComment = lastComment.replace( "#", "" ).trim();

					boolean isFacet = name.matches( ParsingConstants.KEYWORD_FACET + "\\s+.*" );
					if( isFacet )
						name = name.substring( ParsingConstants.KEYWORD_FACET.length()).trim();

					RoboconfTypeBean type = new RoboconfTypeBean( name, lastComment, isFacet );
					result.put( type.getName(), type );

					String properties = m.group( 3 ).trim();
					Matcher exportsMatcher = exportsPattern.matcher( properties );
					while( exportsMatcher.find()) {

						String exports = exportsMatcher.group( 1 ).trim();
						for( String varDecl : Utils.splitNicelyWithPattern( exports, ",|\\\\" )) {
							if( Utils.isEmptyOrWhitespaces( varDecl ))
								continue;

							Map.Entry<String,String> entry = VariableHelpers.parseExportedVariable( varDecl );
							ExportedVariable var = new ExportedVariable( entry.getKey(), entry.getValue());
							type.exportedVariables.put( var.getName(), var.getValue());
						}
					}
				}

			} catch( IOException e ) {
				RoboconfEclipsePlugin.log( e, IStatus.ERROR, "Failed to read content from file " + f.getName());
			}
		}

		return result;
	}


	/**
	 * @author Vincent Zurczak - Linagora
	 */
	public static class RoboconfTypeBean {

		public final Map<String,String> exportedVariables = new TreeMap<> ();
		private final String name, description;
		private final boolean facet;


		/**
		 * Constructor.
		 * @param name
		 * @param description
		 * @param facet
		 */
		private RoboconfTypeBean( String name, String description, boolean facet ) {
			this.name = name;
			this.description =  description;
			this.facet = facet;
		}

		public String getName() {
			return this.name;
		}

		public String getDescription() {
			return this.description;
		}

		public boolean isFacet() {
			return this.facet;
		}
	}


	/**
	 * Resolves the description to show for an exported variable.
	 * @param variableName a non-null variable name
	 * @param defaultValue the default value (can be null)
	 * @return a description (can be null)
	 */
	public static String resolveStringDescription( String variableName, String defaultValue ) {

		String result = null;
		if( Constants.SPECIFIC_VARIABLE_IP.equalsIgnoreCase( variableName ))
			 result = "Value set dynamically by Roboconf";
		else if( ! Utils.isEmptyOrWhitespaces( defaultValue ))
			result = "Default value: " + defaultValue;

		return result;
	}


	/**
	 * Find exported variables from raw graph files (including malformed ones).
	 * @return a non-null map of exported variables (key = name, value = default value)
	 */
	public static Map<String,String> findAllExportedVariables() {

		// TreeMap: keys are sorted alphabetically.
		Map<String,String> result = new TreeMap<> ();
		for( RoboconfTypeBean type : findAllTypes().values()) {
			result.put( type.getName() + ".*", "Import all the variables" );

			for( Map.Entry<String,String> entry : type.exportedVariables.entrySet()) {
				String desc = resolveStringDescription( entry.getKey(), entry.getValue());
				result.put( type.getName() + "." + entry.getKey(), desc );
			}
		}

		return result;
	}


	/**
	 * Find type names from raw graph files (including malformed ones).
	 * @param includeFacets true to include facet names in the result
	 * @param includeComponents true to include component names in the result
	 * @return a non-null map (key = type name, value = description)
	 */
	public static Map<String,String> findTypeNames( boolean includeFacets, boolean includeComponents ) {

		// TreeMap: keys are sorted alphabetically.
		Map<String,String> result = new TreeMap<> ();
		for( RoboconfTypeBean type : findAllTypes().values()) {

			if( includeFacets && type.isFacet())
				result.put( type.getName(), type.getDescription());

			if( includeComponents && ! type.isFacet())
				result.put( type.getName(), type.getDescription());
		}

		return result;
	}



	/**
	 * Builds proposals from a map (key = replacement, value = description).
	 * @param viewer the viewer
	 * @param candidates a non-null list of candidates
	 * @param prefix a non-null prefix
	 * @param offset the viewer's offset
	 * @return a non-null list of proposals
	 */
	public static List<ICompletionProposal> buildProposalsFromMap(
			ITextViewer viewer,
			Map<String,String> candidates,
			String prefix,
			int offset ) {

		List<ICompletionProposal> result = new ArrayList<> ();
		for( Map.Entry<String,String> entry : candidates.entrySet()) {

			// Matching candidate?
			String candidate = entry.getKey();
			if( ! startsWith( candidate, prefix ))
				continue;

			// No description => basic proposal
			if( Utils.isEmptyOrWhitespaces( entry.getValue())) {
				result.add( basicProposal( candidate, prefix, offset ));
			}

			// Otherwise, show the description
			else {
				result.add( new CompletionProposalWithSelection(
						viewer,
						candidate,
						prefix,
						candidate,
						entry.getValue(),
						new ArrayList<Point>( 0 ),
						offset ));
			}
		}

		return result;
	}
}
