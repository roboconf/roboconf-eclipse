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
package net.roboconf.eclipse.emf.models.roboconf.util;

import net.roboconf.eclipse.emf.models.roboconf.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see net.roboconf.eclipse.emf.models.roboconf.RoboconfEmfPackage
 * @generated
 */
public class RoboconfEmfSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RoboconfEmfPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboconfEmfSwitch() {
		if (modelPackage == null) {
			modelPackage = RoboconfEmfPackage.eINSTANCE;
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
			case RoboconfEmfPackage.ROBOCONF_GRAPHS: {
				RoboconfGraphs roboconfGraphs = (RoboconfGraphs)theEObject;
				T result = caseRoboconfGraphs(roboconfGraphs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfEmfPackage.ROBOCONF_CHILDREN_LINK: {
				RoboconfChildrenLink roboconfChildrenLink = (RoboconfChildrenLink)theEObject;
				T result = caseRoboconfChildrenLink(roboconfChildrenLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfEmfPackage.ROBOCONF_COMPONENT: {
				RoboconfComponent roboconfComponent = (RoboconfComponent)theEObject;
				T result = caseRoboconfComponent(roboconfComponent);
				if (result == null) result = caseRoboconfFacet(roboconfComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfEmfPackage.ROBOCONF_EXPORTED_VARIABLE: {
				RoboconfExportedVariable roboconfExportedVariable = (RoboconfExportedVariable)theEObject;
				T result = caseRoboconfExportedVariable(roboconfExportedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfEmfPackage.ROBOCONF_FACET: {
				RoboconfFacet roboconfFacet = (RoboconfFacet)theEObject;
				T result = caseRoboconfFacet(roboconfFacet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoboconfEmfPackage.ROBOCONF_IMPORTED_VARIABLE: {
				RoboconfImportedVariable roboconfImportedVariable = (RoboconfImportedVariable)theEObject;
				T result = caseRoboconfImportedVariable(roboconfImportedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboconf Graphs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboconf Graphs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboconfGraphs(RoboconfGraphs object) {
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

} //RoboconfEmfSwitch
