/**
 * Copyright 2014-2016 Linagora, Université Joseph Fourier, Floralis
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
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.roboconf.eclipse.plugin.editors.graphs;

import net.roboconf.eclipse.plugin.editors.commons.ColorManager;
import net.roboconf.eclipse.plugin.editors.commons.RoboconfDocumentProvider;

import org.eclipse.ui.editors.text.TextEditor;

/**
 * @author Vincent Zurczak - Linagora
 */
public class RoboconfGraphEditor extends TextEditor {

	private final ColorManager colorManager;

	/**
	 * Constructor.
	 */
	public RoboconfGraphEditor() {
		super();
		this.colorManager = new ColorManager();
		setSourceViewerConfiguration( new RoboconfGraphConfiguration(this.colorManager));
		setDocumentProvider( new RoboconfDocumentProvider());
	}

	@Override
	public void dispose() {
		this.colorManager.dispose();
		super.dispose();
	}
}
