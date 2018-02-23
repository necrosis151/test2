package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static int defaultage = 3600 * 24; // 缺省的生存时间
	private static String path = "/MyNovel";

	public static void addCookie(String name, String value, int age,
			HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		if (age!=0) {
			c.setMaxAge(age);
		} else {
			c.setMaxAge(defaultage);
		}

		c.setPath(path);
		response.addCookie(c);
	}

	public static String findCookie(String name, HttpServletRequest request)
			throws UnsupportedEncodingException {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals(name)) {
					value = URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
		return value;
	}

}