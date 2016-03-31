/**
 * 
 */
package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.StoreKeeperBean;


/**
 * class name:IStoreKeeperService <BR>
 * class description: The Interfaces of StoreKeeperService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public interface IStoreKeeperService {

	/**
	 * Method name: userLogin <BR>
	 * Description: User Login <BR>
	 * Remark: <BR>
	 * @param userName
	 * @param password
	 * @return  boolean<BR>
	 */
	public boolean userLogin(String userName,String password);
	/**
	 * Method name: isUserNameExisted <BR>
	 * Description: Check If User Name Existed <BR>
	 * Remark: <BR>
	 * @param userName
	 * @return  boolean<BR>
	 */
	public boolean isUserNameExisted(String userName);
	/**
	 * Method name: getAllStoreKeeper <BR>
	 * Description: Get All StoreKeeper <BR>
	 * Remark: <BR>
	 * @return  List<StoreKeeperBean><BR>
	 */
	public List<StoreKeeperBean> getAllStoreKeeper();
	/**
	 * Method name: getStoreKeeperByMap <BR>
	 * Description: Get StoreKeeper By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<StoreKeeperBean><BR>
	 */
	public List<StoreKeeperBean>getStoreKeeperByMap(Map<String,String>map);
	/**
	 * Method name: updatePassword <BR>
	 * Description: Modify Password <BR>
	 * Remark: <BR>
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return  boolean<BR>
	 */
	public boolean updatePassword(String userName,String oldPassword,String newPassword);
	/**
	 * Method name: deleteUserByName <BR>
	 * Description: Delete User By Name <BR>
	 * Remark: <BR>
	 * @param userName
	 * @return  boolean<BR>
	 */
	public boolean deleteUserByName(String userName);
	/**
	 * Method name: addStoreKeeper <BR>
	 * Description: Add New StoreKeeper <BR>
	 * Remark: <BR>
	 * @param userName
	 * @param password
	 * @return  boolean<BR>
	 */
	public boolean addStoreKeeper(String userName,String password);
}
