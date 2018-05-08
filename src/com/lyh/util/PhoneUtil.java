package com.lyh.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 电话util
 * @author lyh
 *
 */
public class PhoneUtil {
	
	/**
	 * 判断手机号码是否符合规则
	 * @param telePhoneNumber
	 * @return
	 */
	public static boolean isTelePhoneNumber(String telePhoneNumber){
		Pattern p = Pattern.compile("^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$");  
		Matcher m = p.matcher(telePhoneNumber);  
		return m.matches();
	}
	
	/** 
     * 区号+座机号码+分机号码 
     * @param fixedPhone 
     * @return 
     */  
    public static boolean isFixedPhone(String fixedPhone){  
        String reg="(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" +  
                "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";  
        return Pattern.matches(reg, fixedPhone);  
    }  
}
