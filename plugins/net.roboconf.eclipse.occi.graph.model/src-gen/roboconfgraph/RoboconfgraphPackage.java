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
package roboconfgraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.occiware.clouddesigner.occi.OCCIPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see roboconfgraph.RoboconfgraphFactory
 * @model kind="package"
 * @generated
 */
public interface RoboconfgraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "roboconfgraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://roboconf.net/graph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "roboconfgraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RoboconfgraphPackage eINSTANCE = roboconfgraph.impl.RoboconfgraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfFacetImpl <em>Roboconf Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfFacetImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfFacet()
	 * @generated
	 */
	int ROBOCONF_FACET = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__ID = OCCIPackage.RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__KIND = OCCIPackage.RESOURCE__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__MIXINS = OCCIPackage.RESOURCE__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__ATTRIBUTES = OCCIPackage.RESOURCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__LINKS = OCCIPackage.RESOURCE__LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET__NAME = OCCIPackage.RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Roboconf Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_FACET_FEATURE_COUNT = OCCIPackage.RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfComponentImpl <em>Roboconf Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfComponentImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfComponent()
	 * @generated
	 */
	int ROBOCONF_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__ID = ROBOCONF_FACET__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__KIND = ROBOCONF_FACET__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__MIXINS = ROBOCONF_FACET__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__ATTRIBUTES = ROBOCONF_FACET__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__LINKS = ROBOCONF_FACET__LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__NAME = ROBOCONF_FACET__NAME;

	/**
	 * The feature id for the '<em><b>Installer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT__INSTALLER_NAME = ROBOCONF_FACET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Roboconf Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_COMPONENT_FEATURE_COUNT = ROBOCONF_FACET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfApplicationTemplateImpl <em>Roboconf Application Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfApplicationTemplateImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfApplicationTemplate()
	 * @generated
	 */
	int ROBOCONF_APPLICATION_TEMPLATE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__ID = OCCIPackage.RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__KIND = OCCIPackage.RESOURCE__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__MIXINS = OCCIPackage.RESOURCE__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__ATTRIBUTES = OCCIPackage.RESOURCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__LINKS = OCCIPackage.RESOURCE__LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__NAME = OCCIPackage.RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__DESC = OCCIPackage.RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__VERSION = OCCIPackage.RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>External Variables Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX = OCCIPackage.RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Roboconf Application Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_APPLICATION_TEMPLATE_FEATURE_COUNT = OCCIPackage.RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfExportedVariableImpl <em>Roboconf Exported Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfExportedVariableImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfExportedVariable()
	 * @generated
	 */
	int ROBOCONF_EXPORTED_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__ID = OCCIPackage.RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__KIND = OCCIPackage.RESOURCE__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__MIXINS = OCCIPackage.RESOURCE__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__ATTRIBUTES = OCCIPackage.RESOURCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__LINKS = OCCIPackage.RESOURCE__LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__NAME = OCCIPackage.RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__VALUE = OCCIPackage.RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Public Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS = OCCIPackage.RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Roboconf Exported Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_EXPORTED_VARIABLE_FEATURE_COUNT = OCCIPackage.RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfImportedVariableImpl <em>Roboconf Imported Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfImportedVariableImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfImportedVariable()
	 * @generated
	 */
	int ROBOCONF_IMPORTED_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__ID = OCCIPackage.RESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__KIND = OCCIPackage.RESOURCE__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__MIXINS = OCCIPackage.RESOURCE__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__ATTRIBUTES = OCCIPackage.RESOURCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__LINKS = OCCIPackage.RESOURCE__LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__NAME = OCCIPackage.RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__OPTIONAL = OCCIPackage.RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE__EXTERNAL = OCCIPackage.RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Roboconf Imported Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_IMPORTED_VARIABLE_FEATURE_COUNT = OCCIPackage.RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfOwnerLinkImpl <em>Roboconf Owner Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfOwnerLinkImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfOwnerLink()
	 * @generated
	 */
	int ROBOCONF_OWNER_LINK = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK__ID = OCCIPackage.LINK__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK__KIND = OCCIPackage.LINK__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK__MIXINS = OCCIPackage.LINK__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK__ATTRIBUTES = OCCIPackage.LINK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK__SOURCE = OCCIPackage.LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK__TARGET = OCCIPackage.LINK__TARGET;

	/**
	 * The number of structural features of the '<em>Roboconf Owner Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_OWNER_LINK_FEATURE_COUNT = OCCIPackage.LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfInheritanceLinkImpl <em>Roboconf Inheritance Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfInheritanceLinkImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfInheritanceLink()
	 * @generated
	 */
	int ROBOCONF_INHERITANCE_LINK = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK__ID = OCCIPackage.LINK__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK__KIND = OCCIPackage.LINK__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK__MIXINS = OCCIPackage.LINK__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK__ATTRIBUTES = OCCIPackage.LINK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK__SOURCE = OCCIPackage.LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK__TARGET = OCCIPackage.LINK__TARGET;

	/**
	 * The number of structural features of the '<em>Roboconf Inheritance Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_INHERITANCE_LINK_FEATURE_COUNT = OCCIPackage.LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfChildrenLinkImpl <em>Roboconf Children Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfChildrenLinkImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfChildrenLink()
	 * @generated
	 */
	int ROBOCONF_CHILDREN_LINK = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK__ID = OCCIPackage.LINK__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK__KIND = OCCIPackage.LINK__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK__MIXINS = OCCIPackage.LINK__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK__ATTRIBUTES = OCCIPackage.LINK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK__SOURCE = OCCIPackage.LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK__TARGET = OCCIPackage.LINK__TARGET;

	/**
	 * The number of structural features of the '<em>Roboconf Children Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_CHILDREN_LINK_FEATURE_COUNT = OCCIPackage.LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link roboconfgraph.impl.RoboconfRuntimeLinkImpl <em>Roboconf Runtime Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roboconfgraph.impl.RoboconfRuntimeLinkImpl
	 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfRuntimeLink()
	 * @generated
	 */
	int ROBOCONF_RUNTIME_LINK = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK__ID = OCCIPackage.LINK__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK__KIND = OCCIPackage.LINK__KIND;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK__MIXINS = OCCIPackage.LINK__MIXINS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK__ATTRIBUTES = OCCIPackage.LINK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK__SOURCE = OCCIPackage.LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK__TARGET = OCCIPackage.LINK__TARGET;

	/**
	 * The number of structural features of the '<em>Roboconf Runtime Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOCONF_RUNTIME_LINK_FEATURE_COUNT = OCCIPackage.LINK_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfComponent <em>Roboconf Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Component</em>'.
	 * @see roboconfgraph.RoboconfComponent
	 * @generated
	 */
	EClass getRoboconfComponent();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfComponent#getInstallerName <em>Installer Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installer Name</em>'.
	 * @see roboconfgraph.RoboconfComponent#getInstallerName()
	 * @see #getRoboconfComponent()
	 * @generated
	 */
	EAttribute getRoboconfComponent_InstallerName();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfFacet <em>Roboconf Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Facet</em>'.
	 * @see roboconfgraph.RoboconfFacet
	 * @generated
	 */
	EClass getRoboconfFacet();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfFacet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roboconfgraph.RoboconfFacet#getName()
	 * @see #getRoboconfFacet()
	 * @generated
	 */
	EAttribute getRoboconfFacet_Name();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfApplicationTemplate <em>Roboconf Application Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Application Template</em>'.
	 * @see roboconfgraph.RoboconfApplicationTemplate
	 * @generated
	 */
	EClass getRoboconfApplicationTemplate();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfApplicationTemplate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roboconfgraph.RoboconfApplicationTemplate#getName()
	 * @see #getRoboconfApplicationTemplate()
	 * @generated
	 */
	EAttribute getRoboconfApplicationTemplate_Name();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfApplicationTemplate#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see roboconfgraph.RoboconfApplicationTemplate#getDesc()
	 * @see #getRoboconfApplicationTemplate()
	 * @generated
	 */
	EAttribute getRoboconfApplicationTemplate_Desc();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfApplicationTemplate#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see roboconfgraph.RoboconfApplicationTemplate#getVersion()
	 * @see #getRoboconfApplicationTemplate()
	 * @generated
	 */
	EAttribute getRoboconfApplicationTemplate_Version();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfApplicationTemplate#getExternalVariablesPrefix <em>External Variables Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Variables Prefix</em>'.
	 * @see roboconfgraph.RoboconfApplicationTemplate#getExternalVariablesPrefix()
	 * @see #getRoboconfApplicationTemplate()
	 * @generated
	 */
	EAttribute getRoboconfApplicationTemplate_ExternalVariablesPrefix();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfExportedVariable <em>Roboconf Exported Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Exported Variable</em>'.
	 * @see roboconfgraph.RoboconfExportedVariable
	 * @generated
	 */
	EClass getRoboconfExportedVariable();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfExportedVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roboconfgraph.RoboconfExportedVariable#getName()
	 * @see #getRoboconfExportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfExportedVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfExportedVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roboconfgraph.RoboconfExportedVariable#getValue()
	 * @see #getRoboconfExportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfExportedVariable_Value();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfExportedVariable#getPublicAlias <em>Public Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Alias</em>'.
	 * @see roboconfgraph.RoboconfExportedVariable#getPublicAlias()
	 * @see #getRoboconfExportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfExportedVariable_PublicAlias();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfImportedVariable <em>Roboconf Imported Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Imported Variable</em>'.
	 * @see roboconfgraph.RoboconfImportedVariable
	 * @generated
	 */
	EClass getRoboconfImportedVariable();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfImportedVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roboconfgraph.RoboconfImportedVariable#getName()
	 * @see #getRoboconfImportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfImportedVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfImportedVariable#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see roboconfgraph.RoboconfImportedVariable#isOptional()
	 * @see #getRoboconfImportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfImportedVariable_Optional();

	/**
	 * Returns the meta object for the attribute '{@link roboconfgraph.RoboconfImportedVariable#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see roboconfgraph.RoboconfImportedVariable#isExternal()
	 * @see #getRoboconfImportedVariable()
	 * @generated
	 */
	EAttribute getRoboconfImportedVariable_External();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfOwnerLink <em>Roboconf Owner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Owner Link</em>'.
	 * @see roboconfgraph.RoboconfOwnerLink
	 * @generated
	 */
	EClass getRoboconfOwnerLink();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfInheritanceLink <em>Roboconf Inheritance Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Inheritance Link</em>'.
	 * @see roboconfgraph.RoboconfInheritanceLink
	 * @generated
	 */
	EClass getRoboconfInheritanceLink();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfChildrenLink <em>Roboconf Children Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Children Link</em>'.
	 * @see roboconfgraph.RoboconfChildrenLink
	 * @generated
	 */
	EClass getRoboconfChildrenLink();

	/**
	 * Returns the meta object for class '{@link roboconfgraph.RoboconfRuntimeLink <em>Roboconf Runtime Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboconf Runtime Link</em>'.
	 * @see roboconfgraph.RoboconfRuntimeLink
	 * @generated
	 */
	EClass getRoboconfRuntimeLink();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RoboconfgraphFactory getRoboconfgraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfComponentImpl <em>Roboconf Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfComponentImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfComponent()
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
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfFacetImpl <em>Roboconf Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfFacetImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfFacet()
		 * @generated
		 */
		EClass ROBOCONF_FACET = eINSTANCE.getRoboconfFacet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_FACET__NAME = eINSTANCE.getRoboconfFacet_Name();

		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfApplicationTemplateImpl <em>Roboconf Application Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfApplicationTemplateImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfApplicationTemplate()
		 * @generated
		 */
		EClass ROBOCONF_APPLICATION_TEMPLATE = eINSTANCE.getRoboconfApplicationTemplate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_APPLICATION_TEMPLATE__NAME = eINSTANCE.getRoboconfApplicationTemplate_Name();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_APPLICATION_TEMPLATE__DESC = eINSTANCE.getRoboconfApplicationTemplate_Desc();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_APPLICATION_TEMPLATE__VERSION = eINSTANCE.getRoboconfApplicationTemplate_Version();

		/**
		 * The meta object literal for the '<em><b>External Variables Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_APPLICATION_TEMPLATE__EXTERNAL_VARIABLES_PREFIX = eINSTANCE.getRoboconfApplicationTemplate_ExternalVariablesPrefix();

		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfExportedVariableImpl <em>Roboconf Exported Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfExportedVariableImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfExportedVariable()
		 * @generated
		 */
		EClass ROBOCONF_EXPORTED_VARIABLE = eINSTANCE.getRoboconfExportedVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_EXPORTED_VARIABLE__NAME = eINSTANCE.getRoboconfExportedVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_EXPORTED_VARIABLE__VALUE = eINSTANCE.getRoboconfExportedVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Public Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS = eINSTANCE.getRoboconfExportedVariable_PublicAlias();

		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfImportedVariableImpl <em>Roboconf Imported Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfImportedVariableImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfImportedVariable()
		 * @generated
		 */
		EClass ROBOCONF_IMPORTED_VARIABLE = eINSTANCE.getRoboconfImportedVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOCONF_IMPORTED_VARIABLE__NAME = eINSTANCE.getRoboconfImportedVariable_Name();

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
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfOwnerLinkImpl <em>Roboconf Owner Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfOwnerLinkImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfOwnerLink()
		 * @generated
		 */
		EClass ROBOCONF_OWNER_LINK = eINSTANCE.getRoboconfOwnerLink();

		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfInheritanceLinkImpl <em>Roboconf Inheritance Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfInheritanceLinkImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfInheritanceLink()
		 * @generated
		 */
		EClass ROBOCONF_INHERITANCE_LINK = eINSTANCE.getRoboconfInheritanceLink();

		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfChildrenLinkImpl <em>Roboconf Children Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfChildrenLinkImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfChildrenLink()
		 * @generated
		 */
		EClass ROBOCONF_CHILDREN_LINK = eINSTANCE.getRoboconfChildrenLink();

		/**
		 * The meta object literal for the '{@link roboconfgraph.impl.RoboconfRuntimeLinkImpl <em>Roboconf Runtime Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roboconfgraph.impl.RoboconfRuntimeLinkImpl
		 * @see roboconfgraph.impl.RoboconfgraphPackageImpl#getRoboconfRuntimeLink()
		 * @generated
		 */
		EClass ROBOCONF_RUNTIME_LINK = eINSTANCE.getRoboconfRuntimeLink();

	}

} //RoboconfgraphPackage
