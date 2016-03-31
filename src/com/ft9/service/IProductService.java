package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.ProductBean;

/**
 * class name:IProductService <BR>
 * class description: The Interfaces of ProductService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public interface IProductService {
	/**
	 * Method name: getProductByMap <BR>
	 * Description: Get Product By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<ProductBean><BR>
	 */
	public List<ProductBean>getProductByMap(Map<String,String>map);
	/**
	 * Method name: getAllProducts <BR>
	 * Description: Get All Products <BR>
	 * Remark: <BR>
	 * @return  List<ProductBean><BR>
	 */
	public List<ProductBean>getAllProducts();
	/**
	 * Method name: searchProductByKey <BR>
	 * Description: Search Product By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valueLike
	 * @return  List<ProductBean><BR>
	 */
	public List<ProductBean>searchProductByKey(String key,String valueLike);
	/**
	 * Method name: getProductByKey <BR>
	 * Description: Get Product By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param value
	 * @return  List<ProductBean><BR>
	 */
	public List<ProductBean>getProductByKey(String key,String value);
	/**
	 * Method name: getProductsBelowThreshold <BR>
	 * Description: Get Products Below Threshold <BR>
	 * Remark: <BR>
	 * @return  List<ProductBean><BR>
	 */
	public List<ProductBean>getProductsBelowThreshold();
	/**
	 * Method name: getMaxProductNumerOfCategory <BR>
	 * Description: Get Maximum Product Numeber Of Category <BR>
	 * Remark: <BR>
	 * @param categoryName
	 * @return  int<BR>
	 */
	public int getMaxProductNumerOfCategory(String categoryName);
	/**
	 * Method name: deleteProductByMap <BR>
	 * Description: Delete Product By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  boolean<BR>
	 */
	public boolean deleteProductByMap(Map<String,String>map);
	/**
	 * Method name: addProductByByBean <BR>
	 * Description: Add Product By Bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return  boolean<BR>
	 */
	public boolean addProductByBean(ProductBean productBean);
	/**
	 * Method name: updateProductByBean <BR>
	 * Description: Update Product By Bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return  boolean<BR>
	 */
	public boolean updateProductByBean(ProductBean productBean);
	/**
	 * Method name: getAllCategory <BR>
	 * Description: Get All Category <BR>
	 * Remark: <BR>
	 * @return  String[]<BR>
	 */
	public String[]getAllCategory();
}
