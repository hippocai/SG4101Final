/**
 * 
 */
package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.StoreKeeperBean;

/**
 * @author hippo
 *
 */
public interface IStoreKeeperService {

	public boolean userLogin(String userName,String password);
	public boolean isUserNameExisted(String userName);
	public List<StoreKeeperBean> getAllStoreKeeper();
	public List<StoreKeeperBean>getStoreKeeperByMap(Map<String,String>map);
	public boolean updatePassword(String userName,String oldPassword,String newPassword);
	public boolean deleteUserByName(String userName);
	public boolean addStoreKeeper(String userName,String password);
}
