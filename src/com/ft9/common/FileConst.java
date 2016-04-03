package com.ft9.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileConst {

	
	private static Map<String,String>fileRecordFormatMap=new HashMap<String,String>();
	private static Map<String,String>fileNameMap=new HashMap<String,String>();
	
	static{
		fileNameMap.put("Product", "data/Products.dat");
		fileNameMap.put("Category", "data/Category.dat");
		fileNameMap.put("Member", "data/Members.dat");
		fileNameMap.put("Transaction", "data/Transactions.dat");
		fileNameMap.put("Discount", "data/Discounts.dat");
		//fileNameMap.put("Vendor", "VendorsMUG.dat");
		fileNameMap.put("StoreKeeper", "data/StoreKeepers.dat");
		
	}

	static{
		fileRecordFormatMap.put("Product", "id,name,description,quantityAvailable,price,barCode,reorderQuantity,orderQuantity");
		fileRecordFormatMap.put("Category", "code,name");
		fileRecordFormatMap.put("Member", "name,id,loyaltyPoint");
		fileRecordFormatMap.put("Transaction", "id,productId,memberId,quantityPurchased,date");
		fileRecordFormatMap.put("Discount", "code,description,startDate,discountPeriod,discountPercentage,memberApplicable");
		fileRecordFormatMap.put("Vendor", "name,description");
		fileRecordFormatMap.put("StoreKeeper", "name,password");
	}


	
	public static String getRecordFormat(String beanName){
		return fileRecordFormatMap.get(beanName);
	}
	
	public static String[] getRecordFormatArray(String beanName){
		String [] formatListArr=getRecordFormat(beanName).split(",");
		return formatListArr;
	}
	public static List<String>getRecordFormatList(String beanName){
		String [] formatListArr=getRecordFormatArray(beanName);
		List<String>formatList=new ArrayList<String>();
		for(String formatUnit:formatListArr){
			formatList.add(formatUnit);
		}
		
		return formatList;
	}
	
	public static String getFileNameByBeanName(String beanName){
		return fileNameMap.get(beanName);
	}
}
