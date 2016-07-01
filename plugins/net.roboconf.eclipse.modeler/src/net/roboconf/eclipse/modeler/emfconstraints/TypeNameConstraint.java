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

import net.roboconf.core.dsl.ParsingConstants;
import net.roboconf.core.utils.Utils;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;

/**
 * @author Vincent Zurczak - Linagora
 */
public class TypeNameConstraint extends AbstractRoboconfModelConstraint {

	@Override
	public String validate( RoboconfComponent component ) {
		return validate( component.getName());
	}


	@Override
	public String validate( RoboconfFacet facet ) {
		return validate( facet.getName());
	}


	public String validate( String typeName ) {

		String msg = null;
		if( Utils.isEmptyOrWhitespaces( typeName ))
			msg = "Empty names are forbidden.";
		else if( ! typeName.matches( ParsingConstants.PATTERN_ID ))
			msg = "Component and facet names must respect the following pattern: " + ParsingConstants.PATTERN_ID;

		return msg;
	}
}
