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

import java.util.Collection;

import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboconf Graphs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl#getFacets <em>Facets</em>}</li>
 *   <li>{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl#getComponents <em>Components</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoboconfGraphsImpl extends MinimalEObjectImpl.Container implements RoboconfGraphs {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * The cached value of the '{@link #getFacets() <em>Facets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacets()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfFacet> facets;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboconfComponent> components;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboconfGraphsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoboconfEmfPackage.Literals.ROBOCONF_GRAPHS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, RoboconfEmfPackage.ROBOCONF_GRAPHS__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, RoboconfEmfPackage.ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, RoboconfEmfPackage.ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfFacet> getFacets() {
		if (facets == null) {
			facets = new EObjectContainmentEList<RoboconfFacet>(RoboconfFacet.class, this, RoboconfEmfPackage.ROBOCONF_GRAPHS__FACETS);
		}
		return facets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoboconfComponent> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<RoboconfComponent>(RoboconfComponent.class, this, RoboconfEmfPackage.ROBOCONF_GRAPHS__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__FACETS:
				return ((InternalEList<?>)getFacets()).basicRemove(otherEnd, msgs);
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
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
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__FACETS:
				return getFacets();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__COMPONENTS:
				return getComponents();
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
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__FACETS:
				getFacets().clear();
				getFacets().addAll((Collection<? extends RoboconfFacet>)newValue);
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends RoboconfComponent>)newValue);
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
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__MIXED:
				getMixed().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__FACETS:
				getFacets().clear();
				return;
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__COMPONENTS:
				getComponents().clear();
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
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__MIXED:
				return mixed != null && !mixed.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__FACETS:
				return facets != null && !facets.isEmpty();
			case RoboconfEmfPackage.ROBOCONF_GRAPHS__COMPONENTS:
				return components != null && !components.isEmpty();
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //RoboconfGraphsImpl
