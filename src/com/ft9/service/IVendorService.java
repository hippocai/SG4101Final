package com.ft9.service;

import java.util.List;
import java.util.Map;

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
	 * Method name: getVendorByMap <BR>
	 * Description: Get Vendor By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> getVendorByMap(Map<String,String> map);
	/**
	 * Method name: getAllVendorInfo <BR>
	 * Description: Get All Vendor Info <BR>
	 * Remark: <BR>
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> getAllVendorInfo();
	/**
	 * Method name: searchVendorByKey <BR>
	 * Description: Search Vendor By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valuelike
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean> searchVendorByKey(String key,String valuelike);
	/**
	 * Method name: deleteVendorByMap <BR>
	 * Description: Delete Vendor By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteVendorByMap(Map<String,String> map);
	/**
	 * Method name: deleteVendorByName <BR>
	 * Description: Delete Vendor By Name <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean deleteVendorByName(String code);
	/**
	 * Method name: isCodeExist <BR>
	 * Description: Check If Vendor Name Exist <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean isCodeExist(String code);
	/**
	 * Method name: addNewVendor <BR>
	 * Description: Add New Vendor <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return  boolean<BR>
	 */
	public boolean addNewVendor(VendorBean vendorBean);
	/**
	 * Method name: updateVendor <BR>
	 * Description: Update Vendor <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return  boolean<BR>
	 */
	public boolean updateVendor(VendorBean vendorBean);
}
