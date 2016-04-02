package com.ft9.service;

/**
 * class name:ServiceException <BR>
 * class description: Exception in the service <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê3ÔÂ31ÈÕ
 * @author caiyicheng
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1330283033021217828L;

	/**
	 * Method name: ServiceException<BR>
	 * Description: Constructor<BR>
	 * Remark: <BR> <BR>
	 */
	public ServiceException(){
		super("Service Exception");
	}
	/**
	 * Method name: ServiceException<BR>
	 * Description: Constructor with detail<BR>
	 * Remark: <BR>
	 * @param detail <BR>
	 */
	public ServiceException(String detail){
		super("Service Exception,Detail:"+detail);
	}
}
