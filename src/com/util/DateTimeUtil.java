package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	// �ַ���ת��ΪDate
	public static Date convertDate(String dateStr) {
		if(StringUtil.isNullOrEmpty(dateStr)){
			return null;
		}
		
		Date d = null;
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;
	}
	
	// Dateת��Ϊʱ���ַ���
	public static String convertDate(Date date) {
		if(null==date){
			return "";
		}
/*		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
	return sdf.format(date);
	}
	
	public static Date convertDateNoTime(String dateStr) {
		if(StringUtil.isNullOrEmpty(dateStr)){
			return null;
		}
		
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;
	}
	
	public static String convertDateNoTime(Date date) {
		if(null==date){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
