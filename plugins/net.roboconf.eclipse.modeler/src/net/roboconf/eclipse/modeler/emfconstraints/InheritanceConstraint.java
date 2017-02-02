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

package net.roboconf.eclipse.modeler.emfconstraints;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;

/**
 * Inheritances constraints.
 * <p>
 * Facets can only inherit from facets and a component can only inherit
 * from facets and from a single component.
 * </p>
 *
 * @author Vincent Zurczak - Linagora
 */
public class InheritanceConstraint extends AbstractRoboconfModelConstraint {

	@Override
	public String validate( RoboconfComponent component ) {

		int cpt = 0;
		for( RoboconfFacet superType : component.getSuperTypes()) {
			if( superType instanceof RoboconfComponent )
				cpt ++;
		}

		String result = cpt <= 1 ? null : "A component can only inherit from facets and from a single component.";
		return result;
	}


	@Override
	public String validate( RoboconfFacet facet ) {

		String result = null;
		for( RoboconfFacet superType : facet.getSuperTypes()) {
			if( superType instanceof RoboconfComponent ) {
				result = "A facet can only inherit from facets.";
				break;
			}
		}

		return result;
	}
}
