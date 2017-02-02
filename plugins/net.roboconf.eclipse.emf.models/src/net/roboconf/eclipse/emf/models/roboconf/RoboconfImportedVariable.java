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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roboconf Imported Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isOptional <em>Optional</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isExternal <em>External</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfImportedVariable()
 * @model extendedMetaData="name='RoboconfImportedVariable' kind='empty'"
 * @generated
 */
public interface RoboconfImportedVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfImportedVariable_Optional()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='default-value'"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>External</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External</em>' attribute.
	 * @see #setExternal(boolean)
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfImportedVariable_External()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='external-alias'"
	 * @generated
	 */
	boolean isExternal();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isExternal <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External</em>' attribute.
	 * @see #isExternal()
	 * @generated
	 */
	void setExternal(boolean value);

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
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#getRoboconfImportedVariable_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // RoboconfImportedVariable
