/**
 * 
 */
package com.ft9.bean;

import java.io.Serializable;

/**
 * @author hippo
 *
 */
public class TransactionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6877812829327604702L;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(String quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String id;
	private String productId;
	private String memberId;
	private String quantityPurchased;
	private String date;

}
