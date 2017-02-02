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
package net.roboconf.eclipse.emf.models.roboconf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roboconf Facet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getExports <em>Exports</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getName <em>Name</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getChildren <em>Children</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getAncestors <em>Ancestors</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet()
 * @model extendedMetaData="name='RoboconfFacet' kind='elementOnly'"
 * @generated
 */
public interface RoboconfFacet extends EObject {
	/**
	 * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
	 * The list contents are of type {@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exports</em>' containment reference list.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_Exports()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='exports' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RoboconfExportedVariable> getExports();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' reference list.
	 * The list contents are of type {@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet}.
	 * It is bidirectional and its opposite is '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' reference list.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_SubTypes()
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSuperTypes
	 * @model opposite="superTypes"
	 * @generated
	 */
	EList<RoboconfFacet> getSubTypes();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet}.
	 * It is bidirectional and its opposite is '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_SuperTypes()
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSubTypes
	 * @model opposite="subTypes"
	 * @generated
	 */
	EList<RoboconfFacet> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet}.
	 * It is bidirectional and its opposite is '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getAncestors <em>Ancestors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_Children()
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getAncestors
	 * @model opposite="ancestors"
	 * @generated
	 */
	EList<RoboconfFacet> getChildren();

	/**
	 * Returns the value of the '<em><b>Ancestors</b></em>' reference list.
	 * The list contents are of type {@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet}.
	 * It is bidirectional and its opposite is '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ancestors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ancestors</em>' reference list.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_Ancestors()
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	EList<RoboconfFacet> getAncestors();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfFacet_Dependencies()
	 * @model
	 * @generated
	 */
	EList<RoboconfFacet> getDependencies();

} // RoboconfFacet
