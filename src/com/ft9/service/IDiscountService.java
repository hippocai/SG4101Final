package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;

/**
 * class name:IDiscountService <BR>
 * class description: The Interfaces of DiscountService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public interface IDiscountService {
	/**
	 * Method name: getDiscountByMap <BR>
	 * Description: Get Discount By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<DiscountBean><BR>
	 */
	public List<DiscountBean>getDiscountByMap(Map<String,String>map);
	/**
	 * Method name: getAllDiscountInfo <BR>
	 * Description: Get All Discount Information <BR>
	 * Remark: <BR>
	 * @return  List<DiscountBean><BR>
	 */
	public List<DiscountBean>getAllDiscountInfo();
	/**
	 * Method name: searchDiscountByKey <BR>
	 * Description: Search Discount By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valueLike
	 * @return  List<DiscountBean><BR>
	 */
	public List<DiscountBean>searchDiscountByKey(String key,String valueLike);
	/**
	 * Method name: deleteDiscountByMap <BR>
	 * Description: Delete Discount By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteDiscountByMap(Map<String,String>map);
	/**
	 * Method name: deleteDiscountByCode <BR>
	 * Description: Delete Discount By Code <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean deleteDiscountByCode(String code);
	/**
	 * Method name: isCodeExist <BR>
	 * Description: Check If Discount Code exist <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean isCodeExist(String code);
	/**
	 * Method name: addNewDiscount <BR>
	 * Description: Add New Discount <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @return  boolean<BR>
	 */
	public boolean addNewDiscount(DiscountBean discountBean);
	/**
	 * Method name: updateDiscount <BR>
	 * Description: Update Discount <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @return  boolean<BR>
	 */
	public boolean updateDiscount(DiscountBean discountBean);
	
}
