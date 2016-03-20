/**
 * 
 */
package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;

/**
 * @author hippo
 *
 */
public interface IDiscountDao {
	public List<DiscountBean>getDiscountsByMap(Map<String,String>map);
	
	public boolean insertDiscountByBean(DiscountBean discountBean);
	
	public int deleteDiscountByMap(Map<String,String>map);
	
	public int updateDiscount(DiscountBean discountBean,Map<String,String>map);
}
