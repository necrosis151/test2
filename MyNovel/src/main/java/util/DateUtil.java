package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static String defaulttype = "yyyy-MM-dd";

	public static String getStringDateByType(Date date, String type) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		return simpleDateFormat.format(date);
	}

	public static String getDefaultStringDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaulttype);
		return simpleDateFormat.format(new Date());
	}

	public static void main(String[] args) {
		// System.out.println(dateFormat(new Date(), "yMd-h-mm-s"));
		String aaa = "dasda.txt";
		System.out.println(aaa.substring(aaa.indexOf(".") + 1));
	}
}
