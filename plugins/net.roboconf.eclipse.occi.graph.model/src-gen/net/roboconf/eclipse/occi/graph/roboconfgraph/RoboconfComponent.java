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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roboconf Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent#getInstallerName <em>Installer Name</em>}</li>
 * </ul>
 *
 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage#getRoboconfComponent()
 * @model annotation="OCCIE2Ecore title='null'"
 * @generated
 */
public interface RoboconfComponent extends RoboconfFacet {
	/**
	 * Returns the value of the '<em><b>Installer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installer Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installer Name</em>' attribute.
	 * @see #setInstallerName(String)
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage#getRoboconfComponent_InstallerName()
	 * @model dataType="org.occiware.clouddesigner.occi.String"
	 *        annotation="OCCIE2Ecore description='null'"
	 * @generated
	 */
	String getInstallerName();

	/**
	 * Sets the value of the '{@link net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent#getInstallerName <em>Installer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installer Name</em>' attribute.
	 * @see #getInstallerName()
	 * @generated
	 */
	void setInstallerName(String value);

} // RoboconfComponent
