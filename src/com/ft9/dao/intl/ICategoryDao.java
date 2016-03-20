/**
 * 
 */
package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;

/**
 * @author hippo
 *
 */
public interface ICategoryDao {
	public List<CategoryBean>getCategorysByMap(Map<String,String>map);
	public boolean insertCategoryByBean(CategoryBean categoryBean);
	public int deleteCategoryByMap(Map<String,String>map);
	public int updateCategory(CategoryBean categoryBean,Map<String,String>map);
}
