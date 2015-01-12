/**
 * Copyright 2014-2015 Linagora, Université Joseph Fourier, Floralis
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

package net.roboconf.eclipse.plugin.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * @author Vincent Zurczak - Linagora
 */
public class ColorManager {

	private final Map<RGB,Color> fColorTable = new HashMap<RGB,Color>( 10 );


	/**
	 * Disposes the graphical resources.
	 */
	public void dispose() {

		for( Color color : this.fColorTable.values()) {
			if( ! color.isDisposed())
				color.dispose();
		}

		this.fColorTable.clear();
	}


	/**
	 * @param rgb
	 * @return
	 */
	public Color getColor( RGB rgb ) {

		Color color = this.fColorTable.get( rgb );
		if( color == null ) {
			color = new Color( Display.getCurrent(), rgb );
			this.fColorTable.put( rgb, color );
		}

		return color;
	}
}
