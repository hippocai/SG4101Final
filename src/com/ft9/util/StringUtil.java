/*
 * All rights Reserved, Copyright (C) GElement LIMITED 2015
 * FileName: StringUtil.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name           |      Content
 * 1   | 2015�?12�?8�?        | China)caiyicheng  | original version
 */
package com.ft9.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;


/**
 * class name:StringUtil <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2015�?12�?8�?
 * @author GElement)caiyicheng
 */
public class StringUtil {
	

	/**
	 * 特殊字符
	 */
	private static final String SPECIAL_CHARACTERS = "\n\r\f\'\"\\";

	/**
	 * 特殊字符-转义字符的映�?
	 */
	private static final Properties ESCAPE_MAP = new Properties();
	static {
		ESCAPE_MAP.put("\n", "\\n");
		ESCAPE_MAP.put("\r", "\\r");
		ESCAPE_MAP.put("\f", "\\f");
		ESCAPE_MAP.put("\'", "\\\'");
		ESCAPE_MAP.put("\"", "\\\"");
		ESCAPE_MAP.put("\\", "\\\\");
	}
	
	public static String escapeInStringLiterals(CharSequence text) {
		// 对null返回空白字符�?
		if (text == null) {
			return "";
		}

		// 字符串缓�?
		StringBuilder buff = new StringBuilder(text.length() + 16);
		// 以特殊字符为分隔符，将文本分段（含特殊字符）
		StringTokenizer st = new StringTokenizer(text.toString(),
				SPECIAL_CHARACTERS, true);

		while (st.hasMoreTokens()) {
			// 当前片段
			String token = st.nextToken();
			// 如果是特殊字符则转义，否则返回本�?
			buff.append(ESCAPE_MAP.getProperty(token, token));
		}

		return buff.toString();
	}
	/**
	 * Method name: string2InputStream <BR>
	 * Description: string2InputStream <BR>
	 * Remark: <BR>
	 * @param str
	 * @return  InputStream<BR>
	 */
	public static InputStream string2InputStream(String str){
	    ByteArrayInputStream stream;
		try {
			stream = new ByteArrayInputStream(str.getBytes("utf-8"));
			return stream;
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * Method name: inputStream2String <BR>
	 * Description: inputStream2String <BR>
	 * Remark: <BR>
	 * @param is
	 * @return
	 * @throws IOException  String<BR>
	 */
	public static String inputStream2String(InputStream is) throws IOException{
	    BufferedReader in = new BufferedReader(new InputStreamReader(is));
	    StringBuffer buffer = new StringBuffer();
	    String line = "";
	    while ((line = in.readLine()) != null){
	      buffer.append(line);
	    }
	    return buffer.toString();
	}
	
	/**
	 * Method name: isStringEmpty <BR>
	 * Description: isStringEmpty <BR>
	 * Remark: <BR>
	 * @param str
	 * @return  boolean<BR>
	 */
	public static boolean isStringEmpty(String str){
		return (str==null)||("").equals(str);
	}
	/**
	 * Method name: removeFirstAndLastOfString <BR>
	 * Description: removeFirstAndLastOfString <BR>
	 * Remark: <BR>
	 * @param str
	 * @return  String<BR>
	 */
	public static String removeFirstAndLastOfString(String str){
		return str.substring(1,str.length()-1);
	}
	public static String transferStringmap2String(Map<String,String>map){
		String str="{";
		
		if(map!=null){
			boolean firstElement=true;
			if(firstElement){
				firstElement=false;
			}else{
				str+=",";
			}
			for(String key:map.keySet()){
				String value=map.get(key);
				str+="("+key+"="+value+")";
			}
		}
		return str+"}";
	}
	
	public static List<String>transStringArr2List(String[]arr){
		List<String> stringList=new ArrayList<String>();
		for(String str:arr){
			stringList.add(str);
		}
		return stringList;
	}
}
