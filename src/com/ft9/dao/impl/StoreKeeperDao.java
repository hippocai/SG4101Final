package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.StoreKeeperBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IStoreKeeperDao;

public class StoreKeeperDao extends BaseDao implements IStoreKeeperDao {
	private static StoreKeeperDao storeKeeperDao=null;
	/**
	 * Method name: StoreKeeperDao<BR>
	 * Description: The constructor of the storekeeper dao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private StoreKeeperDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("StoreKeeper"));
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: Get  the instance of the storekeeper dao <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  StoreKeeperDao<BR>
	 */
	public static StoreKeeperDao getInstance() throws FileNotFoundException, IOException{
		if(storeKeeperDao==null){
			storeKeeperDao=new StoreKeeperDao();
		}
		return storeKeeperDao;
	}
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IStoreKeeperDao#getStoreKeepersByMap(java.util.Map) <BR>
	 * Method name: getStoreKeepersByMap <BR>
	 * Description: Get  storekeeper record by map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<StoreKeeperBean>getStoreKeepersByMap(Map<String,String>map){
		try {
			return super.<StoreKeeperBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IStoreKeeperDao#insertStoreKeeperByBean(com.ft9.bean.StoreKeeperBean) <BR>
	 * Method name: insertStoreKeeperByBean <BR>
	 * Description: Insert storekeeper record by bean <BR>
	 * Remark: <BR>
	 * @param storeKeeperBean
	 * @return  <BR>
	*/
	public boolean insertStoreKeeperByBean(StoreKeeperBean storeKeeperBean){
		return super.addBean(storeKeeperBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IStoreKeeperDao#deleteStoreKeeperByMap(java.util.Map) <BR>
	 * Method name: deleteStoreKeeperByMap <BR>
	 * Description: Delete storekeeper record by map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteStoreKeeperByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IStoreKeeperDao#updateStoreKeeper(com.ft9.bean.StoreKeeperBean, java.util.Map) <BR>
	 * Method name: updateStoreKeeper <BR>
	 * Description: Update storekeeper record by newbean and search map <BR>
	 * Remark: <BR>
	 * @param storeKeeperBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateStoreKeeper(StoreKeeperBean storeKeeperBean,Map<String,String>map){
		return super.updateBeanByMap(storeKeeperBean, map);
	}
}
