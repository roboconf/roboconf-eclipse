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

import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfChildrenLink;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfComponent;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfExportedVariable;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfFacet;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfImportedVariable;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfInheritanceLink;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfOwnerLink;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfRuntimeLink;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphFactory;
import net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.occiware.clouddesigner.occi.OCCIPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoboconfgraphPackageImpl extends EPackageImpl implements RoboconfgraphPackage {
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
	private EClass roboconfFacetEClass = null;

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
	private EClass roboconfImportedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfOwnerLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboconfInheritanceLinkEClass = null;

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
	private EClass roboconfRuntimeLinkEClass = null;

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
	 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RoboconfgraphPackageImpl() {
		super(eNS_URI, RoboconfgraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RoboconfgraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RoboconfgraphPackage init() {
		if (isInited) return (RoboconfgraphPackage)EPackage.Registry.INSTANCE.getEPackage(RoboconfgraphPackage.eNS_URI);

		// Obtain or create and register package
		RoboconfgraphPackageImpl theRoboconfgraphPackage = (RoboconfgraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RoboconfgraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RoboconfgraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OCCIPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRoboconfgraphPackage.createPackageContents();

		// Initialize created meta-data
		theRoboconfgraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRoboconfgraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RoboconfgraphPackage.eNS_URI, theRoboconfgraphPackage);
		return theRoboconfgraphPackage;
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
	public EClass getRoboconfFacet() {
		return roboconfFacetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfFacet_Name() {
		return (EAttribute)roboconfFacetEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getRoboconfExportedVariable_Name() {
		return (EAttribute)roboconfExportedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfExportedVariable_Value() {
		return (EAttribute)roboconfExportedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfExportedVariable_PublicAlias() {
		return (EAttribute)roboconfExportedVariableEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getRoboconfImportedVariable_Name() {
		return (EAttribute)roboconfImportedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfImportedVariable_Optional() {
		return (EAttribute)roboconfImportedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboconfImportedVariable_External() {
		return (EAttribute)roboconfImportedVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfOwnerLink() {
		return roboconfOwnerLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboconfInheritanceLink() {
		return roboconfInheritanceLinkEClass;
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
	public EClass getRoboconfRuntimeLink() {
		return roboconfRuntimeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfgraphFactory getRoboconfgraphFactory() {
		return (RoboconfgraphFactory)getEFactoryInstance();
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
		roboconfComponentEClass = createEClass(ROBOCONF_COMPONENT);
		createEAttribute(roboconfComponentEClass, ROBOCONF_COMPONENT__INSTALLER_NAME);

		roboconfFacetEClass = createEClass(ROBOCONF_FACET);
		createEAttribute(roboconfFacetEClass, ROBOCONF_FACET__NAME);

		roboconfExportedVariableEClass = createEClass(ROBOCONF_EXPORTED_VARIABLE);
		createEAttribute(roboconfExportedVariableEClass, ROBOCONF_EXPORTED_VARIABLE__NAME);
		createEAttribute(roboconfExportedVariableEClass, ROBOCONF_EXPORTED_VARIABLE__VALUE);
		createEAttribute(roboconfExportedVariableEClass, ROBOCONF_EXPORTED_VARIABLE__PUBLIC_ALIAS);

		roboconfImportedVariableEClass = createEClass(ROBOCONF_IMPORTED_VARIABLE);
		createEAttribute(roboconfImportedVariableEClass, ROBOCONF_IMPORTED_VARIABLE__NAME);
		createEAttribute(roboconfImportedVariableEClass, ROBOCONF_IMPORTED_VARIABLE__OPTIONAL);
		createEAttribute(roboconfImportedVariableEClass, ROBOCONF_IMPORTED_VARIABLE__EXTERNAL);

		roboconfOwnerLinkEClass = createEClass(ROBOCONF_OWNER_LINK);

		roboconfInheritanceLinkEClass = createEClass(ROBOCONF_INHERITANCE_LINK);

		roboconfChildrenLinkEClass = createEClass(ROBOCONF_CHILDREN_LINK);

		roboconfRuntimeLinkEClass = createEClass(ROBOCONF_RUNTIME_LINK);
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
		OCCIPackage theOCCIPackage = (OCCIPackage)EPackage.Registry.INSTANCE.getEPackage(OCCIPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		roboconfComponentEClass.getESuperTypes().add(this.getRoboconfFacet());
		roboconfFacetEClass.getESuperTypes().add(theOCCIPackage.getResource());
		roboconfExportedVariableEClass.getESuperTypes().add(theOCCIPackage.getResource());
		roboconfImportedVariableEClass.getESuperTypes().add(theOCCIPackage.getResource());
		roboconfOwnerLinkEClass.getESuperTypes().add(theOCCIPackage.getLink());
		roboconfInheritanceLinkEClass.getESuperTypes().add(theOCCIPackage.getLink());
		roboconfChildrenLinkEClass.getESuperTypes().add(theOCCIPackage.getLink());
		roboconfRuntimeLinkEClass.getESuperTypes().add(theOCCIPackage.getLink());

		// Initialize classes and features; add operations and parameters
		initEClass(roboconfComponentEClass, RoboconfComponent.class, "RoboconfComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfComponent_InstallerName(), theOCCIPackage.getString(), "installerName", null, 0, 1, RoboconfComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfFacetEClass, RoboconfFacet.class, "RoboconfFacet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfFacet_Name(), theOCCIPackage.getString(), "name", null, 0, 1, RoboconfFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfExportedVariableEClass, RoboconfExportedVariable.class, "RoboconfExportedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfExportedVariable_Name(), theOCCIPackage.getString(), "name", null, 0, 1, RoboconfExportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfExportedVariable_Value(), theOCCIPackage.getString(), "value", null, 0, 1, RoboconfExportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfExportedVariable_PublicAlias(), theOCCIPackage.getString(), "publicAlias", null, 0, 1, RoboconfExportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfImportedVariableEClass, RoboconfImportedVariable.class, "RoboconfImportedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboconfImportedVariable_Name(), theOCCIPackage.getString(), "name", null, 0, 1, RoboconfImportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfImportedVariable_Optional(), theOCCIPackage.getBoolean(), "optional", null, 0, 1, RoboconfImportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboconfImportedVariable_External(), theOCCIPackage.getBoolean(), "external", null, 0, 1, RoboconfImportedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roboconfOwnerLinkEClass, RoboconfOwnerLink.class, "RoboconfOwnerLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roboconfInheritanceLinkEClass, RoboconfInheritanceLink.class, "RoboconfInheritanceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roboconfChildrenLinkEClass, RoboconfChildrenLink.class, "RoboconfChildrenLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roboconfRuntimeLinkEClass, RoboconfRuntimeLink.class, "RoboconfRuntimeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// OCCIE2Ecore
		createOCCIE2EcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>OCCIE2Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCCIE2EcoreAnnotations() {
		String source = "OCCIE2Ecore";	
		addAnnotation
		  (roboconfComponentEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (getRoboconfComponent_InstallerName(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (roboconfFacetEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (getRoboconfFacet_Name(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (roboconfExportedVariableEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (getRoboconfExportedVariable_Name(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (getRoboconfExportedVariable_Value(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (getRoboconfExportedVariable_PublicAlias(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (roboconfImportedVariableEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (getRoboconfImportedVariable_Name(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (getRoboconfImportedVariable_Optional(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (getRoboconfImportedVariable_External(), 
		   source, 
		   new String[] {
			 "description", null
		   });	
		addAnnotation
		  (roboconfOwnerLinkEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (roboconfInheritanceLinkEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (roboconfChildrenLinkEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });	
		addAnnotation
		  (roboconfRuntimeLinkEClass, 
		   source, 
		   new String[] {
			 "title", null
		   });
	}

} //RoboconfgraphPackageImpl
