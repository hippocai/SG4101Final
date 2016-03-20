package com.ft9.bean;

import java.io.Serializable;

public class CategoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7500230232869496885L;
	
	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
