package common.util;
/**
* @Author 庄元丰
* @CreateTime 2017年11月10日下午1:42:14
* 字符串工具类
*/
public class StringUtil {
	
	/**
	 * 空字符串
	 */
	public static final String EMPTY = "";
	
	/**
	 * 数组分隔符
	 */
	public static final String ARRAY_SEPERATE = ",";
	
	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	/**
	 * 判断字符串是否非空
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.length() > 0;
	}
	
	/**
	 * 判断两个字符串是否相等
	 */
	public static boolean isEquals(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equals(s2);
	}
	
	/**
	 * 移除字符串两端的空格
	 */
	public static String trim(String str) {
		return str == null ? null : str.trim();
	}
	
	/**
	 * 反转字符串
	 */
	public static String reverse(String str) {
		if (str == null) {
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}
	
	/**
	 * 将字符串变成大写
	 */
	public static String upperCase(String str) {
		return str == null ? null : str.toUpperCase();
	}
	
	/**
	 * 将字符串变小写
	 */
	public static String lowerCase(String str) {
		return str == null ? null : str.toLowerCase();
	}
	
	/**
	 * 从左边截取字符串指定长度
	 */
	public static String left(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len <= 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(0, len);
	}
	
	/**
	 * 从右边截取字符串指定长度
	 */
	public static String right(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len <= 0) {
			return EMPTY;
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}
	
	/**
	 * 判断字符串是否只有数字
	 * 如果是空字符串 返回false
	 */
	public static boolean isNumeric(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否只有unicode字符（中英文）
	 * 数字不算unicode字符
	 */
	public static boolean isAlpha(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否只有数字或unicode字符
	 */
	public static boolean isAlphaNumeric(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否只有数字，unicode字符或者空格
	 */
	public static boolean isAlphaNumericSpace(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetterOrDigit(str.charAt(i)) && !Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 数组的类似toString，方便调试看
	 */
	public static <T> String array2Str(T[] ts) {
		if (CommonUtil.isEmpty(ts)) {
			return EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (T t : ts) {
			sb.append(t.toString());
			sb.append(ARRAY_SEPERATE);
		}
		
		return sb.toString();
	}
	
	/**
	 * 数组的toString
	 */
	public static String array2Str(int[] ints) {
		if (ints.length == 0) {
			return EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (int t : ints) {
			sb.append(t);
			sb.append(ARRAY_SEPERATE);
		}
		
		return sb.toString();
	}
	
	/**
	 * 数组的toString
	 */
	public static String array2Str(long[] longs) {
		if (longs.length == 0) {
			return EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (long t : longs) {
			sb.append(t);
			sb.append(ARRAY_SEPERATE);
		}
		
		return sb.toString();
	}
	
	/**
	 * 数组的toString
	 */
	public static String array2Str(double[] doubles) {
		if (doubles.length == 0) {
			return EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (double t : doubles) {
			sb.append(t);
			sb.append(ARRAY_SEPERATE);
		}
		
		return sb.toString();
	}
	
	/**
	 * 字符串首字母大写
	 */
	public static String first2UpperCase(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() == 0) {
			return EMPTY;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(Character.toUpperCase(str.charAt(0)));
		builder.append(right(str, str.length() - 1));
		
		return builder.toString();
	}
}
