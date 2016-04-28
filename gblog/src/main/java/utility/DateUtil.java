package utility;

public class DateUtil {
	public static java.sql.Timestamp toTimeStamp(java.util.Date date) {
		java.sql.Timestamp ts = null;
		if (date != null) {
			ts = new java.sql.Timestamp(date.getTime());
		}
		return ts;
	}
	
}
