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
package net.roboconf.eclipse.emf.models.roboconf.impl;

import java.util.Collection;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboconf Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getExports <em>Exports</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getAncestors <em>Ancestors</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoboconfFacetImpl extends MinimalEObjectImpl.Container implements RoboconfFacet {
	/**
	 * The cached value of the '{@link #getExports() <em>Exports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExports()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfExportedVariable> exports;

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
	 * The cached value of the '{@link #getSubTypes() <em>Sub Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfFacet> subTypes;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfFacet> superTypes;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfFacet> children;

	/**
	 * The cached value of the '{@link #getAncestors() <em>Ancestors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAncestors()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfFacet> ancestors;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfFacet> dependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboconfFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoboconfEmfPackage.Literals.ROBOCONF_FACET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfExportedVariable> getExports() {
		if (exports == null) {
			exports = new EObjectContainmentEList<RoboconfExportedVariable>(RoboconfExportedVariable.class, this, RoboconfEmfPackage.ROBOCONF_FACET__EXPORTS);
		}
		return exports;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoboconfEmfPackage.ROBOCONF_FACET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfFacet> getSubTypes() {
		if (subTypes == null) {
			subTypes = new EObjectWithInverseResolvingEList.ManyInverse<RoboconfFacet>(RoboconfFacet.class, this, RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES, RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES);
		}
		return subTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfFacet> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectWithInverseResolvingEList.ManyInverse<RoboconfFacet>(RoboconfFacet.class, this, RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES, RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfFacet> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList.ManyInverse<RoboconfFacet>(RoboconfFacet.class, this, RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN, RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfFacet> getAncestors() {
		if (ancestors == null) {
			ancestors = new EObjectWithInverseResolvingEList.ManyInverse<RoboconfFacet>(RoboconfFacet.class, this, RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS, RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN);
		}
		return ancestors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfFacet> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectResolvingEList<RoboconfFacet>(RoboconfFacet.class, this, RoboconfEmfPackage.ROBOCONF_FACET__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubTypes()).basicAdd(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSuperTypes()).basicAdd(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAncestors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RoboconfEmfPackage.ROBOCONF_FACET__EXPORTS:
				return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES:
				return ((InternalEList<?>)getSubTypes()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS:
				return ((InternalEList<?>)getAncestors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoboconfEmfPackage.ROBOCONF_FACET__EXPORTS:
				return getExports();
			case RoboconfEmfPackage.ROBOCONF_FACET__NAME:
				return getName();
			case RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES:
				return getSubTypes();
			case RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES:
				return getSuperTypes();
			case RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN:
				return getChildren();
			case RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS:
				return getAncestors();
			case RoboconfEmfPackage.ROBOCONF_FACET__DEPENDENCIES:
				return getDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RoboconfEmfPackage.ROBOCONF_FACET__EXPORTS:
				getExports().clear();
				getExports().addAll((Collection<? extends RoboconfExportedVariable>)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__NAME:
				setName((String)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES:
				getSubTypes().clear();
				getSubTypes().addAll((Collection<? extends RoboconfFacet>)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends RoboconfFacet>)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends RoboconfFacet>)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS:
				getAncestors().clear();
				getAncestors().addAll((Collection<? extends RoboconfFacet>)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends RoboconfFacet>)newValue);
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
			case RoboconfEmfPackage.ROBOCONF_FACET__EXPORTS:
				getExports().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES:
				getSubTypes().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN:
				getChildren().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS:
				getAncestors().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_FACET__DEPENDENCIES:
				getDependencies().clear();
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
			case RoboconfEmfPackage.ROBOCONF_FACET__EXPORTS:
				return exports != null && !exports.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_FACET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RoboconfEmfPackage.ROBOCONF_FACET__SUB_TYPES:
				return subTypes != null && !subTypes.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_FACET__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_FACET__CHILDREN:
				return children != null && !children.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_FACET__ANCESTORS:
				return ancestors != null && !ancestors.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_FACET__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //RoboconfFacetImpl
