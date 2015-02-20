
/*
 Copyright (C) 2005 Jorge Gomez Sanz

 This file is part of INGENIAS Agent Framework, an agent infrastructure linked
 to the INGENIAS Development Kit, and availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net. 

 INGENIAS Agent Framework is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 INGENIAS Agent Framework is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with INGENIAS Agent Framework; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 */

package ingenias.jade.components;

import java.util.*;
import ingenias.jade.exception.*;
import ingenias.jade.comm.*;
import ingenias.jade.mental.*;
import ingenias.editor.entities.*;

/**
 * 
 * <p>
 * The Task Analyse_current_status_and_enable_battery_if_full has the following
 * inputs, sets of possible outputs, and available applications:
 * </p>
 * Inputs:
 * <ul>
 * <li>CheckAgain</li>
 * 
 * 
 * 
 * </ul>
 * Expected output:
 * <ul>
 * 
 * </ul>
 * Available apps:
 * <ul>
 * <li>SMClientApp</li>
 * 
 * </ul>
 */
public class Analyse_current_status_and_enable_battery_if_fullTask extends Task {

	public Analyse_current_status_and_enable_battery_if_fullTask(String id) {
		super(id, "Analyse_current_status_and_enable_battery_if_full");

	}

	public void execute() throws TaskException {
		YellowPages yp = null; // only available for initiators of interactions

		CheckAgain eiCheckAgain = (CheckAgain) this
				.getFirstInputOfType("CheckAgain");

		SMClientApp eaSMClient = (SMClientApp) this.getApplication("SMClient");

		Vector<TaskOutput> outputs = this.getOutputs();

		// sets the first possible alternative to be the default one
		if (!this.getOutputs().isEmpty())
			this.setFinalOutput(outputs.firstElement());

		// --------------------------------------------------------
		// End of automatically generated code
		// --------------------------------------------------------
		// Expected output summary:

		// Available apps:
		// SMClientApp</li>

		// #start_node: <--- DO NOT REMOVE THIS
		// REPLACE THIS COMMENT WITH YOUR CODE
		System.out.println(getAgentID() + " executing -> " + getID() + ":"
				+ getType());
		// #end_node: <--- DO NOT REMOVE THIS

	}

}
