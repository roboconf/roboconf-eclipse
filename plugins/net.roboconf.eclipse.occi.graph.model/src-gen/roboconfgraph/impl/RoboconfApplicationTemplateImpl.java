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
 * 
 */
package roboconfgraph.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.occiware.clouddesigner.occi.impl.ResourceImpl;

import roboconfgraph.RoboconfApplicationTemplate;
import roboconfgraph.RoboconfgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboconf Application Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link roboconfgraph.impl.RoboconfApplicationTemplateImpl#getName <em>Name</em>}</li>
 *   <li>{@link roboconfgraph.impl.RoboconfApplicationTemplateImpl#getDesc <em>Desc</em>}</li>
 *   <li>{@link roboconfgraph.impl.RoboconfApplicationTemplateImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link roboconfgraph.impl.RoboconfApplicationTemplateImpl#getExternalVariablesPrefix <em>External Variables Prefix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoboconfApplicationTemplateImpl extends ResourceImpl implements RoboconfApplicationTemplate {
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
	 * The default value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String DESC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected String desc = DESC_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getExternalVariablesPrefix() <em>External Variables Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalVariablesPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_VARIABLES_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExternalVariablesPrefix() <em>External Variables Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalVariablesPrefix()
	 * @generated
	 * @ordered
	 */
	protected String externalVariablesPrefix = EXTERNAL_VARIABLES_PREFIX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboconfApplicationTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoboconfgraphPackage.Literals.ROBOCONF_APPLICATION_TEMPLATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesc(String newDesc) {
		String oldDesc = desc;
		desc = newDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__DESC, oldDesc, desc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalVariablesPrefix() {
		return externalVariablesPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalVariablesPrefix(String newExternalVariablesPrefix) {
		String oldExternalVariablesPrefix = externalVariablesPrefix;
		externalVariablesPrefix = newExternalVariablesPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX, oldExternalVariablesPrefix, externalVariablesPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__NAME:
				return getName();
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__DESC:
				return getDesc();
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__VERSION:
				return getVersion();
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX:
				return getExternalVariablesPrefix();
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
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__NAME:
				setName((String)newValue);
				return;
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__DESC:
				setDesc((String)newValue);
				return;
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__VERSION:
				setVersion((String)newValue);
				return;
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX:
				setExternalVariablesPrefix((String)newValue);
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
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__DESC:
				setDesc(DESC_EDEFAULT);
				return;
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX:
				setExternalVariablesPrefix(EXTERNAL_VARIABLES_PREFIX_EDEFAULT);
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
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__DESC:
				return DESC_EDEFAULT == null ? desc != null : !DESC_EDEFAULT.equals(desc);
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX:
				return EXTERNAL_VARIABLES_PREFIX_EDEFAULT == null ? externalVariablesPrefix != null : !EXTERNAL_VARIABLES_PREFIX_EDEFAULT.equals(externalVariablesPrefix);
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
		result.append(", desc: ");
		result.append(desc);
		result.append(", version: ");
		result.append(version);
		result.append(", externalVariablesPrefix: ");
		result.append(externalVariablesPrefix);
		result.append(')');
		return result.toString();
	}

} //RoboconfApplicationTemplateImpl
