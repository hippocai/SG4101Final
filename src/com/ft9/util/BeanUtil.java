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

    public static void transMap2Bean(Map<String, String> map, Object obj) {  
  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
  
            }  
  
        } catch (Exception e) {  
           e.printStackTrace();
        }  
  
        return;  
  
    }  
  
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
  
                if (!key.equals("class")&&!key.contains("callback")) {  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value.toString()+"");  
                } 
  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
        }  
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
  
                if (!key.equals("class")&&!key.contains("callback")) {  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value.toString()+"");  
                } 
  
            }  
            return map.toString();
        } catch (Exception e) {  
            e.printStackTrace();
        }  
        return "ERROR";
    }  
    
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
