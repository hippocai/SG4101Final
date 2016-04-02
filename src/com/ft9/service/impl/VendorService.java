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
	 * @return
	 * @throws DaoNotExistException  VendorService<BR>
	 * @throws ServiceNotFoundException 
	 */
	public static VendorService getInstance() throws DaoNotExistException, ServiceNotFoundException{
		if(vendorService == null){
			vendorService = new VendorService();
		}
		return vendorService;
	}

	@Override
	public List<VendorBean> getVendorByCategory(String categoryCode) {
		// TODO 自动生成的方法存根
		try {
			vendorDao.setCategory(categoryCode);
			return vendorDao.getVendorsByMap(new HashMap<String,String>());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<VendorBean> getVendorByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
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

	@Override
	public List<VendorBean> getAllVendorInfo() {
		// TODO 自动生成的方法存根
		return this.getVendorByMap(new HashMap<String,String>());
	}

	@Override
	public boolean deleteVendorByNameInCategory(String name, String category) {
		// TODO 自动生成的方法存根
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

	@Override
	public boolean deleteVendorByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
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

	@Override
	public List<CategoryBean> getAllCategoriesByVendorName(String name) {
		// TODO 自动生成的方法存根
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addNewVendorInCategoryBeanList(VendorBean vendorBean,
			List<CategoryBean> categoryBeanList) {
		// TODO 自动生成的方法存根
		try {
			for(CategoryBean categoryBean:categoryBeanList){
				vendorDao.setCategory(categoryBean.getCode());
				vendorDao.insertVendorByBean(vendorBean);
			}
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateVendorByCategoryList(VendorBean vendorBean,List<CategoryBean> categoryBeanList) {
		// TODO 自动生成的方法存根
		try {
			Map<String,String>map=new HashMap<String,String>();
			map.put("name", vendorBean.getName());
			this.deleteVendorByMap(map);
			this.addNewVendorInCategoryBeanList(vendorBean, categoryBeanList);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	private boolean vendorListContains(List<VendorBean>vendorList,VendorBean vendorBean){
		//Map<String,String>vendorMap=BeanUtil.transBean2Map(vendorBean);
		for(VendorBean vendorBeanInList:vendorList){
			if(vendorBeanInList.getName().equals(vendorBean.getName())){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isNameExisted(String name) {
		// TODO 自动生成的方法存根
		List<VendorBean>vendorBeanList=this.getAllVendorInfo();
		for(VendorBean vendorBean:vendorBeanList){
			if(vendorBean.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	

}
