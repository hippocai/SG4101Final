package com.ft9.service;

/**
 * class name:ServiceException <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016��3��31��
 * @author caiyicheng
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1330283033021217828L;

	public ServiceException(){
		super("Service Exception");
	}
	public ServiceException(String detail){
		super("Service Exception,Detail:"+detail);
	}
}
