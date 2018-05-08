package com.lyh.util;

/**
 * RateUtil
 * @author lyh
 *
 */
public class RateUtil {

	
	public static float getPercent(int number, int total){
		if(total <= 0){
			return 0.0f;
		}
		return (float)((number*1000)/total)/10;
	}
}
