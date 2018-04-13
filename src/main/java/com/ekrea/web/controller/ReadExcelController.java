package com.ekrea.web.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekrea.model.dto.WebDto;
import com.ekrea.utils.ExcelUtil;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月13日 上午9:47:50 
* @version 1.0 
* @description 
*/
@RestController
@RequestMapping("excel")
public class ReadExcelController {
	
	@RequestMapping("export")
	 public void testRead() throws Exception {
	        //Excel文件
	        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));
	        //Excel工作表
	        HSSFSheet sheet = wb.getSheetAt(0);

	        //表头那一行
	        HSSFRow titleRow = sheet.getRow(0);

	        //表头那个单元格
	        HSSFCell titleCell = titleRow.getCell(0);

	        String title = titleCell.getStringCellValue();

	        System.out.println("标题是："+title);
	    }
	
	 @RequestMapping("exports")
	 public List<WebDto> testReadList() throws Exception {
	        List<WebDto> list = new ArrayList<WebDto>();

	        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));

	        HSSFSheet sheet = book.getSheetAt(0);

	        for(int i=2; i<sheet.getLastRowNum()+1; i++) {
	            HSSFRow row = sheet.getRow(i);
	            String name = row.getCell(0).getStringCellValue(); //名称
	            String url = row.getCell(1).getStringCellValue(); //url
	            String username = row.getCell(2).getStringCellValue();
	            String password = row.getCell(3).getStringCellValue();
	            Integer readCount = (int) row.getCell(4).getNumericCellValue();
	            WebDto dto =  new WebDto(name,url,username,password,readCount);
	            list.add(dto);
	        }
	        System.out.println(list);
	        System.out.println("共有 " + list.size() + " 条数据：");
	        for(WebDto wd : list) {
	            System.out.println(wd);
	        }
	        return list;
	    }
	 @RequestMapping("read")
	 public void read() throws Exception {
		 List<WebDto> list = new ArrayList<WebDto>();
	        list.add(new WebDto("知识林", "http://www.zslin.com", "admin", "111111", 555));
	        list.add(new WebDto("权限系统", "http://basic.zslin.com", "admin", "111111", 111));
	        list.add(new WebDto("校园网", "http://school.zslin.com", "admin", "222222", 333));

	        Map<String, String> map = new HashMap<String, String>();
	        map.put("title", "网站信息表");
	        map.put("total", list.size()+" 条");
	        map.put("date", getDate());

	        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "web-info.xls", new FileOutputStream("E:/temp/out.xls"),
	                list, WebDto.class, true);
	    }
	 private String getDate() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	        return sdf.format(new Date());
	    }
}
