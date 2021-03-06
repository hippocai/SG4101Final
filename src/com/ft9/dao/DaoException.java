package com.ft9.dao;
/**
 * @author CaiYicheng
 */
/**
 * class name:DaoException <BR>
 * class description: DAO Exception <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3416656431692241775L;
	
	public DaoException(){
		super("Exception At Dao");
	}
	
	public DaoException(String detail){
		super("Exception At Dao:"+detail);
	}

}
