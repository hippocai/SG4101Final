package com.ft9.service.impl;

import java.awt.event.KeyListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.ft9.bean.StoreKeeperBean;
import com.ft9.common.Key;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoException;
import com.ft9.dao.impl.StoreKeeperDao;
import com.ft9.dao.intl.IStoreKeeperDao;
import com.ft9.service.IStoreKeeperService;
import com.ft9.util.QEncodeUtil;

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
		try {
			map.put("password", QEncodeUtil.encryptAES(password,Key.ENCODE_KEY));
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | UnsupportedEncodingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			return false;
		}
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
		try {
			StoreKeeperBean storeKeeperBean=new StoreKeeperBean();
			storeKeeperBean.setName(userName);
			storeKeeperBean.setPassword(QEncodeUtil.encryptAES(newPassword,Key.ENCODE_KEY));
			Map<String,String>map=new HashMap<String,String>();
			map.put("name", userName);
			map.put("password", QEncodeUtil.encryptAES(oldPassword,Key.ENCODE_KEY));
			return storeKeeperDao.updateStoreKeeper(storeKeeperBean, map)>0;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} 
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
		try {
			StoreKeeperBean storeKeeperBean=new StoreKeeperBean();
			if(userName==null||password==null){
				return false;
			}else if(this.isUserNameExisted(userName)){
				return false;
			}else{
				storeKeeperBean.setName(userName);
				storeKeeperBean.setPassword(QEncodeUtil.encryptAES(password,Key.ENCODE_KEY));
			}
			
			return storeKeeperDao.insertStoreKeeperByBean(storeKeeperBean);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} 
	}

}
