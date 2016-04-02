package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.StoreKeeperBean;

/**
 * class name:IStoreKeeperDao <BR>
 * class description: The interface of storekeeper dao <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê4ÔÂ2ÈÕ
 * @author caiyicheng
 */
public interface IStoreKeeperDao {
	/**
	 * Method name: getStoreKeepersByMap <BR>
	 * Description: Get the storekeeper by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<StoreKeeperBean><BR>
	 */
	public List<StoreKeeperBean>getStoreKeepersByMap(Map<String,String>map);
	
	/**
	 * Method name: insertStoreKeeperByBean <BR>
	 * Description: Insert the storekeeper by bean <BR>
	 * Remark: <BR>
	 * @param storeKeeperBean
	 * @return  boolean<BR>
	 */
	public boolean insertStoreKeeperByBean(StoreKeeperBean storeKeeperBean);
	
	/**
	 * Method name: deleteStoreKeeperByMap <BR>
	 * Description: Delete storekeeper by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteStoreKeeperByMap(Map<String,String>map);
	
	/**
	 * Method name: updateStoreKeeper <BR>
	 * Description: Update storekeeper by new bean and search map <BR>
	 * Remark: <BR>
	 * @param storeKeeperBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateStoreKeeper(StoreKeeperBean storeKeeperBean,Map<String,String>map);
}
