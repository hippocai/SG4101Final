package com.ft9.service;

/**
 * class name:ServiceNotFoundException <BR>
 * class description: The exception of service not found <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class ServiceNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6417094848493824806L;
	/**
	 * Method name: ServiceNotFoundException<BR>
	 * Description: Constructor<BR>
	 * Remark: <BR> <BR>
	 */
	public ServiceNotFoundException(){
		super("Service Not Found!");
	}
	/**
	 * Method name: ServiceNotFoundException<BR>
	 * Description: Constructor with details<BR>
	 * Remark: <BR>
	 * @param name <BR>
	 */
	public ServiceNotFoundException(String name){
		super("Service (name:"+name+") not found!");
	}

}
