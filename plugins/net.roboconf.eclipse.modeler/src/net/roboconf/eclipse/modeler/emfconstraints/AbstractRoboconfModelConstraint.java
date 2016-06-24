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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Resource;

import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet;

/**
 * @author Vincent Zurczak - Linagora
 */
public abstract class AbstractRoboconfModelConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate( IValidationContext ctx ) {

		EObject objectToCheck = ctx.getTarget();
		EMFEventType typeEvenement = ctx.getEventType();
		if( typeEvenement == EMFEventType.NULL ) {

			String errorMsg = null;
			if( objectToCheck instanceof RoboconfComponent )
				errorMsg = validate((RoboconfComponent) objectToCheck);
			else if( objectToCheck instanceof RoboconfFacet )
				errorMsg = validate((RoboconfFacet) objectToCheck);

			if( errorMsg != null )
				return ctx.createFailureStatus( new Object[] { errorMsg });
		}

		return ctx.createSuccessStatus();
	}


	/**
	 * @param component a non-null component
	 * @return an error message, or null if everything is fine
	 */
	public abstract String validate( RoboconfComponent component );


	/**
	 * @param component a non-null facet
	 * @return an error message, or null if everything is fine
	 */
	public abstract String validate( RoboconfFacet facet );


	/**
	 * Start from a given type and follow the relations of a given type.
	 * @param facet a non-null type (facet or component)
	 * @return a non-null set of resources
	 */
	protected Set<Resource> filterTargetsByLink( RoboconfFacet facet, Class<? extends Link> clazz ) {

		Set<Resource> linkTargets = new HashSet<> ();
		Set<Resource> alreadyProcessed = new HashSet<> ();

		Set<Resource> toProcess = new HashSet<> ();
		toProcess.add( facet );

		while( ! toProcess.isEmpty()) {
			Resource f = toProcess.iterator().next();
			toProcess.remove( f );
			alreadyProcessed.add( f );

			for( Link link : f.getLinks()) {
				if( clazz.isAssignableFrom( link.getClass())) {

					linkTargets.add( link.getTarget());
					if( ! alreadyProcessed.contains( link.getTarget()))
						toProcess.add( link.getTarget());
				}
			}
		}

		return linkTargets;
	}
}
