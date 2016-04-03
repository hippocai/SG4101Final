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

public class QEncodeUtil {

	 private final static String encoding = "UTF-8";  
	    public static String encryptAES(String content, String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException { 
	        if(content==null||("").equals(content)){
	        	return "";
	        }
	    	byte[] encryptResult = encrypt(content, password); 
	        String encryptResultStr = parseByte2HexStr(encryptResult); 
	        encryptResultStr = ebotongEncrypto(encryptResultStr); 
	        return encryptResultStr; 
	    } 
	    
	    public static String encryptAESWithRawData(String content, String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException { 
	        if(content==null||("").equals(content)){
	        	return "";
	        }
	    	byte[] encryptResult = encrypt(content, password); 
	        String encryptResultStr = new String(encryptResult,"utf-8"); 
	        encryptResultStr = ebotongEncrypto(encryptResultStr); 
	        return encryptResultStr; 
	    } 
	 
	    public static String decryptAesWithRawData(String encryptResultStr, String password) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException { 
	    	if(encryptResultStr==null|("").equals(encryptResultStr)){
	    		return "";
	    	}
	        String decrpt = ebotongDecrypto(encryptResultStr); 
	        byte[] decryptFrom = decrpt.getBytes("utf-8"); 
	        byte[] decryptResult = decrypt(decryptFrom, password); 
	        return new String(decryptResult,encoding); 
	    } 
	    public static String decrypt(String encryptResultStr, String password) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException { 
	    	if(encryptResultStr==null|("").equals(encryptResultStr)){
	    		return "";
	    	}
	        String decrpt = ebotongDecrypto(encryptResultStr); 
	        byte[] decryptFrom = parseHexStr2Byte(decrpt); 
	        byte[] decryptResult = decrypt(decryptFrom, password); 
	        return new String(decryptResult,encoding); 
	    } 
	 
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
	        return result.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", ""); 
	    } 
	 
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
	    private static byte[] encrypt(String content, String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {                  
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(byteContent);
			return result; 
	         
	    }   
	 
	 
	    private static byte[] decrypt(byte[] content, String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {    
	    	KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	    	SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );    
	    	secureRandom.setSeed(password.getBytes());    
	    	kgen.init(128, secureRandom); 
	    	SecretKey secretKey = kgen.generateKey();    
	    	byte[] enCodeFormat = secretKey.getEncoded();    
	    	SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");                
	    	Cipher cipher = Cipher.getInstance("AES");    
	    	cipher.init(Cipher.DECRYPT_MODE, key);    
	    	byte[] result = cipher.doFinal(content);    
	    	return result;    
	    }   
	 
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
