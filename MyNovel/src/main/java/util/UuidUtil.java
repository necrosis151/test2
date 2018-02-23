package util;

public class UuidUtil {
	public static String getUuid(){
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
}
