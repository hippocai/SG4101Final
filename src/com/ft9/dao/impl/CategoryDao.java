package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.ICategoryDao;

public class CategoryDao extends BaseDao implements ICategoryDao{
	private static CategoryDao categoryDao=null;
	public static CategoryDao getInstance() throws FileNotFoundException, IOException{
		if(categoryDao==null){
			categoryDao=new CategoryDao();
		}
		return categoryDao;
	}
	private CategoryDao() throws FileNotFoundException, IOException{
		
		super(FileConst.getFileNameByBeanName("Category"));
	}
	
	public List<CategoryBean>getCategorysByMap(Map<String,String>map){

		try {
			return super.<CategoryBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertCategoryByBean(CategoryBean categoryBean){
		return super.addBean(categoryBean);
	}
	
	public int deleteCategoryByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateCategory(CategoryBean categoryBean,Map<String,String>map){
		return super.updateBeanByMap(categoryBean, map);
	}
	

}
