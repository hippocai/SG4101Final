
package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;

/**
 * @author hippo
 *
 */
/**
 * class name:ICategoryService <BR>
 * class description: The Interfaces of CategoryService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public interface ICategoryService {
	
	/**
	 * Method name: getCategoryByMap <BR>
	 * Description: Get Category By HashMap <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<CategoryBean><BR>
	 */
	public List<CategoryBean>getCategoryByMap(Map<String,String>map);
	/**
	 * Method name: getAllCategorys <BR>
	 * Description: Get All Categorys <BR>
	 * Remark: <BR>
	 * @return  List<CategoryBean><BR>
	 */
	public List<CategoryBean>getAllCategorys();
	/**
	 * Method name: deleteCategoryByMap <BR>
	 * Description: Delete Category By HashMap <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  boolean<BR>
	 */
	public boolean deleteCategoryByMap(Map<String,String>map);
	/**
	 * Method name: addCategoryByBean <BR>
	 * Description: Add Category By Bean <BR>
	 * Remark: <BR>
	 * @param categoryBean
	 * @return  boolean<BR>
	 */
	public boolean addCategoryByBean(CategoryBean categoryBean);
	/**
	 * Method name: checkIfCategoryCodeExisted <BR>
	 * Description: Check If Category Code Exist <BR>
	 * Remark: <BR>
	 * @param categoryCode
	 * @return  boolean<BR>
	 */
	public boolean checkIfCategoryCodeExisted(String categoryCode);
}
