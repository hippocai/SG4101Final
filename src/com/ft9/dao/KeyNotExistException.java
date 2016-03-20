package com.ft9.dao;
/**
 * @author CaiYicheng
 */
public class KeyNotExistException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2332602787255056447L;
	public KeyNotExistException(){
		super("The Key In Select Map Is Not Exist In The Bean");
	}
	
	public KeyNotExistException(String keyName){
		super("The Key In Select Map Is Not Exist In The Bean,KeyName:"+keyName);
	}

}
