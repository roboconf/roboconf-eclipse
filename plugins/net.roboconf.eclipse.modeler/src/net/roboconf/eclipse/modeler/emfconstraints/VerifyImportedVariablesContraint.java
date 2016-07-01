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

package net.roboconf.eclipse.modeler.emfconstraints;

import java.util.HashMap;
import java.util.Map;

import net.roboconf.core.model.helpers.VariableHelpers;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;

/**
 * @author Vincent Zurczak - Linagora
 */
public class VerifyImportedVariablesContraint extends AbstractRoboconfModelConstraint {

	@Override
	public String validate( RoboconfComponent component ) {

		String result = null;
		Map<String,RoboconfFacet> nameToType = new HashMap<> ();
		for( RoboconfFacet type : ((RoboconfGraphs) component.eContainer()).getFacets())
			nameToType.put( type.getName(), type );

		for( RoboconfFacet type : ((RoboconfGraphs) component.eContainer()).getComponents())
			nameToType.put( type.getName(), type );

		for( RoboconfImportedVariable var : component.getImports()) {
			if( var.isExternal())
				continue;

			String prefix = VariableHelpers.parseVariableName( var.getName()).getKey();
			if( nameToType.get( prefix ) == null ) {
				result = var.getName() + " is imported but there is no component or facet called " + prefix + ".";
				break;
			}
		}

		return result;
	}


	@Override
	public String validate( RoboconfFacet facet ) {
		return null;
	}
}
