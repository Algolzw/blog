package utility;

public class DataUtil {
	public static boolean isEmptyString(String value) {
		return value == null || value.equals("");
	}

	public static boolean isEmptyString(Object value) {
		return value == null || value.toString().equals("");
	}
}
