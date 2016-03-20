package com.ft9.service;

public class ServiceNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6417094848493824806L;
	public ServiceNotFoundException(){
		super("Service Not Found!");
	}
	public ServiceNotFoundException(String name){
		super("Service (name:"+name+") not found!");
	}

}
