package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.VendorBean;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IVendorDao;

/**
 * class name:VendorDao <BR>
 * class description: The implement of the IVendorDao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class VendorDao extends BaseDao implements IVendorDao {
	private static VendorDao vendorDao=null;
	@SuppressWarnings("unused")
	private String categoryName=null;
	/**
	 * Method name: VendorDao<BR>
	 * Description: The Constructor of vendor dao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private VendorDao() throws FileNotFoundException, IOException{
		//super(FileConst.getFileNameByBeanName("Vendor"));
	}

	/**
	 * Method name: getInstance <BR>
	 * Description: Get the instance of Dao <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  VendorDao<BR>
	 */
	public static VendorDao getInstance() throws FileNotFoundException, IOException{
		if(vendorDao==null){
			vendorDao=new VendorDao();
		}
		return vendorDao;
	}
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IVendorDao#getVendorsByMap(java.util.Map) <BR>
	 * Method name: getVendorsByMap <BR>
	 * Description: Get the vendor by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<VendorBean>getVendorsByMap(Map<String,String>map){
		try {
			return super.<VendorBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IVendorDao#insertVendorByBean(com.ft9.bean.VendorBean) <BR>
	 * Method name: insertVendorByBean <BR>
	 * Description: Insert record by bean <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return  <BR>
	*/
	public boolean insertVendorByBean(VendorBean vendorBean){
		return super.addBean(vendorBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IVendorDao#deleteVendorByMap(java.util.Map) <BR>
	 * Method name: deleteVendorByMap <BR>
	 * Description: Delete vendor record by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteVendorByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IVendorDao#updateVendor(com.ft9.bean.VendorBean, java.util.Map) <BR>
	 * Method name: updateVendor <BR>
	 * Description: Update vendor record by new Vendor bean and search Map<BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateVendor(VendorBean vendorBean,Map<String,String>map){
		return super.updateBeanByMap(vendorBean, map);
	}

	@Override
	public void setCategory(String category) throws IOException {
		// TODO 自动生成的方法存根
		super.setFilepath("data/Vendors"+category+".dat");
		
	}
}
