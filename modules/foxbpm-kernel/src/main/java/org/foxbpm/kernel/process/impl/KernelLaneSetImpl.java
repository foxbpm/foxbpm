/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author kenshin
 */
package org.foxbpm.kernel.process.impl;

import java.util.ArrayList;
import java.util.List;

import org.foxbpm.kernel.process.KernelLane;
import org.foxbpm.kernel.process.KernelLaneSet;

public class KernelLaneSetImpl extends KernelBaseElementImpl implements KernelLaneSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<KernelLane> lanes = new ArrayList<KernelLane>();

	public KernelLaneSetImpl(String id, KernelProcessDefinitionImpl processDefinition) {
		super(id, processDefinition);
	}

	public List<KernelLane> getLanes() {
		return lanes;
	}

	public KernelLane getLaneForId(String id) {
		if (lanes != null && lanes.size() > 0) {
			for (KernelLane lane : lanes) {
				if (id.equals(lane.getId())) {
					return lane;
				} else {
					KernelLaneSet childLaneSet = lane.getChildLaneSet();
					if (childLaneSet != null && childLaneSet.getLanes().size() > 0) {
						KernelLane kernelLane = childLaneSet.getLaneForId(id);
						if (kernelLane != null) {
							return kernelLane;
						}
					}
				}
			}
		}
		return null;
	}

}
