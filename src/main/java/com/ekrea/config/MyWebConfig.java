package com.ekrea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月12日 下午2:23:44 
* @version 1.0 
* @description 
*/
@ConfigurationProperties(prefix="web")
@Component
public class MyWebConfig {
	private String name ;
	private String version;
	private String author;
	private String title;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
