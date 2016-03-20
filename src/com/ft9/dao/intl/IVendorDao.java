package com.ft9.dao.intl;


import java.util.List;
import java.util.Map;
import com.ft9.bean.VendorBean;


public interface IVendorDao {
	public List<VendorBean>getVendorsByMap(Map<String,String>map);
	
	public boolean insertVendorByBean(VendorBean vendorBean);
	
	public int deleteVendorByMap(Map<String,String>map);
	
	public int updateVendor(VendorBean vendorBean,Map<String,String>map);
}
