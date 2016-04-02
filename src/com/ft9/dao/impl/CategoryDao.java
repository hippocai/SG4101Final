package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.ICategoryDao;

/**
 * class name:CategoryDao <BR>
 * class description: The implement of the ICategoryDao <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author caiyicheng
 */
public class CategoryDao extends BaseDao implements ICategoryDao{
	private static CategoryDao categoryDao=null;
	/**
	 * Method name: getInstance <BR>
	 * Description: Get the Instance of the category dao <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  CategoryDao<BR>
	 */
	public static CategoryDao getInstance() throws FileNotFoundException, IOException{
		if(categoryDao==null){
			categoryDao=new CategoryDao();
		}
		return categoryDao;
	}
	/**
	 * Method name: CategoryDao<BR>
	 * Description: The constructor of the category dao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private CategoryDao() throws FileNotFoundException, IOException{
		
		super(FileConst.getFileNameByBeanName("Category"));
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ICategoryDao#getCategorysByMap(java.util.Map) <BR>
	 * Method name: getCategorysByMap <BR>
	 * Description: Get Category By Search Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<CategoryBean>getCategorysByMap(Map<String,String>map){

		try {
			return super.<CategoryBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ICategoryDao#insertCategoryByBean(com.ft9.bean.CategoryBean) <BR>
	 * Method name: insertCategoryByBean <BR>
	 * Description: Insert a category record by bean <BR>
	 * Remark: <BR>
	 * @param categoryBean
	 * @return  <BR>
	*/
	public boolean insertCategoryByBean(CategoryBean categoryBean){
		return super.addBean(categoryBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ICategoryDao#deleteCategoryByMap(java.util.Map) <BR>
	 * Method name: deleteCategoryByMap <BR>
	 * Description: Delete category record by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteCategoryByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ICategoryDao#updateCategory(com.ft9.bean.CategoryBean, java.util.Map) <BR>
	 * Method name: updateCategory <BR>
	 * Description: Update the category by new bean and search map <BR>
	 * Remark: <BR>
	 * @param categoryBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateCategory(CategoryBean categoryBean,Map<String,String>map){
		return super.updateBeanByMap(categoryBean, map);
	}
	

}
