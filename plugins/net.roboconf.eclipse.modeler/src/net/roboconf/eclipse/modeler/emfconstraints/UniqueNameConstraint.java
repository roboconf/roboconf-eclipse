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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;

/**
 * @author Vincent Zurczak - Linagora
 */
public class UniqueNameConstraint extends AbstractRoboconfModelConstraint {

	@Override
	public String validate( RoboconfComponent component ) {
		return validate((RoboconfFacet) component);
	}


	@Override
	public String validate( RoboconfFacet facet ) {
		return validate( facet, facet.getName());
	}


	public String validate( RoboconfFacet facet, String name ) {

		RoboconfGraphs graphs = (RoboconfGraphs) facet.eContainer();
		List<RoboconfFacet> allTypes = new ArrayList<> ();
		allTypes.addAll( graphs.getComponents());
		allTypes.addAll( graphs.getFacets());

		String msg = null;
		Set<String> names = new HashSet<> ();
		for( RoboconfFacet f : allTypes ) {
			if( ! f.equals( facet ))
				names.add( f.getName());
		}

		if( names.contains( name ))
			msg = "Another facet or component uses the same name. Names must be unique within the graph(s).";

		return msg;
	}
}
