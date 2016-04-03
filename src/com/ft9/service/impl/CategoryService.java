package com.ft9.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.CategoryDao;
import com.ft9.dao.intl.ICategoryDao;
import com.ft9.service.ICategoryService;

/**
 * class name:CategoryService <BR>
 * class description: Implements Of The Functions in ICategoryService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class CategoryService implements ICategoryService {

	
	private static CategoryService categoryService=null;
	
	
	/**
	 * Method name: getInstance <BR>
	 * Description: Get An Instance Of CategoryService <BR>
	 * Remark: <BR>
	 * @return categoryService
	 * @throws DaoNotExistException  CategoryService<BR>
	 */
	public static CategoryService getInstance() throws DaoNotExistException{
		if(categoryService==null){
			categoryService=new CategoryService();
		}
		return categoryService;
	}
	private ICategoryDao categoryDao=null;
	private CategoryService() throws DaoNotExistException{
		categoryDao=(CategoryDao)DAOer.getDao("Category");
	}
	/**
	 * @Override
	 * @see com.ft9.service.ICategoryService#getCategoryByMap(java.util.Map) <BR>
	 * Method name: getCategoryByMap <BR>
	 * Description: Get Category By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<CategoryBean> getCategoryByMap(Map<String, String> map) {
		if(map!=null){
			return categoryDao.getCategorysByMap(map);
		}
		return null;
	}

	/**
	 * @Override
	 * @see com.ft9.service.ICategoryService#getAllCategorys() <BR>
	 * Method name: getAllCategorys <BR>
	 * Description: Get All Categories <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<CategoryBean> getAllCategorys() {
		return this.getCategoryByMap(new HashMap<String,String>());
	}

	/**
	 * @Override
	 * @see com.ft9.service.ICategoryService#deleteCategoryByMap(java.util.Map) <BR>
	 * Method name: deleteCategoryByMap <BR>
	 * Description: Delete Category By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteCategoryByMap(Map<String, String> map) {
		if(map==null){
			return false;
		}
		return categoryDao.deleteCategoryByMap(map)>0;	
	}

	/**
	 * @Override
	 * @see com.ft9.service.ICategoryService#addCategoryByBean(com.ft9.bean.CategoryBean) <BR>
	 * Method name: addCategoryByBean <BR>
	 * Description: Add Category By Bean <BR>
	 * Remark: <BR>
	 * @param categoryBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean addCategoryByBean(CategoryBean categoryBean) {
		if(categoryBean==null){
			return false;
		}
		return categoryDao.insertCategoryByBean(categoryBean);
	}
	/**
	 * @Override
	 * @see com.ft9.service.ICategoryService#checkIfCategoryCodeExisted(java.lang.String) <BR>
	 * Method name: checkIfCategoryCodeExisted <BR>
	 * Description: Check If Category Code Existed <BR>
	 * Remark: <BR>
	 * @param categoryCode
	 * @return boolean <BR>
	*/
	@Override
	public boolean checkIfCategoryCodeExisted(String categoryCode) {
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", categoryCode);
		return this.getCategoryByMap(map).size()==0;
	}

}
