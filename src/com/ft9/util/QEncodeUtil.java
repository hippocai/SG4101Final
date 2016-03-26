/*
 * All rights Reserved, Copyright (C) GElement LIMITED 2015
 * FileName: QEncodeUtil.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name           |      Content
 * 1   | 2015�?11�?30�?        | China)caiyicheng  | original version
 */
package com.ft9.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * class name:QEncodeUtil <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2015�?11�?30�?
 * @author GElement)caiyicheng
 */
public class QEncodeUtil {

	 private final static String encoding = "UTF-8";  
	    /**
	     * AES加密
	     * 
	     * @param content
	     * @param password
	     * @return
	     * @throws BadPaddingException 
	     * @throws IllegalBlockSizeException 
	     * @throws UnsupportedEncodingException 
	     * @throws NoSuchPaddingException 
	     * @throws NoSuchAlgorithmException 
	     * @throws InvalidKeyException 
	     */ 
	    public static String encryptAES(String content, String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException { 
	        if(content==null||("").equals(content)){
	        	return "";
	        }
	    	byte[] encryptResult = encrypt(content, password); 
	        String encryptResultStr = parseByte2HexStr(encryptResult); 
	        // BASE64位加�? 
	        encryptResultStr = ebotongEncrypto(encryptResultStr); 
	        return encryptResultStr; 
	    } 
	    
	    public static String encryptAESWithRawData(String content, String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException { 
	        if(content==null||("").equals(content)){
	        	return "";
	        }
	    	byte[] encryptResult = encrypt(content, password); 
	        String encryptResultStr = new String(encryptResult,"utf-8"); 
	        // BASE64位加�? 
	        encryptResultStr = ebotongEncrypto(encryptResultStr); 
	        return encryptResultStr; 
	    } 
	 
	    public static String decryptAesWithRawData(String encryptResultStr, String password) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException { 
	        // BASE64位解�? 
	    	if(encryptResultStr==null|("").equals(encryptResultStr)){
	    		return "";
	    	}
	        String decrpt = ebotongDecrypto(encryptResultStr); 
	        byte[] decryptFrom = decrpt.getBytes("utf-8"); 
	        byte[] decryptResult = decrypt(decryptFrom, password); 
	        return new String(decryptResult,encoding); 
	    } 
	    /**
	     * AES解密
	     * 
	     * @param encryptResultStr
	     * @param password
	     * @return
	     * @throws UnsupportedEncodingException 
	     * @throws BadPaddingException 
	     * @throws IllegalBlockSizeException 
	     * @throws NoSuchPaddingException 
	     * @throws NoSuchAlgorithmException 
	     * @throws InvalidKeyException 
	     */ 
	    public static String decrypt(String encryptResultStr, String password) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException { 
	        // BASE64位解�? 
	    	if(encryptResultStr==null|("").equals(encryptResultStr)){
	    		return "";
	    	}
	        String decrpt = ebotongDecrypto(encryptResultStr); 
	        byte[] decryptFrom = parseHexStr2Byte(decrpt); 
	        byte[] decryptResult = decrypt(decryptFrom, password); 
	        return new String(decryptResult,encoding); 
	    } 
	 
	        /**
	     * 加密字符�?
	     */ 
	    public static String ebotongEncrypto(String str) { 
	        BASE64Encoder base64encoder = new BASE64Encoder(); 
	        String result = str; 
	        if (str != null && str.length() > 0) { 
	            try { 
	                byte[] encodeByte = str.getBytes(encoding); 
	                result = base64encoder.encode(encodeByte); 
	            } catch (Exception e) { 
	                e.printStackTrace(); 
	            } 
	        } 
	        //base64加密超过�?定长度会自动换行 �?要去除换行符 
	        return result.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", ""); 
	    } 
	 
	    /**
	     * 解密字符�?
	     */ 
	    public static String ebotongDecrypto(String str) { 
	        BASE64Decoder base64decoder = new BASE64Decoder(); 
	        try { 
	            byte[] encodeByte = base64decoder.decodeBuffer(str); 
	            return new String(encodeByte,encoding); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	            return str; 
	        } 
	    } 
	    /**  
	     * 加密  
	     *   
	     * @param content �?要加密的内容  
	     * @param password  加密密码  
	     * @return  
	     * @throws NoSuchAlgorithmException 
	     * @throws NoSuchPaddingException 
	     * @throws InvalidKeyException 
	     * @throws UnsupportedEncodingException 
	     * @throws BadPaddingException 
	     * @throws IllegalBlockSizeException 
	     */   
	    private static byte[] encrypt(String content, String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {                  
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			// 防止linux�? 随机生成key
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			// kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码�?
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始�?
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
	         
	    }   
	 
	 
	    /**解密  
	     * @param content  待解密内�?  
	     * @param password 解密密钥  
	     * @return  
	     * @throws NoSuchAlgorithmException 
	     * @throws NoSuchPaddingException 
	     * @throws InvalidKeyException 
	     * @throws BadPaddingException 
	     * @throws IllegalBlockSizeException 
	     */   
	    private static byte[] decrypt(byte[] content, String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {    
	    	KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	    	//防止linux�? 随机生成key 
	    	SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );    
	    	secureRandom.setSeed(password.getBytes());    
	    	kgen.init(128, secureRandom); 
	    	//kgen.init(128, new SecureRandom(password.getBytes()));    
	    	SecretKey secretKey = kgen.generateKey();    
	    	byte[] enCodeFormat = secretKey.getEncoded();    
	    	SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");                
	    	Cipher cipher = Cipher.getInstance("AES");// 创建密码�?    
	    	cipher.init(Cipher.DECRYPT_MODE, key);// 初始�?    
	    	byte[] result = cipher.doFinal(content);    
	    	return result; // 加密    
	    }   
	 
	    /**将二进制转换�?16进制  
	     * @param buf  
	     * @return  
	     */   
	    public static String parseByte2HexStr(byte buf[]) {    
	            StringBuffer sb = new StringBuffer();    
	            for (int i = 0; i < buf.length; i++) {    
	                    String hex = Integer.toHexString(buf[i] & 0xFF);    
	                    if (hex.length() == 1) {    
	                            hex = '0' + hex;    
	                    }    
	                    sb.append(hex.toUpperCase());    
	            }    
	            return sb.toString();    
	    }   
	 
	 
	    /**�?16进制转换为二进制  
	     * @param hexStr  
	     * @return  
	     */   
	    public static byte[] parseHexStr2Byte(String hexStr) {    
	            if (hexStr.length() < 1)    
	                    return null;    
	            byte[] result = new byte[hexStr.length()/2];    
	            for (int i = 0;i< hexStr.length()/2; i++) {    
	                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);    
	                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);    
	                    result[i] = (byte) (high * 16 + low);    
	            }    
	            return result;    
	    }   
}
