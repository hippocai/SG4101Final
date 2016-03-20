package com.ft9.bean;

import java.io.Serializable;

public class DiscountBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7675868516263937407L;
	
	private String code;
	private String description;
	private String startDate;
	//Discount Period in days
	private String discountPeriod;
	//percentage discount without the percentage symbol 
	private String discountPercentage;
	//Applicable to Member (M) or ALL(A)
	private String memberApplicable;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDiscountPeriod() {
		return discountPeriod;
	}
	public void setDiscountPeriod(String discountPeriod) {
		this.discountPeriod = discountPeriod;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getMemberApplicable() {
		return memberApplicable;
	}
	public void setMemberApplicable(String memberApplicable) {
		this.memberApplicable = memberApplicable;
	}
	

}
