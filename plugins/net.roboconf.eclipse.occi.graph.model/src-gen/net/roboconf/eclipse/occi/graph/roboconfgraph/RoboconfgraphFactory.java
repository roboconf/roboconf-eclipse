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
package net.roboconf.eclipse.occi.graph.roboconfgraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage
 * @generated
 */
public interface RoboconfgraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RoboconfgraphFactory eINSTANCE = net.roboconf.eclipse.occi.graph.roboconfgraph.impl.RoboconfgraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Roboconf Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Component</em>'.
	 * @generated
	 */
	RoboconfComponent createRoboconfComponent();

	/**
	 * Returns a new object of class '<em>Roboconf Facet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Facet</em>'.
	 * @generated
	 */
	RoboconfFacet createRoboconfFacet();

	/**
	 * Returns a new object of class '<em>Roboconf Exported Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Exported Variable</em>'.
	 * @generated
	 */
	RoboconfExportedVariable createRoboconfExportedVariable();

	/**
	 * Returns a new object of class '<em>Roboconf Imported Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Imported Variable</em>'.
	 * @generated
	 */
	RoboconfImportedVariable createRoboconfImportedVariable();

	/**
	 * Returns a new object of class '<em>Roboconf Owner Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Owner Link</em>'.
	 * @generated
	 */
	RoboconfOwnerLink createRoboconfOwnerLink();

	/**
	 * Returns a new object of class '<em>Roboconf Inheritance Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Inheritance Link</em>'.
	 * @generated
	 */
	RoboconfInheritanceLink createRoboconfInheritanceLink();

	/**
	 * Returns a new object of class '<em>Roboconf Children Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Children Link</em>'.
	 * @generated
	 */
	RoboconfChildrenLink createRoboconfChildrenLink();

	/**
	 * Returns a new object of class '<em>Roboconf Runtime Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboconf Runtime Link</em>'.
	 * @generated
	 */
	RoboconfRuntimeLink createRoboconfRuntimeLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RoboconfgraphPackage getRoboconfgraphPackage();

} //RoboconfgraphFactory
