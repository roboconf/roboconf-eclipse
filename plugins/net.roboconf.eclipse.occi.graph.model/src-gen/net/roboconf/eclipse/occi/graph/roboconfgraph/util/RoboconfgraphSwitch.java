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
package net.roboconf.eclipse.occi.graph.roboconfgraph.util;

import net.roboconf.eclipse.occi.graph.roboconfgraph.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Resource;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see net.roboconf.eclipse.occi.graph.roboconfgraph.RoboconfgraphPackage
 * @generated
 */
public class RoboconfgraphSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RoboconfgraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfgraphSwitch() {
		if (modelPackage == null) {
			modelPackage = RoboconfgraphPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RoboconfgraphPackage.ROBOCONF_COMPONENT: {
				RoboconfComponent roboconfComponent = (RoboconfComponent)theEObject;
				T result = caseRoboconfComponent(roboconfComponent);
				if (result == null) result = caseRoboconfFacet(roboconfComponent);
				if (result == null) result = caseResource(roboconfComponent);
				if (result == null) result = caseEntity(roboconfComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_FACET: {
				RoboconfFacet roboconfFacet = (RoboconfFacet)theEObject;
				T result = caseRoboconfFacet(roboconfFacet);
				if (result == null) result = caseResource(roboconfFacet);
				if (result == null) result = caseEntity(roboconfFacet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_APPLICATION_TEMPLATE: {
				RoboconfApplicationTemplate roboconfApplicationTemplate = (RoboconfApplicationTemplate)theEObject;
				T result = caseRoboconfApplicationTemplate(roboconfApplicationTemplate);
				if (result == null) result = caseResource(roboconfApplicationTemplate);
				if (result == null) result = caseEntity(roboconfApplicationTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_EXPORTED_VARIABLE: {
				RoboconfExportedVariable roboconfExportedVariable = (RoboconfExportedVariable)theEObject;
				T result = caseRoboconfExportedVariable(roboconfExportedVariable);
				if (result == null) result = caseResource(roboconfExportedVariable);
				if (result == null) result = caseEntity(roboconfExportedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_IMPORTED_VARIABLE: {
				RoboconfImportedVariable roboconfImportedVariable = (RoboconfImportedVariable)theEObject;
				T result = caseRoboconfImportedVariable(roboconfImportedVariable);
				if (result == null) result = caseResource(roboconfImportedVariable);
				if (result == null) result = caseEntity(roboconfImportedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_OWNER_LINK: {
				RoboconfOwnerLink roboconfOwnerLink = (RoboconfOwnerLink)theEObject;
				T result = caseRoboconfOwnerLink(roboconfOwnerLink);
				if (result == null) result = caseLink(roboconfOwnerLink);
				if (result == null) result = caseEntity(roboconfOwnerLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_INHERITANCE_LINK: {
				RoboconfInheritanceLink roboconfInheritanceLink = (RoboconfInheritanceLink)theEObject;
				T result = caseRoboconfInheritanceLink(roboconfInheritanceLink);
				if (result == null) result = caseLink(roboconfInheritanceLink);
				if (result == null) result = caseEntity(roboconfInheritanceLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_CHILDREN_LINK: {
				RoboconfChildrenLink roboconfChildrenLink = (RoboconfChildrenLink)theEObject;
				T result = caseRoboconfChildrenLink(roboconfChildrenLink);
				if (result == null) result = caseLink(roboconfChildrenLink);
				if (result == null) result = caseEntity(roboconfChildrenLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfgraphPackage.ROBOCONF_RUNTIME_LINK: {
				RoboconfRuntimeLink roboconfRuntimeLink = (RoboconfRuntimeLink)theEObject;
				T result = caseRoboconfRuntimeLink(roboconfRuntimeLink);
				if (result == null) result = caseLink(roboconfRuntimeLink);
				if (result == null) result = caseEntity(roboconfRuntimeLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfComponent(RoboconfComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Facet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Facet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfFacet(RoboconfFacet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Application Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Application Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfApplicationTemplate(RoboconfApplicationTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Exported Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Exported Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfExportedVariable(RoboconfExportedVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Imported Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Imported Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfImportedVariable(RoboconfImportedVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Owner Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Owner Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfOwnerLink(RoboconfOwnerLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Inheritance Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Inheritance Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfInheritanceLink(RoboconfInheritanceLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Children Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Children Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfChildrenLink(RoboconfChildrenLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Runtime Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Runtime Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfRuntimeLink(RoboconfRuntimeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RoboconfgraphSwitch
