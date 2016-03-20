package com.ft9.service;

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
