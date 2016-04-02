package com.ft9.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ft9.dao.DaoException;
import com.ft9.service.impl.CategoryService;
import com.ft9.service.impl.DiscountService;
import com.ft9.service.impl.PaymentService;
import com.ft9.service.impl.ProductService;
import com.ft9.service.impl.MemberService;
import com.ft9.service.impl.StoreKeeperService;
import com.ft9.service.impl.TransactionService;
import com.ft9.service.impl.VendorService;

public class ServiceManager {
	private static Logger log = Logger.getLogger(ServiceManager.class);
	private static Map<String,Object>serviceMap=new HashMap<String,Object>();
	
	/**
	 * Method name: init <BR>
	 * Description: Init all the service and get the instance <BR>
	 * Remark: <BR>
	 * @throws DaoException
	 * @throws ServiceNotFoundException  void<BR>
	 */
	public static void init() throws DaoException, ServiceNotFoundException{
		log.info("Initialing Service...");
		serviceMap.put("StoreKeeperService", StoreKeeperService.getInstance());
		serviceMap.put("DiscountService", DiscountService.getInstance());
		serviceMap.put("CategoryService", CategoryService.getInstance());
		serviceMap.put("ProductService", ProductService.getInstance());
		serviceMap.put("MemberService", MemberService.getInstance());
		serviceMap.put("TransactionService", TransactionService.getInstance());
		serviceMap.put("PaymentService", PaymentService.getInstance());
		serviceMap.put("VendorService", VendorService.getInstance());
		log.info("Initial Successful");
	}
	
	/**
	 * Method name: getService <BR>
	 * Description: get the service by service name <BR>
	 * Remark: <BR>
	 * @param serviceName
	 * @return
	 * @throws ServiceNotFoundException  Object<BR>
	 */
	public static Object getService(String serviceName) throws ServiceNotFoundException{
		if(!serviceName.endsWith("Service")){
			serviceName+="Service";
		}
		if(!serviceMap.containsKey(serviceName)){
			throw new ServiceNotFoundException(serviceName);
		}
		return serviceMap.get(serviceName);
	}
}
