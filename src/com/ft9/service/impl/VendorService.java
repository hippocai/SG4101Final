package com.ft9.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.VendorBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.VendorDao;
import com.ft9.dao.intl.IVendorDao;
import com.ft9.service.IVendorService;
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
	private static VendorService vendorService = null;
	
	private VendorService() throws DaoNotExistException{
		vendorDao = (VendorDao)DAOer.getDao("Vendor");
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: get an instance of the vendorService <BR>
	 * Remark: <BR>
	 * @return
	 * @throws DaoNotExistException  VendorService<BR>
	 */
	public static VendorService getInstance() throws DaoNotExistException{
		if(vendorService == null){
			vendorService = new VendorService();
		}
		return vendorService;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#getVendorByMap(java.util.Map) <BR>
	 * Method name: getVendorByMap <BR>
	 * Description: get the vendor info into a map <BR>
	 * Remark: if not exist, return null<BR>
	 * @param map
	 * @return map <BR>
	*/
	@Override
	public List<VendorBean> getVendorByMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map != null){
			return vendorDao.getVendorsByMap(map);
		}
		return null;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#getAllVendorInfo() <BR>
	 * Method name: getAllVendorInfo <BR>
	 * Description: get all vendor info and store in a list<BR>
	 * Remark: <BR>
	 * @return list <BR>
	*/
	@Override
	public List<VendorBean> getAllVendorInfo() {
		// TODO Auto-generated method stub
		
		return this.getVendorByMap(new HashMap<String, String>());
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#searchVendorByKey(java.lang.String, java.lang.String) <BR>
	 * Method name: searchVendorByKey <BR>
	 * Description: search the vendor by value "key" <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valuelike
	 * @return list <BR>
	*/
	@Override
	public List<VendorBean> searchVendorByKey(String key, String valuelike) {
		// TODO Auto-generated method stub
		List<VendorBean> vendorList = getAllVendorInfo();
		if(key == null || valuelike == ""){
			return vendorList;
		}
		List<VendorBean> searchResult = new ArrayList<VendorBean>();
		for (VendorBean vendorBean : vendorList){
			Map<String, String> vendorMap = BeanUtil.transBean2Map(vendorBean);
			if (vendorMap.containsKey(key)){
				if (vendorMap.get(key).contains(valuelike)){
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
	 * Description: delete the vendor by map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return int <BR>
	*/
	@Override
	public int deleteVendorByMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map != null){
			return vendorDao.deleteVendorByMap(map);
		}
		return -1;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#deleteVendorByName(java.lang.String) <BR>
	 * Method name: deleteVendorByName <BR>
	 * Description: delete the value by value "name" <BR>
	 * Remark: <BR>
	 * @param code
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteVendorByName(String code) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", code);
		return this.deleteVendorByMap(map) > 0;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#isCodeExist(java.lang.String) <BR>
	 * Method name: isCodeExist <BR>
	 * Description: check if the code exist <BR>
	 * Remark: <BR>
	 * @param code
	 * @return boolean <BR>
	*/
	@Override
	public boolean isCodeExist(String code) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", code);
		return this.getVendorByMap(map).size() > 0;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#addNewVendor(com.ft9.bean.VendorBean) <BR>
	 * Method name: addNewVendor <BR>
	 * Description: add new vendor into the Dao <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean addNewVendor(VendorBean vendorBean) {
		// TODO Auto-generated method stub
		if(vendorBean == null){
			return false;
		}
		return vendorDao.insertVendorByBean(vendorBean);
	}
	/**
	 * @Override
	 * @see com.ft9.service.IVendorService#updateVendor(com.ft9.bean.VendorBean) <BR>
	 * Method name: updateVendor <BR>
	 * Description: update the vendor into the Dao <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean updateVendor(VendorBean vendorBean) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", vendorBean.getName());
		return vendorDao.updateVendor(vendorBean, map) > 0;
	}

}
