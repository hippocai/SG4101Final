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
	private StoreKeeperDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("StoreKeeper"));
	}
	
	private static StoreKeeperDao storeKeeperDao=null;
	public static StoreKeeperDao getInstance() throws FileNotFoundException, IOException{
		if(storeKeeperDao==null){
			storeKeeperDao=new StoreKeeperDao();
		}
		return storeKeeperDao;
	}
	public List<StoreKeeperBean>getStoreKeepersByMap(Map<String,String>map){
		try {
			return super.<StoreKeeperBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertStoreKeeperByBean(StoreKeeperBean storeKeeperBean){
		return super.addBean(storeKeeperBean);
	}
	
	public int deleteStoreKeeperByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateStoreKeeper(StoreKeeperBean storeKeeperBean,Map<String,String>map){
		return super.updateBeanByMap(storeKeeperBean, map);
	}
}
