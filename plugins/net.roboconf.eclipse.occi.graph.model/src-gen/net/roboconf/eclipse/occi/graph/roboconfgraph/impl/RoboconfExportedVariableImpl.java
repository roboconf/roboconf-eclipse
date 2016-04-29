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

import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfExportedVariable;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.occiware.clouddesigner.occi.impl.ResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboconf Exported Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.occi.graph.roboconfgraph.impl.RoboconfExportedVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.roboconf.eclipse.occi.graph.roboconfgraph.impl.RoboconfExportedVariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link net.roboconf.eclipse.occi.graph.roboconfgraph.impl.RoboconfExportedVariableImpl#getPublicAlias <em>Public Alias</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoboconfExportedVariableImpl extends ResourceImpl implements RoboconfExportedVariable {
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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublicAlias() <em>Public Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLIC_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicAlias() <em>Public Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicAlias()
	 * @generated
	 * @ordered
	 */
	protected String publicAlias = PUBLIC_ALIAS_EDEFAULT;

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
		return RoboconfgraphPackage.Literals.ROBOCONF_EXPORTED_VARIABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublicAlias() {
		return publicAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicAlias(String newPublicAlias) {
		String oldPublicAlias = publicAlias;
		publicAlias = newPublicAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS, oldPublicAlias, publicAlias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				return getName();
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__VALUE:
				return getValue();
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS:
				return getPublicAlias();
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
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				setName((String)newValue);
				return;
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__VALUE:
				setValue((String)newValue);
				return;
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS:
				setPublicAlias((String)newValue);
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
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS:
				setPublicAlias(PUBLIC_ALIAS_EDEFAULT);
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
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS:
				return PUBLIC_ALIAS_EDEFAULT == null ? publicAlias != null : !PUBLIC_ALIAS_EDEFAULT.equals(publicAlias);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(", publicAlias: ");
		result.append(publicAlias);
		result.append(')');
		return result.toString();
	}

} //RoboconfExportedVariableImpl
