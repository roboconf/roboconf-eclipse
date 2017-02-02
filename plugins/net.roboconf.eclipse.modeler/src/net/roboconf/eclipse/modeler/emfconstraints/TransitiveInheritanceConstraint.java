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

import java.util.HashSet;
import java.util.Set;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;

/**
 * @author Vincent Zurczak - Linagora
 */
public class TransitiveInheritanceConstraint extends AbstractRoboconfModelConstraint {

	@Override
	public String validate( RoboconfComponent component ) {
		return validate( component, "component" );
	}

	@Override
	public String validate( RoboconfFacet facet ) {
		return validate( facet, "facet" );
	}


	private String validate( RoboconfFacet facet, String type ) {

		// Follow all the super types
		Set<RoboconfFacet> superTypes = new HashSet<> ();
		Set<RoboconfFacet> alreadyProcessed = new HashSet<> ();
		// alreadyProcessed = superTypes + type

		Set<RoboconfFacet> toProcess = new HashSet<> ();
		toProcess.add( facet );

		while( ! toProcess.isEmpty()) {
			RoboconfFacet f = toProcess.iterator().next();
			toProcess.remove( f );
			alreadyProcessed.add( f );

			for( RoboconfFacet superType : f.getSuperTypes()) {
				superTypes.add( superType );
				if( ! alreadyProcessed.contains( superType ))
					toProcess.add( superType );
			}
		}

		// Now, verify the collected super types do not contain the initial one
		String result = null;
		if( superTypes.contains( facet ))
			result = "A " + type + " cannot directly or indirectly inherit from itself.";

		return result;
	}
}
