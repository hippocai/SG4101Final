package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.VendorBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IVendorDao;

public class VendorDao extends BaseDao implements IVendorDao {
	private VendorDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Vendor"));
	}
	
	private static VendorDao vendorDao=null;
	public static VendorDao getInstance() throws FileNotFoundException, IOException{
		if(vendorDao==null){
			vendorDao=new VendorDao();
		}
		return vendorDao;
	}
	public List<VendorBean>getVendorsByMap(Map<String,String>map){
		try {
			return super.<VendorBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertVendorByBean(VendorBean vendorBean){
		return super.addBean(vendorBean);
	}
	
	public int deleteVendorByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateVendor(VendorBean vendorBean,Map<String,String>map){
		return super.updateBeanByMap(vendorBean, map);
	}
}
