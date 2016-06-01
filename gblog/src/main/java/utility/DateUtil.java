package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	private static SimpleDateFormat sdf;
	public static java.sql.Timestamp toTimeStamp(java.util.Date date) {
		java.sql.Timestamp ts = null;
		if (date != null) {
			ts = new java.sql.Timestamp(date.getTime());
		}
		return ts;
	}
	
	public static String getNowStrDate(String format){
		sdf =  new SimpleDateFormat(format);
		java.util.Date date = new java.util.Date();
		return sdf.format(date);
	}
	
}
