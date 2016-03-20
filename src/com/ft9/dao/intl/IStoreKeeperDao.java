package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.StoreKeeperBean;

public interface IStoreKeeperDao {
	public List<StoreKeeperBean>getStoreKeepersByMap(Map<String,String>map);
	
	public boolean insertStoreKeeperByBean(StoreKeeperBean storeKeeperBean);
	
	public int deleteStoreKeeperByMap(Map<String,String>map);
	
	public int updateStoreKeeper(StoreKeeperBean storeKeeperBean,Map<String,String>map);
}
