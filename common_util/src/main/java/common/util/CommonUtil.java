package common.util;

import java.util.Collection;
import java.util.Map;

/**
* @Author 庄元丰
* @CreateTime 2017年11月6日上午9:46:58
*/
public class CommonUtil {
	
	/**
	 * 判断一个集合是否为空
	 */
	public static <T> boolean isEmpty(Collection<T> collection) {
		return collection == null || collection.size() == 0;
	}
	
	/**
	 * 判断一个集合是否非空
	 */
	public static <T> boolean isNotEmpty(Collection<T> collection) {
		return collection != null && collection.size() != 0;
	}
	
	/**
	 * 判断一个数组是否为空
	 */
	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 判断一个数组非空
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return array != null && array.length != 0;
	}
	
	/**
	 * 判断一个map为空
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return map == null || map.size() == 0;
	}
	
	/**
	 * 判断一个map非空
	 */
	public static <K, V> boolean isNotEmpty(Map<K, V> map) {
		return map != null && map.size() != 0;
	}
	
}
