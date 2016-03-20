/*
 * All rights Reserved, Copyright (C) FUJITSU LIMITED 2011
 * FileName: BeanUtil.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2014-10-14        | JFTT)caiyicheng    | original version
 */
package com.ft9.util;

import java.beans.BeanInfo;  
import java.beans.Introspector;  
import java.beans.PropertyDescriptor;  
import java.lang.reflect.Method;  
import java.util.HashMap;  
import java.util.Map;  


/**
 * class name:BeanUtil <BR>
 * class description: Bean转Map和Map转Bean <BR>
 * Remark: <BR>
 * @version 1.00 2014-10-14
 * @author JFTT)caiyicheng
 */
public class BeanUtil {

    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean  
    public static void transMap2Bean(Map<String, String> map, Object obj) {  
  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
  
            }  
  
        } catch (Exception e) {  
           e.printStackTrace();
        }  
  
        return;  
  
    }  
  
    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
    public static Map<String, String> transBean2Map(Object obj) {  
  
        if(obj == null){  
            return null;  
        }          
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                //System.out.println("KEY:"+key);
  
                // 过滤class属�??  
                if (!key.equals("class")&&!key.contains("callback")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value.toString()+"");  
                } 
  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
        }  
        //System.out.println(map.toString());
        return map;  
    }  
    
    public static String outputBean(Object obj) {  
    	  
        if(obj == null){  
            return "NULL";  
        }          
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                //System.out.println("KEY:"+key);
  
                // 过滤class属�??  
                if (!key.equals("class")&&!key.contains("callback")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value.toString()+"");  
                } 
  
            }  
            return map.toString();
        } catch (Exception e) {  
            e.printStackTrace();
        }  
        //System.out.println(map.toString());
        return "ERROR";
    }  
    /**
     * ���Bean�����
     * eg.bean��ƣ�ProductBean,����:Product
     * @param bean
     * @return
     */
    public static String getBeanName(Object bean){
    	String classFullName=bean.getClass().getName();
    	String className=null;
    	if(classFullName.endsWith("Bean")){
    		className=classFullName.substring(classFullName.lastIndexOf(".")+1,classFullName.length()-4);
    	}else{
    		className=classFullName.substring(classFullName.lastIndexOf(".")+1);
    	}
    	return className;
    	
    }
}
