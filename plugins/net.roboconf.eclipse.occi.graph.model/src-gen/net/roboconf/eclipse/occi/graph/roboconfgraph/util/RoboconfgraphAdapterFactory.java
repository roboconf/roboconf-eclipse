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
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.roboconf.eclipse.occi.graph.roboconfgraph.util;

import net.roboconf.eclipse.occi.graph.roboconfgraph.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Resource;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage
 * @generated
 */
public class RoboconfgraphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RoboconfgraphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfgraphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RoboconfgraphPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboconfgraphSwitch<Adapter> modelSwitch =
		new RoboconfgraphSwitch<Adapter>() {
			@Override
			public Adapter caseRoboconfComponent(RoboconfComponent object) {
				return createRoboconfComponentAdapter();
			}
			@Override
			public Adapter caseRoboconfFacet(RoboconfFacet object) {
				return createRoboconfFacetAdapter();
			}
			@Override
			public Adapter caseRoboconfApplicationTemplate(RoboconfApplicationTemplate object) {
				return createRoboconfApplicationTemplateAdapter();
			}
			@Override
			public Adapter caseRoboconfExportedVariable(RoboconfExportedVariable object) {
				return createRoboconfExportedVariableAdapter();
			}
			@Override
			public Adapter caseRoboconfImportedVariable(RoboconfImportedVariable object) {
				return createRoboconfImportedVariableAdapter();
			}
			@Override
			public Adapter caseRoboconfOwnerLink(RoboconfOwnerLink object) {
				return createRoboconfOwnerLinkAdapter();
			}
			@Override
			public Adapter caseRoboconfInheritanceLink(RoboconfInheritanceLink object) {
				return createRoboconfInheritanceLinkAdapter();
			}
			@Override
			public Adapter caseRoboconfChildrenLink(RoboconfChildrenLink object) {
				return createRoboconfChildrenLinkAdapter();
			}
			@Override
			public Adapter caseRoboconfRuntimeLink(RoboconfRuntimeLink object) {
				return createRoboconfRuntimeLinkAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent <em>Roboconf Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent
	 * @generated
	 */
	public Adapter createRoboconfComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet <em>Roboconf Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet
	 * @generated
	 */
	public Adapter createRoboconfFacetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfApplicationTemplate <em>Roboconf Application Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfApplicationTemplate
	 * @generated
	 */
	public Adapter createRoboconfApplicationTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfExportedVariable <em>Roboconf Exported Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfExportedVariable
	 * @generated
	 */
	public Adapter createRoboconfExportedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfImportedVariable <em>Roboconf Imported Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfImportedVariable
	 * @generated
	 */
	public Adapter createRoboconfImportedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfOwnerLink <em>Roboconf Owner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfOwnerLink
	 * @generated
	 */
	public Adapter createRoboconfOwnerLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfInheritanceLink <em>Roboconf Inheritance Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfInheritanceLink
	 * @generated
	 */
	public Adapter createRoboconfInheritanceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfChildrenLink <em>Roboconf Children Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfChildrenLink
	 * @generated
	 */
	public Adapter createRoboconfChildrenLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfRuntimeLink <em>Roboconf Runtime Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfRuntimeLink
	 * @generated
	 */
	public Adapter createRoboconfRuntimeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.occiware.clouddesigner.occi.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.occiware.clouddesigner.occi.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.occiware.clouddesigner.occi.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.occiware.clouddesigner.occi.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.occiware.clouddesigner.occi.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.occiware.clouddesigner.occi.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RoboconfgraphAdapterFactory
