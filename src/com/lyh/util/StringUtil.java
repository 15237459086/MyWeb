package com.lyh.util;

import java.util.UUID;

/**
 * StringUtil
 * @author lyh
 *
 */
public class StringUtil {

	/**
	 * BLANK str
	 */
	public static final String BLANK=" ";
	
	/**
	 * str is empty ?
	 * @param str
	 * @return true/false
	 */
	public static boolean isEmpty(String str){
		if(str == null){
			return true;
		}
		str = str.trim();
		if(str.length() <= 0){
			return true;
		}
		return false;
	}
	
	/**
	 * remove Blank
	 * @param str
	 * @return str
	 */
	public static String removeBlank(String str){
		if(isEmpty(str)){
			return null;
		}
		return str.replaceAll(" ", "");
	}
	
	/**
	 * remove special character
	 * @param str
	 * @return str
	 */
	public static String removeSpecialChar(String str){
		if(isEmpty(str)){
			return null;
		}
		return str.replaceAll("\\s", "");
	}
	
	/**
	 * 获得UniqId
	 * 
	 */
	public static String getUUId() {
	    String id = UUID.randomUUID().toString();
	    id = id.replaceAll("-", "");
	    return id;
	}
	  
	
	/**
	   * 获得UniqId
	   * 
	   */
	  public static String getId() {
	    String id = UUID.randomUUID().toString();
	    id = id.replaceAll("-", "");
	    return id;
	  }
	/**
	 * 验证字符串类型的参数是否不为�?
	 *
	 *
	 * @param strs
	 * @return boolean 多个同时不为�? true
	*/
	public static boolean isNotEmpty(String... strs) {
		boolean b = false;
	    if (strs == null) {
	      b = false;
	    } else {
	      b = true;
	      for (String str : strs) {
	        b = b && !isEmpty(str);
	      }
	    }
	    return b;
	}
	
	public static String meaningStr(String str){
		  if(str == null){
			  return null;
		  }else{
			  if(str.trim().length() >0){
				  return str.trim();
			  }
			  return null;
		  }
	  }
}
