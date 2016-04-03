/**
 * 
 */
package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;

/**
 * class name:IDiscountDao <BR>
 * class description: The Interface of discount dao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public interface IDiscountDao {
	/**
	 * Method name: getDiscountsByMap <BR>
	 * Description: Get the discount by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<DiscountBean><BR>
	 */
	public List<DiscountBean>getDiscountsByMap(Map<String,String>map);
	
	/**
	 * Method name: insertDiscountByBean <BR>
	 * Description: Insert the discount by search bean <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @return  boolean<BR>
	 */
	public boolean insertDiscountByBean(DiscountBean discountBean);
	
	/**
	 * Method name: deleteDiscountByMap <BR>
	 * Description: Delete the discount by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteDiscountByMap(Map<String,String>map);
	
	/**
	 * Method name: updateDiscount <BR>
	 * Description: Update the discount by search map and new bean <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateDiscount(DiscountBean discountBean,Map<String,String>map);
}
