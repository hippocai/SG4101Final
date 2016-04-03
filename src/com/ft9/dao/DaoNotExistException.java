/**
 * 
 */
package com.ft9.dao;

/**
 * @author CaiYicheng
 */
/**
 * class name:DaoNotExistException <BR>
 * class description: DAO not found exception <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class DaoNotExistException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8353431197028877001L;
	public DaoNotExistException(){
		super("The DAO is not exist!");
	}
	
	public DaoNotExistException(String typeName){
		super("The Dao (name:"+typeName+") is not exist!");
	}

}
