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
package net.roboconf.eclipse.occi.graph.roboconfgraph.impl;

import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboconf Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.occi.graph.roboconfgraph.impl.RoboconfComponentImpl#getInstallerName <em>Installer Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoboconfComponentImpl extends RoboconfFacetImpl implements RoboconfComponent {
	/**
	 * The default value of the '{@link #getInstallerName() <em>Installer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallerName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALLER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallerName() <em>Installer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallerName()
	 * @generated
	 * @ordered
	 */
	protected String installerName = INSTALLER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboconfComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoboconfgraphPackage.Literals.ROBOCONF_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallerName() {
		return installerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallerName(String newInstallerName) {
		String oldInstallerName = installerName;
		installerName = newInstallerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_COMPONENT__INSTALLER_NAME, oldInstallerName, installerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoboconfgraphPackage.ROBOCONF_COMPONENT__INSTALLER_NAME:
				return getInstallerName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RoboconfgraphPackage.ROBOCONF_COMPONENT__INSTALLER_NAME:
				setInstallerName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RoboconfgraphPackage.ROBOCONF_COMPONENT__INSTALLER_NAME:
				setInstallerName(INSTALLER_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RoboconfgraphPackage.ROBOCONF_COMPONENT__INSTALLER_NAME:
				return INSTALLER_NAME_EDEFAULT == null ? installerName != null : !INSTALLER_NAME_EDEFAULT.equals(installerName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (installerName: ");
		result.append(installerName);
		result.append(')');
		return result.toString();
	}

} //RoboconfComponentImpl
