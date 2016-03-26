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

public class VendorService implements IVendorService{
	
	private IVendorDao vendorDao = null;
	private static VendorService vendorService = null;
	
	private VendorService() throws DaoNotExistException{
		vendorDao = (VendorDao)DAOer.getDao("Vendor");
	}
	
	public static VendorService getInstance() throws DaoNotExistException{
		if(vendorService == null){
			vendorService = new VendorService();
		}
		return vendorService;
	}
	@Override
	public List<VendorBean> getVendorByMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map != null){
			return vendorDao.getVendorsByMap(map);
		}
		return null;
	}
	@Override
	public List<VendorBean> getAllVendorInfo() {
		// TODO Auto-generated method stub
		
		return this.getVendorByMap(new HashMap<String, String>());
	}
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
	@Override
	public int deleteVendorByMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map != null){
			return vendorDao.deleteVendorByMap(map);
		}
		return -1;
	}
	@Override
	public boolean deleteVendorByName(String code) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", code);
		return this.deleteVendorByMap(map) > 0;
	}
	@Override
	public boolean isCodeExist(String code) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", code);
		return this.getVendorByMap(map).size() > 0;
	}
	@Override
	public boolean addNewVendor(VendorBean vendorBean) {
		// TODO Auto-generated method stub
		if(vendorBean == null){
			return false;
		}
		return vendorDao.insertVendorByBean(vendorBean);
	}
	@Override
	public boolean updateVendor(VendorBean vendorBean) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", vendorBean.getName());
		return vendorDao.updateVendor(vendorBean, map) > 0;
	}

}
