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
package net.roboconf.eclipse.emf.models.roboconf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roboconf Exported Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getExternalAlias <em>External Alias</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfExportedVariable()
 * @model extendedMetaData="name='RoboconfExportedVariable' kind='empty'"
 * @generated
 */
public interface RoboconfExportedVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfExportedVariable_DefaultValue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='default-value'"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>External Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Alias</em>' attribute.
	 * @see #setExternalAlias(String)
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfExportedVariable_ExternalAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='external-alias'"
	 * @generated
	 */
	String getExternalAlias();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getExternalAlias <em>External Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Alias</em>' attribute.
	 * @see #getExternalAlias()
	 * @generated
	 */
	void setExternalAlias(String value);

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
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfExportedVariable_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // RoboconfExportedVariable
