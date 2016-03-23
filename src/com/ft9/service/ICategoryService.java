/**
 * 
 */
package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;

/**
 * @author hippo
 *
 */
public interface ICategoryService {
	public List<CategoryBean>getCategoryByMap(Map<String,String>map);
	public List<CategoryBean>getAllCategorys();
	public boolean deleteCategoryByMap(Map<String,String>map);
	public boolean addCategoryByBean(CategoryBean categoryBean);
	public boolean checkIfCategoryCodeExisted(String categoryCode);
}
