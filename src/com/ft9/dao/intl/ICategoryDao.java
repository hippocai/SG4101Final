/**
 * 
 */
package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;


/**
 * class name:ICategoryDao <BR>
 * class description: The Interface of category dao <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê4ÔÂ2ÈÕ
 * @author caiyicheng
 */
public interface ICategoryDao {
	/**
	 * Method name: getCategorysByMap <BR>
	 * Description: Get Category By Search Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<CategoryBean><BR>
	 */
	public List<CategoryBean>getCategorysByMap(Map<String,String>map);
	/**
	 * Method name: insertCategoryByBean <BR>
	 * Description: Insert Category By The Bean <BR>
	 * Remark: <BR>
	 * @param categoryBean
	 * @return  boolean<BR>
	 */
	public boolean insertCategoryByBean(CategoryBean categoryBean);
	/**
	 * Method name: deleteCategoryByMap <BR>
	 * Description: Delete Category By The Search Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteCategoryByMap(Map<String,String>map);
	/**
	 * Method name: updateCategory <BR>
	 * Description: Update Category By New Bean and search map <BR>
	 * Remark: <BR>
	 * @param categoryBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateCategory(CategoryBean categoryBean,Map<String,String>map);
}
