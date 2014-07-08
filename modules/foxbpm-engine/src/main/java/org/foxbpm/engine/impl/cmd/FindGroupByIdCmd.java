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
 * @author ych
 */
package org.foxbpm.engine.impl.cmd;

import java.util.List;

import org.foxbpm.engine.exception.FoxBPMIllegalArgumentException;
import org.foxbpm.engine.identity.Group;
import org.foxbpm.engine.identity.GroupDefinition;
import org.foxbpm.engine.impl.interceptor.Command;
import org.foxbpm.engine.impl.interceptor.CommandContext;

/**
 * 获取组编号下的所有子组（包含自身）
 * @author ych
 *
 */
public class FindGroupByIdCmd  implements Command<Group>{

	private String groupType;
	private String groupId;
	
	public FindGroupByIdCmd(String groupType,String groupId) {
		this.groupId = groupId;
		this.groupType = groupType;
	}
	
	@Override
	public Group execute(CommandContext commandContext) {
		if(groupId == null || groupType == null){
			throw new FoxBPMIllegalArgumentException("参数不能为空:groupId="+groupId+",groupType="+groupType);
		}
		List<GroupDefinition> groupDefinitions = commandContext.getProcessEngineConfigurationImpl().getGroupDefinitions();
		for(GroupDefinition groupDefinition : groupDefinitions){
			if(groupDefinition.getType().equals(groupType)){
				Group group = groupDefinition.selectGroupByGroupId(groupId);
				return group;
			}
		}
		throw new FoxBPMIllegalArgumentException("不支持的组类型：" + groupType);
	}
}
