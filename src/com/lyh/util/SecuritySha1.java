package com.lyh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1 util
 * @author lyh
 *
 */
public class SecuritySha1 {

	/**
	 * 依据字符串获取SHA1后的字符串
	 * @param str
	 * @return sha1Str
	 */
	public static String getSha1(String str){
		String sha1Str = null;  
		if(str == null){
			return sha1Str;
		}
        try {  
        	MessageDigest md = MessageDigest.getInstance("SHA-1");  
            // 将字符串进行sha1加密  
            byte[] digest = md.digest(str.getBytes());  
            
            sha1Str = byteToStr(digest);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();
            return null;
        }  
		return sha1Str;
	}
	
	/** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param byteArray 
     * @return 
     */  
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
    
    /** 
     * 将字节转换为十六进制字符串 
     *  
     * @param mByte 
     * @return 
     */  
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  
}
