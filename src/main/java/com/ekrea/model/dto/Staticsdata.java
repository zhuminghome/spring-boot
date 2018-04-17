package com.ekrea.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月17日 下午3:18:20 
* @version 1.0 
* @description 
*/
public class Staticsdata {
	public static List<RegionDo> getRegion(){
		List<RegionDo> regionDos = new ArrayList<>();
		RegionDo reg0 = new RegionDo();
		reg0.setLabel("1");
		reg0.setValue("朝阳1");
		RegionDo reg1 = new RegionDo();
		reg1.setLabel("2");
		reg1.setValue("朝阳2");
		regionDos.add(reg0);
		regionDos.add(reg1);
		return regionDos;
	}
}
