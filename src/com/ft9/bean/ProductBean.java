/**
 * 
 */
package com.ft9.bean;

import java.io.Serializable;

/**
 * @author hippo
 *
 */
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4301286942997624834L;
	private String id;
	private String name;
	private String description;
	private String quantityAvailable;
	private String price;
	private String barCode;
	private String reorderQuantity;
	private String orderQuantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(String quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(String reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public String getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

}
