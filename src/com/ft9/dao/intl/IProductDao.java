package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.ProductBean;

/**
 * class name:IProductDao <BR>
 * class description: The interface of product dao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public interface IProductDao {
	/**
	 * Method name: getProductsByMap <BR>
	 * Description: Get the product by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<ProductBean><BR>
	 */
	public List<ProductBean>getProductsByMap(Map<String,String>map);
	/**
	 * Method name: insertProductByBean <BR>
	 * Description: Insert the product by product bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return  boolean<BR>
	 */
	public boolean insertProductByBean(ProductBean productBean);
	
	/**
	 * Method name: deleteProductByMap <BR>
	 * Description: Delete the product by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteProductByMap(Map<String,String>map);
	
	/**
	 * Method name: updateProduct <BR>
	 * Description: Update the product by bean and search map <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateProduct(ProductBean productBean,Map<String,String>map);
}
