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



public class StringUtil {
	


	private static final String SPECIAL_CHARACTERS = "\n\r\f\'\"\\";

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
		if (text == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder(text.length() + 16);
		StringTokenizer st = new StringTokenizer(text.toString(),
				SPECIAL_CHARACTERS, true);

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			buff.append(ESCAPE_MAP.getProperty(token, token));
		}

		return buff.toString();
	}
	public static InputStream string2InputStream(String str){
	    ByteArrayInputStream stream;
		try {
			stream = new ByteArrayInputStream(str.getBytes("utf-8"));
			return stream;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return null;
	}
	
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
