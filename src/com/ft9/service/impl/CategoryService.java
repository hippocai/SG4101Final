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

public class CategoryService implements ICategoryService {

	
	private static CategoryService categoryService=null;
	
	
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
	@Override
	public List<CategoryBean> getCategoryByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map!=null){
			return categoryDao.getCategorysByMap(map);
		}
		return null;
	}

	@Override
	public List<CategoryBean> getAllCategorys() {
		// TODO 自动生成的方法存根
		return this.getCategoryByMap(new HashMap<String,String>());
	}

	@Override
	public boolean deleteCategoryByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map==null){
			return false;
		}
		return categoryDao.deleteCategoryByMap(map)>0;	
	}

	@Override
	public boolean addCategoryByBean(CategoryBean categoryBean) {
		// TODO 自动生成的方法存根
		if(categoryBean==null){
			return false;
		}
		return categoryDao.insertCategoryByBean(categoryBean);
	}
	@Override
	public boolean checkIfCategoryCodeExisted(String categoryCode) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", categoryCode);
		return this.getCategoryByMap(map).size()==0;
	}

}
