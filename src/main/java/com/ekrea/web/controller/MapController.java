package com.ekrea.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekrea.model.dto.RegionDo;
import com.ekrea.model.dto.Staticsdata;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月17日 下午2:44:14 
* @version 1.0 
* @description 
*/
@RestController
@RequestMapping("/get")
public class MapController {
	@RequestMapping("/map")
	public Map<String, List<String>> getMap() {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		map.put("1", list);
		return map;
	}
	@RequestMapping("/maps")
	public Map<String,List<Map<String,String>>> getMaps() {
		Map<String,List<Map<String,String>>> map = new HashMap<String,List<Map<String,String>>>();
		Map<String,String> maps = new HashMap<>();
		maps.put("1", "a");
		maps.put("2", "b");
		maps.put("3", "c");
		List<Map<String, String>> list= new ArrayList<>();
		list.add(maps);
		map.put("a", list);
		return map;
	}
	@RequestMapping("/mapsss")
	public List<Map<String, Object>> selectRegionInfo() {
		List<RegionDo> list = Staticsdata.getRegion();
		System.out.println(list);
		List<Map<String,Object>>  listMap= new ArrayList<Map<String,Object>>();
		for(RegionDo re1 : list){
			List<RegionDo> list11  = Staticsdata.getRegion();
			Map<String,Object> retMap1 = new HashMap<String,Object>();
			List<Map<String,Object>>  retLst1= new ArrayList<Map<String,Object>>();
			for(RegionDo re2 : list11){
				Map<String,Object> retMap2 = new HashMap<String,Object>();
				retMap2.put("label", re2.getLabel());
				retMap2.put("value", re2.getValue());
				retLst1.add(retMap2);
			}
			retMap1.put("label", re1.getLabel());
			retMap1.put("value", re1.getValue());
			retMap1.put("children", retLst1);
			listMap.add(retMap1);
		}
		return listMap;
	}
}
