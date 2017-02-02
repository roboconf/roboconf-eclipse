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

import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboconf Exported Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl#getExternalAlias <em>External Alias</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoboconfExportedVariableImpl extends MinimalEObjectImpl.Container implements RoboconfExportedVariable {
	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExternalAlias() <em>External Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExternalAlias() <em>External Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalAlias()
	 * @generated
	 * @ordered
	 */
	protected String externalAlias = EXTERNAL_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboconfExportedVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoboconfEmfPackage.Literals.ROBOCONF_EXPORTED_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalAlias() {
		return externalAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalAlias(String newExternalAlias) {
		String oldExternalAlias = externalAlias;
		externalAlias = newExternalAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS, oldExternalAlias, externalAlias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE:
				return getDefaultValue();
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS:
				return getExternalAlias();
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				return getName();
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
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS:
				setExternalAlias((String)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				setName((String)newValue);
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
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS:
				setExternalAlias(EXTERNAL_ALIAS_EDEFAULT);
				return;
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
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
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS:
				return EXTERNAL_ALIAS_EDEFAULT == null ? externalAlias != null : !EXTERNAL_ALIAS_EDEFAULT.equals(externalAlias);
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (defaultValue: ");
		result.append(defaultValue);
		result.append(", externalAlias: ");
		result.append(externalAlias);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RoboconfExportedVariableImpl
