package org.sicdlab.entrepreneur.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");

	public static Date strToDate(String str) throws ParseException {
		if (str.isEmpty()) {
			return null;
		}
		str = str.replaceAll("-一月-", "-01-");
		str = str.replaceAll("-二月-", "-02-");
		str = str.replaceAll("-三月-", "-03-");
		str = str.replaceAll("-四月-", "-04-");
		str = str.replaceAll("-五月-", "-05-");
		str = str.replaceAll("-六月-", "-06-");
		str = str.replaceAll("-七月-", "-07-");
		str = str.replaceAll("-八月-", "-08-");
		str = str.replaceAll("-九月-", "-09-");
		str = str.replaceAll("-十月-", "-10-");
		str = str.replaceAll("-十一月-", "-11-");
		str = str.replaceAll("-十二月-", "-12-");
		return sdfdate.parse(str);
	}

	public static String dateToStr(Date date) {
		String str = sdfdate.format(date);
		str = str.replaceAll("-01-", "-一月-");
		str = str.replaceAll("-02-", "-二月-");
		str = str.replaceAll("-03-", "-三月-");
		str = str.replaceAll("-04-", "-四月-");
		str = str.replaceAll("-05-", "-五月-");
		str = str.replaceAll("-06-", "-六月-");
		str = str.replaceAll("-07-", "-七月-");
		str = str.replaceAll("-08-", "-八月-");
		str = str.replaceAll("-09-", "-九月-");
		str = str.replaceAll("-10-", "-十月-");
		str = str.replaceAll("-11-", "-十一月-");
		str = str.replaceAll("-12-", "-十二月-");
		return str;
	}

	public static String getCurrentTime() {
		return sdftime.format(new Date(System.currentTimeMillis()));
	}

	public static String getCurrentDate() {
		return sdfdate.format(new Date(System.currentTimeMillis()));
	}
}
