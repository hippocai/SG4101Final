package com.ft9.common;

import java.util.HashMap;
import java.util.Map;

public class Session {
	private static Map<String,String> sessionMap=new HashMap<String,String>();
	public static boolean sessionContainsKey(String key){
		return sessionMap.containsKey(key);
	}
	public static String getSession(String key){
		if(sessionContainsKey(key)){
			return sessionMap.get(key);
		}
		return null;
	}
	
	public static void addSession(String key,String value){
		sessionMap.put(key, value);
	}
	
	
}
