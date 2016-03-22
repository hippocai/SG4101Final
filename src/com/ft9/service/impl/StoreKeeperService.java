package com.ft9.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.StoreKeeperBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoException;
import com.ft9.dao.impl.StoreKeeperDao;
import com.ft9.dao.intl.IStoreKeeperDao;
import com.ft9.service.IStoreKeeperService;

public class StoreKeeperService implements IStoreKeeperService{
	
	IStoreKeeperDao storeKeeperDao;
	private static StoreKeeperService storeKeeperService=null;
	public static StoreKeeperService getInstance()throws DaoException{
		if(storeKeeperService==null){
			storeKeeperService=new StoreKeeperService();
		}
		return storeKeeperService;
	}
	private StoreKeeperService()throws DaoException{
		storeKeeperDao=(StoreKeeperDao)DAOer.getDao("StoreKeeper");
	}
	@Override
	public boolean userLogin(String userName, String password) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", userName);
		map.put("password", password);
		List<StoreKeeperBean> storeKeepers=this.getStoreKeeperByMap(map);
		if(storeKeepers==null||storeKeepers.size()==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean isUserNameExisted(String userName) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", userName);
		List<StoreKeeperBean>storeKeepers=this.getStoreKeeperByMap(map);
		if(storeKeepers==null||storeKeepers.size()==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<StoreKeeperBean> getAllStoreKeeper() {
		// TODO 自动生成的方法存根
		return this.getStoreKeeperByMap(new HashMap<String,String>());
	}

	@Override
	public List<StoreKeeperBean> getStoreKeeperByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		return storeKeeperDao.getStoreKeepersByMap(map);
	}

	@Override
	public boolean updatePassword(String userName, String oldPassword,String newPassword) {
		// TODO 自动生成的方法存根
		StoreKeeperBean storeKeeperBean=new StoreKeeperBean();
		storeKeeperBean.setName(userName);
		storeKeeperBean.setPassword(newPassword);
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", userName);
		map.put("password", oldPassword);
		return storeKeeperDao.updateStoreKeeper(storeKeeperBean, map)>0;
	}

	@Override
	public boolean deleteUserByName(String userName) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", userName);
		return storeKeeperDao.deleteStoreKeeperByMap(map)>0;
	}
	@Override
	public boolean addStoreKeeper(String userName,String password) {
		// TODO 自动生成的方法存根
		StoreKeeperBean storeKeeperBean=new StoreKeeperBean();
		if(userName==null||password==null){
			return false;
		}else if(this.isUserNameExisted(userName)){
			return false;
		}else{
			storeKeeperBean.setName(userName);
			storeKeeperBean.setPassword(password);
		}
		
		return storeKeeperDao.insertStoreKeeperByBean(storeKeeperBean);
	}

}
