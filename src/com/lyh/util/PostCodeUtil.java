package com.lyh.util;

import java.util.regex.Pattern;

/**
 * 
 * 邮编Util
 * @author lyh
 *
 */
public class PostCodeUtil {

	/**  
     * 匹配中国邮政编码  
     * @param postcode 邮政编码  
     * @return 验证成功返回true，验证失败返回false  
     */   
    public static boolean isPostCode(String postCode){  
        String reg = "[1-9]\\d{5}";  
        return Pattern.matches(reg, postCode);  
    }  
}
