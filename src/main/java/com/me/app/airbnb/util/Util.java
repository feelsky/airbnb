package com.me.app.airbnb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	//find first str
	public static String findStr(String str, String regexStr){
		//String str = "https://zh.airbnb.com/rooms/10184115?location=%E4%B8%8A%E6%B5%B7%2C%20%E4%B8%AD%E5%9B%BD&s=hkD9bNHJ";
		Pattern pat = Pattern.compile(regexStr);
		Matcher matcher = pat.matcher(str);
		if(matcher.find()){
			return matcher.group(0);
		}else{
			return "";
		}
	}
	
	public static Integer findStrToInt(String str){
		if (str != null && str != "") {
			return Integer.parseInt(Util.findStr(str, "\\d+")); 
		} else {
			return 0;
		}
	}
}
