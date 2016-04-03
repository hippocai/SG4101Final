package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;
import com.ft9.bean.VendorBean;


/**
 * class name:IVendorService <BR>
 * class description: The Interfaces of VendorService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
public interface IVendorService {

	/**
	 * Method name: getVendorByCategory <BR>
	 * Description: getVendorByCategory <BR>
	 * Remark: <BR>
	 * @param category
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> getVendorByCategory(String categoryCode);
	/**
	 * Method name: getVendorByMap <BR>
	 * Description: getVendorByMap <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> getVendorByMap(Map<String,String>map);
	/**
	 * Method name: getAllVendorInfo <BR>
	 * Description: Get All Vendor Info <BR>
	 * Remark: <BR>
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> getAllVendorInfo();
	
	/**
	 * Method name: deleteVendorByName <BR>
	 * Description: Delete Vendor By Name <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean deleteVendorByNameInCategory(String name,String categoryCode);
	/**
	 * Method name: isCodeExist <BR>
	 * Description: Check If Vendor Name Exist <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	
	public boolean addNewVendorInCategoryBeanList(VendorBean vendorBean,List<CategoryBean>categoryBeanList);

	/**
	 * Method name: updateVendor <BR>
	 * Description: updateVendor <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return  boolean<BR>
	 */
	public boolean updateVendorByCategoryList(VendorBean vendorBean,List<CategoryBean>categoryBeanList);
	
	/**
	 * Method name: searchVendorByKey <BR>
	 * Description: searchVendorByKey <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valueLike
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> searchVendorByKey(String key,String valueLike);
	
	/**
	 * Method name: deleteVendorByMap <BR>
	 * Description: deleteVendorByMap <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  boolean<BR>
	 */
	public boolean deleteVendorByMap(Map<String,String>map);
	
	/**
	 * Method name: getAllCategoriesByVendorName <BR>
	 * Description: getAllCategoriesByVendorName <BR>
	 * Remark: <BR>
	 * @param name
	 * @return  List<CategoryBean><BR>
	 */
	public List<CategoryBean>getAllCategoriesByVendorName(String vendorName);
	
	public boolean isNameExisted(String name);
}
