package com.ft9.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ft9.dao.DaoException;
import com.ft9.service.impl.DiscountService;
import com.ft9.service.impl.MemberService;
import com.ft9.service.impl.StoreKeeperService;

public class ServiceManager {
	private static Logger log = Logger.getLogger(ServiceManager.class);
	private static Map<String,Object>serviceMap=new HashMap<String,Object>();
	public static void init() throws DaoException{
		log.info("Initialing Service...");
		serviceMap.put("StoreKeeperService", StoreKeeperService.getInstance());
		serviceMap.put("DiscountService", DiscountService.getInstance());
		serviceMap.put("MemberService", MemberService.getInstance());
		log.info("Initial Successful");
	}
	
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
