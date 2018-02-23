package util;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.myNovel.model.User;

public class JsonUtil {
	private static Gson gson = new Gson();

	/**
	 * @MethodName : toJson
	 * @Description : 将对象转为JSON串，此方法能够满足大部分需求
	 * @param src
	 *            :将要被转化的对象
	 * @return :转化后的JSON串
	 */
	public static String toJson(Object src) {
		 if (src == null) {
		 return gson.toJson(JsonNull.INSTANCE);
		 }
		return gson.toJson(src);
	}

	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setUsername("fadfa");
		user.setPassword("null");
		user.setFaceimage("fafa");
		String value=toJson(user);
		System.out.println(value);
		User user2 =gson.fromJson(value, User.class);
		if (user2.getPassword()==null) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
	}
}
