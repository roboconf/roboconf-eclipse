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
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.roboconf.eclipse.emf.models.roboconf.impl;

import net.roboconf.eclipse.emf.models.roboconf.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoboconfEmfFactoryImpl extends EFactoryImpl implements RoboconfEmfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RoboconfEmfFactory init() {
		try {
			RoboconfEmfFactory theRoboconfEmfFactory = (RoboconfEmfFactory)EPackage.Registry.INSTANCE.getEFactory(RoboconfEmfPackage.eNS_URI);
			if (theRoboconfEmfFactory != null) {
				return theRoboconfEmfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RoboconfEmfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfEmfFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RoboconfEmfPackage.ROBOCONF_GRAPHS: return createRoboconfGraphs();
			case RoboconfEmfPackage.ROBOCONF_CHILDREN_LINK: return createRoboconfChildrenLink();
			case RoboconfEmfPackage.ROBOCONF_COMPONENT: return createRoboconfComponent();
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE: return createRoboconfExportedVariable();
			case RoboconfEmfPackage.ROBOCONF_FACET: return createRoboconfFacet();
			case RoboconfEmfPackage.ROBOCONF_IMPORTED_VARIABLE: return createRoboconfImportedVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfGraphs createRoboconfGraphs() {
		RoboconfGraphsImpl roboconfGraphs = new RoboconfGraphsImpl();
		return roboconfGraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfChildrenLink createRoboconfChildrenLink() {
		RoboconfChildrenLinkImpl roboconfChildrenLink = new RoboconfChildrenLinkImpl();
		return roboconfChildrenLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfComponent createRoboconfComponent() {
		RoboconfComponentImpl roboconfComponent = new RoboconfComponentImpl();
		return roboconfComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfExportedVariable createRoboconfExportedVariable() {
		RoboconfExportedVariableImpl roboconfExportedVariable = new RoboconfExportedVariableImpl();
		return roboconfExportedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfFacet createRoboconfFacet() {
		RoboconfFacetImpl roboconfFacet = new RoboconfFacetImpl();
		return roboconfFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfImportedVariable createRoboconfImportedVariable() {
		RoboconfImportedVariableImpl roboconfImportedVariable = new RoboconfImportedVariableImpl();
		return roboconfImportedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfEmfPackage getRoboconfEmfPackage() {
		return (RoboconfEmfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RoboconfEmfPackage getPackage() {
		return RoboconfEmfPackage.eINSTANCE;
	}

} //RoboconfEmfFactoryImpl
