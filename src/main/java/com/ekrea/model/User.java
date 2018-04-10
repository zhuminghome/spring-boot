package com.ekrea.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月9日 下午4:20:29 
* @version 1.0 
* @description 
*/
public class User {
	private String name ;
	@JsonIgnore
	private String password;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm::ss a",locale="zh",timezone="GMT+8")
	private Date birthday;
	@JsonInclude(value=Include.NON_NULL)
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
