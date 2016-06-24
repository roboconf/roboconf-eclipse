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

import java.util.Set;

import org.occiware.clouddesigner.occi.Resource;

import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfInheritanceLink;

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

		// Follow all the children relations
		Set<Resource> linkTargets = filterTargetsByLink( facet, RoboconfInheritanceLink.class );

		// Now, verify the collected children do not contain the root type
		String result = null;
		if( linkTargets.contains( facet ))
			result = "A " + type + " cannot directly or indirectly inherit from itself.";

		return result;
	}
}
