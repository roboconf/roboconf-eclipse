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

import net.roboconf.eclipse.emf.models.roboconf.RoboconfChildrenLink;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfComponent;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfFactory;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfExportedVariable;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfFacet;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfGraphs;
import net.roboconf.eclipse.emf.models.roboconf.RoboconfImportedVariable;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoboconfEmfPackageImpl extends EPackageImpl implements RoboconfEmfPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfGraphsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfChildrenLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfExportedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfFacetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfImportedVariableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RoboconfEmfPackageImpl() {
		super(eNS_URI, RoboconfEmfFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RoboconfEmfPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RoboconfEmfPackage init() {
		if (isInited) return (RoboconfEmfPackage)EPackage.Registry.INSTANCE.getEPackage(RoboconfEmfPackage.eNS_URI);

		// Obtain or create and register package
		RoboconfEmfPackageImpl theRoboconfEmfPackage = (RoboconfEmfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RoboconfEmfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RoboconfEmfPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRoboconfEmfPackage.createPackageContents();

		// Initialize created meta-data
		theRoboconfEmfPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRoboconfEmfPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RoboconfEmfPackage.eNS_URI, theRoboconfEmfPackage);
		return theRoboconfEmfPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfGraphs() {
		return roboconfGraphsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfGraphs_Mixed() {
		return (EAttribute)roboconfGraphsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfGraphs_XMLNSPrefixMap() {
		return (EReference)roboconfGraphsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfGraphs_XSISchemaLocation() {
		return (EReference)roboconfGraphsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfGraphs_Facets() {
		return (EReference)roboconfGraphsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfGraphs_Components() {
		return (EReference)roboconfGraphsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfChildrenLink() {
		return roboconfChildrenLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfComponent() {
		return roboconfComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfComponent_InstallerName() {
		return (EAttribute)roboconfComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfComponent_Imports() {
		return (EReference)roboconfComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfExportedVariable() {
		return roboconfExportedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfExportedVariable_DefaultValue() {
		return (EAttribute)roboconfExportedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfExportedVariable_ExternalAlias() {
		return (EAttribute)roboconfExportedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfExportedVariable_Name() {
		return (EAttribute)roboconfExportedVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfFacet() {
		return roboconfFacetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfFacet_Exports() {
		return (EReference)roboconfFacetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfFacet_Name() {
		return (EAttribute)roboconfFacetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfFacet_SubTypes() {
		return (EReference)roboconfFacetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfFacet_SuperTypes() {
		return (EReference)roboconfFacetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfFacet_Children() {
		return (EReference)roboconfFacetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfFacet_Ancestors() {
		return (EReference)roboconfFacetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboconfFacet_Dependencies() {
		return (EReference)roboconfFacetEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfImportedVariable() {
		return roboconfImportedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfImportedVariable_Optional() {
		return (EAttribute)roboconfImportedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfImportedVariable_External() {
		return (EAttribute)roboconfImportedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfImportedVariable_Name() {
		return (EAttribute)roboconfImportedVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfEmfFactory getRoboconfEmfFactory() {
		return (RoboconfEmfFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		roboconfGraphsEClass = createEClass(ROBOCONF_GRAPHS);
		createEAttribute(roboconfGraphsEClass, ROBOCONF_GRAPHS__MIXED);
		createEReference(roboconfGraphsEClass, ROBOCONF_GRAPHS__XMLNS_PREFIX_MAP);
		createEReference(roboconfGraphsEClass, ROBOCONF_GRAPHS__XSI_SCHEMA_LOCATION);
		createEReference(roboconfGraphsEClass, ROBOCONF_GRAPHS__FACETS);
		createEReference(roboconfGraphsEClass, ROBOCONF_GRAPHS__COMPONENTS);

		roboconfChildrenLinkEClass = createEClass(ROBOCONF_CHILDREN_LINK);

		roboconfComponentEClass = createEClass(ROBOCONF_COMPONENT);
		createEAttribute(roboconfComponentEClass, ROBOCONF_COMPONENT__INSTALLER_NAME);
		createEReference(roboconfComponentEClass, ROBOCONF_COMPONENT__IMPORTS);

		roboconfExportedVariableEClass = createEClass(ROBOCONF_EXPORTED_VARIABLE);
		createEAttribute(roboconfExportedVariableEClass, ROBOCONF_EXPORTED_VARIABLE__DEFAULT_VALUE);
		createEAttribute(roboconfExportedVariableEClass, ROBOCONF_EXPORTED_VARIABLE__EXTERNAL_ALIAS);
		createEAttribute(roboconfExportedVariableEClass, ROBOCONF_EXPORTED_VARIABLE__NAME);

		roboconfFacetEClass = createEClass(ROBOCONF_FACET);
		createEReference(roboconfFacetEClass, ROBOCONF_FACET__EXPORTS);
		createEAttribute(roboconfFacetEClass, ROBOCONF_FACET__NAME);
		createEReference(roboconfFacetEClass, ROBOCONF_FACET__SUB_TYPES);
		createEReference(roboconfFacetEClass, ROBOCONF_FACET__SUPER_TYPES);
		createEReference(roboconfFacetEClass, ROBOCONF_FACET__CHILDREN);
		createEReference(roboconfFacetEClass, ROBOCONF_FACET__ANCESTORS);
		createEReference(roboconfFacetEClass, ROBOCONF_FACET__DEPENDENCIES);

		roboconfImportedVariableEClass = createEClass(ROBOCONF_IMPORTED_VARIABLE);
		createEAttribute(roboconfImportedVariableEClass, ROBOCONF_IMPORTED_VARIABLE__OPTIONAL);
		createEAttribute(roboconfImportedVariableEClass, ROBOCONF_IMPORTED_VARIABLE__EXTERNAL);
		createEAttribute(roboconfImportedVariableEClass, ROBOCONF_IMPORTED_VARIABLE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		roboconfComponentEClass.getESuperTypes().add(this.getRoboconfFacet());

		// Initialize classes, features, and operations; add parameters
		initEClass(roboconfGraphsEClass, RoboconfGraphs.class, "RoboconfGraphs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfGraphs_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, RoboconfGraphs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfGraphs_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, RoboconfGraphs.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfGraphs_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, RoboconfGraphs.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfGraphs_Facets(), this.getRoboconfFacet(), null, "facets", null, 0, -1, RoboconfGraphs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfGraphs_Components(), this.getRoboconfComponent(), null, "components", null, 0, -1, RoboconfGraphs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfChildrenLinkEClass, RoboconfChildrenLink.class, "RoboconfChildrenLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roboconfComponentEClass, RoboconfComponent.class, "RoboconfComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfComponent_InstallerName(), theXMLTypePackage.getString(), "installerName", "", 1, 1, RoboconfComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfComponent_Imports(), this.getRoboconfImportedVariable(), null, "imports", null, 0, -1, RoboconfComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfExportedVariableEClass, RoboconfExportedVariable.class, "RoboconfExportedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfExportedVariable_DefaultValue(), theXMLTypePackage.getString(), "defaultValue", null, 0, 1, RoboconfExportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfExportedVariable_ExternalAlias(), theXMLTypePackage.getString(), "externalAlias", null, 0, 1, RoboconfExportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfExportedVariable_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, RoboconfExportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfFacetEClass, RoboconfFacet.class, "RoboconfFacet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoboconfFacet_Exports(), this.getRoboconfExportedVariable(), null, "exports", null, 0, -1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfFacet_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfFacet_SubTypes(), this.getRoboconfFacet(), this.getRoboconfFacet_SuperTypes(), "subTypes", null, 0, -1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfFacet_SuperTypes(), this.getRoboconfFacet(), this.getRoboconfFacet_SubTypes(), "superTypes", null, 0, -1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfFacet_Children(), this.getRoboconfFacet(), this.getRoboconfFacet_Ancestors(), "children", null, 0, -1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfFacet_Ancestors(), this.getRoboconfFacet(), this.getRoboconfFacet_Children(), "ancestors", null, 0, -1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboconfFacet_Dependencies(), this.getRoboconfFacet(), null, "dependencies", null, 0, -1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfImportedVariableEClass, RoboconfImportedVariable.class, "RoboconfImportedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfImportedVariable_Optional(), theXMLTypePackage.getBoolean(), "optional", "false", 0, 1, RoboconfImportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfImportedVariable_External(), theXMLTypePackage.getBoolean(), "external", "false", 0, 1, RoboconfImportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfImportedVariable_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, RoboconfImportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (roboconfGraphsEClass, 
		   source, 
		   new String[] {
			 "name", "graphs",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getRoboconfGraphs_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getRoboconfGraphs_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getRoboconfGraphs_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getRoboconfGraphs_Facets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "facets",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRoboconfGraphs_Components(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "components",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (roboconfChildrenLinkEClass, 
		   source, 
		   new String[] {
			 "name", "RoboconfChildrenLink",
			 "kind", "empty"
		   });	
		addAnnotation
		  (roboconfComponentEClass, 
		   source, 
		   new String[] {
			 "name", "RoboconfComponent",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (roboconfExportedVariableEClass, 
		   source, 
		   new String[] {
			 "name", "RoboconfExportedVariable",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getRoboconfExportedVariable_DefaultValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default-value"
		   });	
		addAnnotation
		  (getRoboconfExportedVariable_ExternalAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "external-alias"
		   });	
		addAnnotation
		  (getRoboconfExportedVariable_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (roboconfFacetEClass, 
		   source, 
		   new String[] {
			 "name", "RoboconfFacet",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRoboconfFacet_Exports(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "exports",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRoboconfFacet_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (roboconfImportedVariableEClass, 
		   source, 
		   new String[] {
			 "name", "RoboconfImportedVariable",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getRoboconfImportedVariable_Optional(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default-value"
		   });	
		addAnnotation
		  (getRoboconfImportedVariable_External(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "external-alias"
		   });	
		addAnnotation
		  (getRoboconfImportedVariable_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });
	}

} //RoboconfEmfPackageImpl
