package com.ft9.bean;

import java.io.Serializable;

public class VendorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3424739536594758899L;
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
