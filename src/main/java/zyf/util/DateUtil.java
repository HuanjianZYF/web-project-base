package zyf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* @Author 庄元丰
* @CreateTime 2017年11月10日上午11:21:17
* 关于时间的一些工具方法
*/
public class DateUtil {
	
	/**
	 * 一秒
	 */
	public static final long ONE_SECOND = 1000L;
	
	/**
	 * 一分
	 */
	public static final long ONE_MINUTE = 60 * 1000L;
	
	/**
	 * 一小时
	 */
	public static final long ONE_HOUR = 60 * 60 * 1000L;
	
	/**
	 * 一天
	 */
	public static final long ONE_DAY = 24 * 60 * 60 * 1000L;
	
	/**
	 * 获取当前时间对应的年份
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取当前时间对应的月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取当前时间对应的日
	 */
	public static int getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.DATE);
	}
	
	/**
	 * 获取当前时间对应的时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.HOUR);
	}
	
	/**
	 * 获取当前时间对应的分
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.MINUTE);
	}
	
	/**
	 * 获取当前时间对应的秒
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.SECOND);
	}
	
	/**
	 * 计算两个时间的毫秒差
	 */
	public static final long getMillisDiff(Date date1, Date date2) {
		return date1.getTime() - date2.getTime();
	}
	
	/**
	 * 获取两个日期之间的秒数差
	 */
	public static long getSecondDiff(Date date1, Date date2) {
		return getMillisDiff(date1, date2) / ONE_SECOND;
	}
	
	/**
	 * 获取两个日期之间的分钟差
	 */
	public static long getMinuteDiff(Date date1, Date date2) {
		return getMillisDiff(date1, date2) / ONE_MINUTE;
	}
	
	/**
	 * 获取两个日期之间的小时差
	 */
	public static long getHourDiff(Date date1, Date date2) {
		return getMillisDiff(date1, date2) / ONE_HOUR;
	}
	
	/**
	 * 获取两个日期之间的天数差
	 */
	public static long getDateDiff(Date date1, Date date2) {
		return getMillisDiff(date1, date2) / ONE_DAY;
	}
	
	/**
	 * 将时间转换为自定义的格式
	 */
	public static String toDateStringWithCustomFormat(Date date, String formatStr) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		
		return format.format(date);
	}
	
	/**
	 * 将自定义的时间格式转换为Date
	 */
	public static Date transDateStringToDate(String dateStrFmt, String dateStr) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(dateStrFmt);
		
		return format.parse(dateStr);
	}
	
	/**
	 * 将一个时间+amount秒
	 */
	public static Date addSecond(Date date, int amount) {
		return new Date(date.getTime() + ONE_SECOND * amount);
	}
	
	/**
	 * 将一个时间+amount分钟
	 */
	public static Date addMinute(Date date, int amount) {
		return new Date(date.getTime() + ONE_MINUTE * amount);
	}
	
	/**
	 * 将一个时间+amount小时
	 */
	public static Date addHour(Date date, int amount) {
		return new Date(date.getTime() + ONE_HOUR * amount);
	}
	
	/**
	 * 将一个时间+amount天
	 */
	public static Date addDay(Date date, int amount) {
		return new Date(date.getTime() + ONE_DAY * amount);
	}
	
	/**
	 * 获取指定的时间，传入年月日时分秒
	 */
	public static Date getSpecifiedDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, hour, minute, second);
		
		return calendar.getTime();
	}
	
	/**
	 * 获取指定的时间，传入年月日
	 */
	public static Date getSpecifiedDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		
		return calendar.getTime();
	}
}
