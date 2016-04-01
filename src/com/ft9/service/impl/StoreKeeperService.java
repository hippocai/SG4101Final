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

/**
 * class name:StoreKeeperService <BR>
 * class description: Implements Of The Functions In StoreKeeperService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
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
	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#userLogin(java.lang.String, java.lang.String) <BR>
	 * Method name: userLogin <BR>
	 * Description: User Login <BR>
	 * Remark: <BR>
	 * @param userName
	 * @param password
	 * @return boolean <BR>
	*/
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

	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#isUserNameExisted(java.lang.String) <BR>
	 * Method name: isUserNameExisted <BR>
	 * Description: Check If User Name Existed <BR>
	 * Remark: <BR>
	 * @param userName
	 * @return boolean <BR>
	*/
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

	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#getAllStoreKeeper() <BR>
	 * Method name: getAllStoreKeeper <BR>
	 * Description: Get All StoreKeeper Infomation <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<StoreKeeperBean> getAllStoreKeeper() {
		// TODO 自动生成的方法存根
		return this.getStoreKeeperByMap(new HashMap<String,String>());
	}

	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#getStoreKeeperByMap(java.util.Map) <BR>
	 * Method name: getStoreKeeperByMap <BR>
	 * Description: Get StoreKeeper By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<StoreKeeperBean> getStoreKeeperByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		return storeKeeperDao.getStoreKeepersByMap(map);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#updatePassword(java.lang.String, java.lang.String, java.lang.String) <BR>
	 * Method name: updatePassword <BR>
	 * Description: Modify Password <BR>
	 * Remark: <BR>
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return boolean <BR>
	*/
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

	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#deleteUserByName(java.lang.String) <BR>
	 * Method name: deleteUserByName <BR>
	 * Description: Delete User By Name <BR>
	 * Remark: <BR>
	 * @param userName
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteUserByName(String userName) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", userName);
		return storeKeeperDao.deleteStoreKeeperByMap(map)>0;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IStoreKeeperService#addStoreKeeper(java.lang.String, java.lang.String) <BR>
	 * Method name: addStoreKeeper <BR>
	 * Description: Add New StoreKeeper <BR>
	 * Remark: <BR>
	 * @param userName
	 * @param password
	 * @return boolean <BR>
	*/
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
