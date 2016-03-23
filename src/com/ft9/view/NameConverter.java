package com.ft9.view;

import java.util.HashMap;
import java.util.Map;

import com.ft9.common.FileConst;

public class NameConverter {
	private static Map<String,String>NameMap=new HashMap<String,String>();
	final private static int PhysicName2ViewName=0x01;
	final private static int ViewName2PhysicName=0x02;
	static{
		NameMap.put("Product", "ID,Name,Description,Quantity,Price,Barcode,Threshold,Order");
		NameMap.put("Category", "Code,Name");
		NameMap.put("Member", "Name,ID,LoyaltyPoint");
		NameMap.put("Transaction", "ID,productId,memberId,quantityPurchased,date");
		NameMap.put("Discount", "Code,Description,Start Date,Period,Percentage,Applicable");
		NameMap.put("Vendor", "Name,Description");
		NameMap.put("StoreKeeper", "Name,Password");
	}
	
	public static String[] getTitleArr(String functionName){
		if(!NameMap.containsKey(functionName)){
			return null;
		}else{
			return NameMap.get(functionName).split(",");
		}
	}
	
	private static String convert(String functionName,String fieldName,int convertType){
		String[] nameArr=getTitleArr(functionName);
		if(nameArr==null){
			return null;
		}
		for(int i=0;i<nameArr.length;++i){
			String[] physicViewArr=FileConst.getRecordFormatArray(functionName);
			switch(convertType){
				case PhysicName2ViewName:if(fieldName.equals(physicViewArr[i]))return nameArr[i];break;
				case ViewName2PhysicName:if(fieldName.equals(nameArr[i]))return physicViewArr[i];break;
				default:return null;
			}
			
		}
		return null;
	}
	
	public static String convertPhysicName2ViewName(String functionName,String fieldName){
		return convert(functionName,fieldName,NameConverter.PhysicName2ViewName);
	}
	
	public static String convertViewName2PhysicName(String functionName,String viewName){
		return convert(functionName,viewName,NameConverter.ViewName2PhysicName);
	}
	
	public static Map<String,String>convertViewMap2PhysicMap(Map<String,String>map,String functionName){
		Map<String,String>physicMap=new HashMap<String,String>();
		
		for(String viewName:map.keySet()){
			String key=NameConverter.convertViewName2PhysicName(functionName, viewName);
			String value=map.get(viewName);
			physicMap.put(key, value);
		}
		
		return physicMap;
	}
	
	public static Map<String,String>convertPhysicMap2ViewMap(Map<String,String>map,String functionName){
		Map<String,String>viewMap=new HashMap<String,String>();
		
		for(String physicName:map.keySet()){
			String key=NameConverter.convertPhysicName2ViewName(functionName, physicName);
			String value=map.get(physicName);
			viewMap.put(key, value);
		}
		
		return viewMap;
	}
}
