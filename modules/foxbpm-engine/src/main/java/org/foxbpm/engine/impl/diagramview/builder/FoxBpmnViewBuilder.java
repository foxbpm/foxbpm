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
 * @author MAENLIANG
 */
package org.foxbpm.engine.impl.diagramview.builder;

import java.util.List;

import org.foxbpm.engine.impl.diagramview.svg.Point;
import org.foxbpm.engine.impl.diagramview.svg.vo.TextVO;

/**
 * 流程图形信息构造接口
 * 
 * @author MAENLIANG
 * @date 2014-06-10
 */
public interface FoxBpmnViewBuilder {
	public static final String SEQUENCE_STROKEWIDTH_DEFAULT = "2";
	public static final String COLOR_FLAG = "#";
	public static final String STROKE_DEFAULT = "black";
	public static final String STROKEWIDTH_DEFAULT = "1";
	public static final int LINEARGRADIENT_INDEX = 0;
	public static final String COMMA = ",";
	public static final String BACK_GROUND_PREFIX = "url(#";
	public static final String BACK_GROUND_SUFFIX = ") #";
	
	public static final String BRACKET_SUFFIX = ")";
	public static final String TRANSLANT_PREFIX = "translate(";
	public static final String ARIAL = "arial";
	
	

	/**
	 * 设置节点信息
	 */
	public void setWayPoints(List<Point> pointList);

	/**
	 * 
	 * setWidth(设置元素宽度)
	 * 
	 * @param width
	 * @since 1.0.0
	 */
	public void setWidth(float width);

	/**
	 * 
	 * setHeight(设置元素高度)
	 * 
	 * @param height
	 * @since 1.0.0
	 */
	public void setHeight(float height);

	/**
	 * 
	 * setXAndY(设置元素坐标)
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public void setXAndY(float x, float y);

	public void setStroke(String stroke);

	public void setStrokeWidth(float strokeWidth);

	public void setFill(String fill);

	public void setID(String id);

	public void setName(String name);

	public void setStyle(String style);

	/**
	 * 设置文本信息
	 */
	public void setText(String text);

	public void setTextFont(String font);

	public void setTextStrokeWidth(float textStrokeWidth);

	public void setTextX(float textX);

	public void setTextY(float textY);

	public void setTextFontSize(String textFontSize);

	public void setTextStroke(String textStroke);

	public void setTextFill(String textFill);

	/**
	 * 设置子类型的信息
	 */
	public void setTypeStroke(String stroke);

	public void setTypeStrokeWidth(float strokeWidth);

	public void setTypeFill(String fill);

	public void setTypeStyle(String style);

	/**
	 * 泳道负责重写该方法 setTextLocationByHerizonFlag
	 */
	public void setTextLocationByHerizonFlag(boolean herizonFlag);
	
	public TextVO getTextVo();
}
