package com.ft9.dao.intl;


import java.util.List;
import java.util.Map;
import com.ft9.bean.VendorBean;


/**
 * class name:IVendorDao <BR>
 * class description: The interface of vendor dao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public interface IVendorDao {
	/**
	 * Method name: getVendorsByMap <BR>
	 * Description: Get the vendor by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<VendorBean><BR>
	 */
	public List<VendorBean>getVendorsByMap(Map<String,String>map);
	
	/**
	 * Method name: insertVendorByBean <BR>
	 * Description: Insert the vendor by bean <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @return  boolean<BR>
	 */
	public boolean insertVendorByBean(VendorBean vendorBean);
	
	/**
	 * Method name: deleteVendorByMap <BR>
	 * Description: Delete the vendor by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteVendorByMap(Map<String,String>map);
	
	/**
	 * Method name: updateVendor <BR>
	 * Description: Update the vendor by new bean and search map <BR>
	 * Remark: <BR>
	 * @param vendorBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateVendor(VendorBean vendorBean,Map<String,String>map);
}
