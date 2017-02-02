/**
 * Copyright 2016-2017 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.modeler.services;

import java.util.Iterator;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;

import net.roboconf.core.model.helpers.VariableHelpers;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;
import net.roboconf.eclipse.modeler.utilities.EclipseUtils;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RuntimeLinkLabelService {

	/**
	 * Finds the text to show on runtime links.
	 * @param dde a diagram element
	 * @return a non-null string
	 */
	public String getRuntimeLinkLabel( DDiagramElement dde ) {

		// Filter the selection
		if( !( dde instanceof DEdge ))
			return "!! invalid !!";

		// Go on...
		StringBuilder sb = new StringBuilder();
		int cpt = 0;

		EObject eo = EclipseUtils.resolve(((DEdge) dde).getSourceNode());
		RoboconfComponent sourceComponent = (RoboconfComponent) eo;

		eo = EclipseUtils.resolve(((DEdge) dde).getTargetNode());
		RoboconfFacet target = (RoboconfFacet) eo;

		// Deal with imports
		if( sourceComponent.getImports().isEmpty()) {
			sb.append( "" );

		} else for( Iterator<RoboconfImportedVariable> it = sourceComponent.getImports().iterator(); it.hasNext(); ) {

			// Filter by target (do not display Toto.* if the target component is called "Titi").
			RoboconfImportedVariable var = it.next();
			String prefix = VariableHelpers.parseVariableName( var.getName()).getKey();
			if( ! Objects.equals( prefix, target.getName()))
				continue;

			// Show the variable name
			sb.append( var.getName());
			cpt ++;

			// Too many imports? Limit the display
			if( cpt > 2 ) {
				sb.append( ",\n..." );
				break;
			}

			// Otherwise, handle the separation
			if( it.hasNext())
				sb.append( ",\n" );
		}

		return sb.toString();
	}
}
