package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.VendorBean;


public interface IVendorService {
	public List<VendorBean> getVendorByMap(Map<String,String> map);
	public List<VendorBean> getAllVendorInfo();
	public List<VendorBean> searchVendorByKey(String key,String valuelike);
	public int deleteVendorByMap(Map<String,String> map);
	public boolean deleteVendorByName(String code);
	public boolean isCodeExist(String code);
	public boolean addNewVendor(VendorBean vendorBean);
	public boolean updateVendor(VendorBean vendorBean);
}
