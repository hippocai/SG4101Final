package com.ft9.bean;

import java.io.Serializable;

public class MemberBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5690419253680860739L;
	private String name;
	private String id;
	private String loyaltyPoint;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoyaltyPoint() {
		return loyaltyPoint;
	}
	public void setLoyaltyPoint(String loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}

}
