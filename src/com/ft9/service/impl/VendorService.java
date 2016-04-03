package com.ft9.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;
import com.ft9.bean.VendorBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.VendorDao;
import com.ft9.dao.intl.IVendorDao;
import com.ft9.service.ICategoryService;
import com.ft9.service.IVendorService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.util.BeanUtil;

/**
 * class name:VendorService <BR>
 * class description: Implements the functions in the IVendorService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
public class VendorService implements IVendorService{
	
	private IVendorDao vendorDao = null;
	private ICategoryService categoryService=null;
	private static VendorService vendorService = null;
	
	private VendorService() throws DaoNotExistException, ServiceNotFoundException{
		vendorDao = (VendorDao)DAOer.getDao("Vendor");
		categoryService=(CategoryService)ServiceManager.getService("Category");
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: get an instance of the vendorService <BR>
	 * Remark: <BR>
	 * @return vendorService
	 * @throws DaoNotExistException  VendorService<BR>
	 * @throws ServiceNotFoundException 
	 */
	public static VendorService getInstance() throws DaoNotExistException, ServiceNotFoundException{
		if(vendorService == null){
			vendorService = new VendorService();
		}
		return vendorService;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#getVendorByCategory(java.lang.String) <BR>
	 * Method name: getVendorByCategory <BR>
	 * Description: Get Vendor By Category <BR>
	 * Remark: <BR>
	 * @param categoryCode
	 * @return List <BR>
	*/
	@Override
	public List<VendorBean> getVendorByCategory(String categoryCode) {
		try {
			vendorDao.setCategory(categoryCode);
			return vendorDao.getVendorsByMap(new HashMap<String,String>());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#getVendorByMap(java.util.Map) <BR>
	 * Method name: getVendorByMap <BR>
	 * Description: Get Vendor By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<VendorBean> getVendorByMap(Map<String, String> map) {
		try{
			List<CategoryBean>categoryList=categoryService.getAllCategorys();
			List<VendorBean>vendorList=new ArrayList<VendorBean>();
			if(map.containsKey("category")){
				String categoryName=map.get("category");
				map.remove("category");
				vendorDao.setCategory(categoryName);
				return vendorDao.getVendorsByMap(map);
			}else{
				for(CategoryBean categoryBean:categoryList){
					vendorDao.setCategory(categoryBean.getCode());
					List<VendorBean>selectedVendorList=vendorDao.getVendorsByMap(map);
					for(VendorBean vendorBean:selectedVendorList){
						if(!this.vendorListContains(vendorList, vendorBean)){
							vendorList.add(vendorBean);
						}
					}
					
				}
				return vendorList;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#getAllVendorInfo() <BR>
	 * Method name: getAllVendorInfo <BR>
	 * Description: Get All Vendor Information <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<VendorBean> getAllVendorInfo() {
		return this.getVendorByMap(new HashMap<String,String>());
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#deleteVendorByNameInCategory(java.lang.String, java.lang.String) <BR>
	 * Method name: deleteVendorByNameInCategory <BR>
	 * Description: Delete Vendor By Name In Category <BR>
	 * Remark: <BR>
	 * @param name
	 * @param category
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteVendorByNameInCategory(String name, String category) {
		try{
			vendorDao.setCategory(category);
			Map<String,String>map=new HashMap<String,String>();
			map.put("name", name);
			return vendorDao.deleteVendorByMap(map)>0;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}


	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#searchVendorByKey(java.lang.String, java.lang.String) <BR>
	 * Method name: searchVendorByKey <BR>
	 * Description: Search Vendor By key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valueLike
	 * @return List <BR>
	*/
	@Override
	public List<VendorBean> searchVendorByKey(String key, String valueLike) {
		List<VendorBean> vendorList = getAllVendorInfo();
		if(key == null || valueLike == ""){
			return vendorList;
		}
		List<VendorBean> searchResult = new ArrayList<VendorBean>();
		for (VendorBean vendorBean : vendorList){
			Map<String, String> vendorMap = BeanUtil.transBean2Map(vendorBean);
			if (vendorMap.containsKey(key)){
				if (vendorMap.get(key).contains(valueLike)){
					searchResult.add(vendorBean);
				}
			}
		}
		
		return searchResult;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#deleteVendorByMap(java.util.Map) <BR>
	 * Method name: deleteVendorByMap <BR>
	 * Description: Delete Vendor By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteVendorByMap(Map<String, String> map) {
		try{
			int affectedRowNumber=0;
			if(map.containsKey("category")){
				String categoryName=map.get("category");
				map.remove("category");
				vendorDao.setCategory(categoryName);
				return vendorDao.deleteVendorByMap(map)>0;
			}else{
				List<CategoryBean>categoryBeanList=categoryService.getAllCategorys();
				for(CategoryBean categoryBean:categoryBeanList){
					String categoryCode=categoryBean.getCode();
					vendorDao.setCategory(categoryCode);
					affectedRowNumber+=vendorDao.deleteVendorByMap(map);
				}
				System.out.println(affectedRowNumber);
				return affectedRowNumber>0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#getAllCategoriesByVendorName(java.lang.String) <BR>
	 * Method name: getAllCategoriesByVendorName <BR>
	 * Description: Get All Category By Vendor Name <BR>
	 * Remark: <BR>
	 * @param name
	 * @return List <BR>
	*/
	@Override
	public List<CategoryBean> getAllCategoriesByVendorName(String name) {
		try {
			Map<String,String>map=new HashMap<String,String>();
			map.put("name", name);
			List<CategoryBean>selectedCategoryList=new ArrayList<CategoryBean>();
			List<CategoryBean>allCategories=categoryService.getAllCategorys();
			for(CategoryBean categoryBean:allCategories){
				vendorDao.setCategory(categoryBean.getCode());
				List<VendorBean>vendorList=vendorDao.getVendorsByMap(map);
				if(vendorList!=null&&vendorList.size()!=0){
					selectedCategoryList.add(categoryBean);
				}
			}
			return selectedCategoryList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#addNewVendorInCategoryBeanList(com.ft9.bean.VendorBean, java.util.List) <BR>
	 * Method name: addNewVendorInCategoryBeanList <BR>
	 * Description: Add New Vendor In Category BeanList <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @param categoryBeanList
	 * @return boolean <BR>
	*/
	@Override
	public boolean addNewVendorInCategoryBeanList(VendorBean vendorBean,
			List<CategoryBean> categoryBeanList) {
		try {
			for(CategoryBean categoryBean:categoryBeanList){
				vendorDao.setCategory(categoryBean.getCode());
				vendorDao.insertVendorByBean(vendorBean);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#updateVendorByCategoryList(com.ft9.bean.VendorBean, java.util.List) <BR>
	 * Method name: updateVendorByCategoryList <BR>
	 * Description: Update Vendor By Category List <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @param categoryBeanList
	 * @return boolean <BR>
	*/
	@Override
	public boolean updateVendorByCategoryList(VendorBean vendorBean,List<CategoryBean> categoryBeanList) {
		try {
			Map<String,String>map=new HashMap<String,String>();
			map.put("name", vendorBean.getName());
			this.deleteVendorByMap(map);
			this.addNewVendorInCategoryBeanList(vendorBean, categoryBeanList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method name: vendorListContains <BR>
	 * Description: Vendor List Contains <BR>
	 * Remark: <BR>
	 * @param vendorList
	 * @param vendorBean
	 * @return  boolean<BR>
	 */
	private boolean vendorListContains(List<VendorBean>vendorList,VendorBean vendorBean){
		for(VendorBean vendorBeanInList:vendorList){
			if(vendorBeanInList.getName().equals(vendorBean.getName())){
				return true;
			}
		}
		return false;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#isNameExisted(java.lang.String) <BR>
	 * Method name: isNameExisted <BR>
	 * Description: Check If The Vendor Name Existed <BR>
	 * Remark: <BR>
	 * @param name
	 * @return boolean <BR>
	*/
	@Override
	public boolean isNameExisted(String name) {
		List<VendorBean>vendorBeanList=this.getAllVendorInfo();
		for(VendorBean vendorBean:vendorBeanList){
			if(vendorBean.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	

}
