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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfFactory
 * @model kind="package"
 * @generated
 */
public interface RoboconfEmfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "roboconf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://roboconf.net/eclipse/emf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "roboconf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RoboconfEmfPackage eINSTANCE = net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl <em>Roboconf Graphs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfGraphs()
	 * @generated
	 */
	int ROBOCONF_GRAPHS = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS__FACETS = 3;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS__COMPONENTS = 4;

	/**
	 * The number of structural features of the '<em>Roboconf Graphs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Roboconf Graphs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_GRAPHS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfChildrenLinkImpl <em>Roboconf Children Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfChildrenLinkImpl
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfChildrenLink()
	 * @generated
	 */
	int ROBOCONF_CHILDREN_LINK = 1;

	/**
	 * The number of structural features of the '<em>Roboconf Children Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Roboconf Children Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl <em>Roboconf Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfFacet()
	 * @generated
	 */
	int ROBOCONF_FACET = 4;

	/**
	 * The feature id for the '<em><b>Exports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__EXPORTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__NAME = 1;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__SUB_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__SUPER_TYPES = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__CHILDREN = 4;

	/**
	 * The feature id for the '<em><b>Ancestors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__ANCESTORS = 5;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__DEPENDENCIES = 6;

	/**
	 * The number of structural features of the '<em>Roboconf Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Roboconf Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfComponentImpl <em>Roboconf Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfComponentImpl
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfComponent()
	 * @generated
	 */
	int ROBOCONF_COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Exports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__EXPORTS = ROBOCONF_FACET__EXPORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__NAME = ROBOCONF_FACET__NAME;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__SUB_TYPES = ROBOCONF_FACET__SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__SUPER_TYPES = ROBOCONF_FACET__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__CHILDREN = ROBOCONF_FACET__CHILDREN;

	/**
	 * The feature id for the '<em><b>Ancestors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__ANCESTORS = ROBOCONF_FACET__ANCESTORS;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__DEPENDENCIES = ROBOCONF_FACET__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Installer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__INSTALLER_NAME = ROBOCONF_FACET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__IMPORTS = ROBOCONF_FACET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Roboconf Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT_FEATURE_COUNT = ROBOCONF_FACET_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Roboconf Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT_OPERATION_COUNT = ROBOCONF_FACET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl <em>Roboconf Exported Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfExportedVariable()
	 * @generated
	 */
	int ROBOCONF_EXPORTED_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE = 0;

	/**
	 * The feature id for the '<em><b>External Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Roboconf Exported Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Roboconf Exported Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfImportedVariableImpl <em>Roboconf Imported Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfImportedVariableImpl
	 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfImportedVariable()
	 * @generated
	 */
	int ROBOCONF_IMPORTED_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__OPTIONAL = 0;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__EXTERNAL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Roboconf Imported Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Roboconf Imported Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs <em>Roboconf Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Graphs</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs
	 * @generated
	 */
	EClass getRoboconfGraphs();

	/**
	 * Returns the meta object for the attribute list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getMixed()
	 * @see #getRoboconfGraphs()
	 * @generated
	 */
	EAttribute getRoboconfGraphs_Mixed();

	/**
	 * Returns the meta object for the map '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getXMLNSPrefixMap()
	 * @see #getRoboconfGraphs()
	 * @generated
	 */
	EReference getRoboconfGraphs_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getXSISchemaLocation()
	 * @see #getRoboconfGraphs()
	 * @generated
	 */
	EReference getRoboconfGraphs_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getFacets <em>Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facets</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getFacets()
	 * @see #getRoboconfGraphs()
	 * @generated
	 */
	EReference getRoboconfGraphs_Facets();

	/**
	 * Returns the meta object for the containment reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs#getComponents()
	 * @see #getRoboconfGraphs()
	 * @generated
	 */
	EReference getRoboconfGraphs_Components();

	/**
	 * Returns the meta object for class '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfChildrenLink <em>Roboconf Children Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Children Link</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfChildrenLink
	 * @generated
	 */
	EClass getRoboconfChildrenLink();

	/**
	 * Returns the meta object for class '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent <em>Roboconf Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Component</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent
	 * @generated
	 */
	EClass getRoboconfComponent();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent#getInstallerName <em>Installer Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installer Name</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent#getInstallerName()
	 * @see #getRoboconfComponent()
	 * @generated
	 */
	EAttribute getRoboconfComponent_InstallerName();

	/**
	 * Returns the meta object for the containment reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent#getImports()
	 * @see #getRoboconfComponent()
	 * @generated
	 */
	EReference getRoboconfComponent_Imports();

	/**
	 * Returns the meta object for class '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable <em>Roboconf Exported Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Exported Variable</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable
	 * @generated
	 */
	EClass getRoboconfExportedVariable();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getDefaultValue()
	 * @see #getRoboconfExportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfExportedVariable_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getExternalAlias <em>External Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Alias</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getExternalAlias()
	 * @see #getRoboconfExportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfExportedVariable_ExternalAlias();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable#getName()
	 * @see #getRoboconfExportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfExportedVariable_Name();

	/**
	 * Returns the meta object for class '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet <em>Roboconf Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Facet</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet
	 * @generated
	 */
	EClass getRoboconfFacet();

	/**
	 * Returns the meta object for the containment reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getExports <em>Exports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exports</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getExports()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EReference getRoboconfFacet_Exports();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getName()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EAttribute getRoboconfFacet_Name();

	/**
	 * Returns the meta object for the reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Types</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSubTypes()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EReference getRoboconfFacet_SubTypes();

	/**
	 * Returns the meta object for the reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Types</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getSuperTypes()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EReference getRoboconfFacet_SuperTypes();

	/**
	 * Returns the meta object for the reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getChildren()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EReference getRoboconfFacet_Children();

	/**
	 * Returns the meta object for the reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getAncestors <em>Ancestors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ancestors</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getAncestors()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EReference getRoboconfFacet_Ancestors();

	/**
	 * Returns the meta object for the reference list '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet#getDependencies()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EReference getRoboconfFacet_Dependencies();

	/**
	 * Returns the meta object for class '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable <em>Roboconf Imported Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Imported Variable</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable
	 * @generated
	 */
	EClass getRoboconfImportedVariable();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isOptional()
	 * @see #getRoboconfImportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfImportedVariable_Optional();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#isExternal()
	 * @see #getRoboconfImportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfImportedVariable_External();

	/**
	 * Returns the meta object for the attribute '{@link net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable#getName()
	 * @see #getRoboconfImportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfImportedVariable_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RoboconfEmfFactory getRoboconfEmfFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl <em>Roboconf Graphs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfGraphsImpl
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfGraphs()
		 * @generated
		 */
		EClass ROBOCONF_GRAPHS = eINSTANCE.getRoboconfGraphs();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_GRAPHS__MIXED = eINSTANCE.getRoboconfGraphs_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP = eINSTANCE.getRoboconfGraphs_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION = eINSTANCE.getRoboconfGraphs_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Facets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_GRAPHS__FACETS = eINSTANCE.getRoboconfGraphs_Facets();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_GRAPHS__COMPONENTS = eINSTANCE.getRoboconfGraphs_Components();

		/**
		 * The meta object literal for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfChildrenLinkImpl <em>Roboconf Children Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfChildrenLinkImpl
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfChildrenLink()
		 * @generated
		 */
		EClass ROBOCONF_CHILDREN_LINK = eINSTANCE.getRoboconfChildrenLink();

		/**
		 * The meta object literal for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfComponentImpl <em>Roboconf Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfComponentImpl
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfComponent()
		 * @generated
		 */
		EClass ROBOCONF_COMPONENT = eINSTANCE.getRoboconfComponent();

		/**
		 * The meta object literal for the '<em><b>Installer Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_COMPONENT__INSTALLER_NAME = eINSTANCE.getRoboconfComponent_InstallerName();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_COMPONENT__IMPORTS = eINSTANCE.getRoboconfComponent_Imports();

		/**
		 * The meta object literal for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl <em>Roboconf Exported Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfExportedVariableImpl
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfExportedVariable()
		 * @generated
		 */
		EClass ROBOCONF_EXPORTED_VARIABLE = eINSTANCE.getRoboconfExportedVariable();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE = eINSTANCE.getRoboconfExportedVariable_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>External Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS = eINSTANCE.getRoboconfExportedVariable_ExternalAlias();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_EXPORTED_VARIABLE__NAME = eINSTANCE.getRoboconfExportedVariable_Name();

		/**
		 * The meta object literal for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl <em>Roboconf Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfFacetImpl
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfFacet()
		 * @generated
		 */
		EClass ROBOCONF_FACET = eINSTANCE.getRoboconfFacet();

		/**
		 * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_FACET__EXPORTS = eINSTANCE.getRoboconfFacet_Exports();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_FACET__NAME = eINSTANCE.getRoboconfFacet_Name();

		/**
		 * The meta object literal for the '<em><b>Sub Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_FACET__SUB_TYPES = eINSTANCE.getRoboconfFacet_SubTypes();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_FACET__SUPER_TYPES = eINSTANCE.getRoboconfFacet_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_FACET__CHILDREN = eINSTANCE.getRoboconfFacet_Children();

		/**
		 * The meta object literal for the '<em><b>Ancestors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_FACET__ANCESTORS = eINSTANCE.getRoboconfFacet_Ancestors();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOCONF_FACET__DEPENDENCIES = eINSTANCE.getRoboconfFacet_Dependencies();

		/**
		 * The meta object literal for the '{@link net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfImportedVariableImpl <em>Roboconf Imported Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfImportedVariableImpl
		 * @see net.roboconf.eclipse.emf.models.roboconf.impl.RoboconfEmfPackageImpl#getRoboconfImportedVariable()
		 * @generated
		 */
		EClass ROBOCONF_IMPORTED_VARIABLE = eINSTANCE.getRoboconfImportedVariable();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_IMPORTED_VARIABLE__OPTIONAL = eINSTANCE.getRoboconfImportedVariable_Optional();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_IMPORTED_VARIABLE__EXTERNAL = eINSTANCE.getRoboconfImportedVariable_External();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_IMPORTED_VARIABLE__NAME = eINSTANCE.getRoboconfImportedVariable_Name();

	}

} //RoboconfEmfPackage
