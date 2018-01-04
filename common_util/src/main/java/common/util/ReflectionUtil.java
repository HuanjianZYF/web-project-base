package common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
* @Author 庄元丰
* @CreateTime 2017年11月13日下午3:45:43
* 关于java反射的一个工具类
*/
public class ReflectionUtil {
	
	/**
	 * 执行一个javaBean的get方法
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * 
	 */
	public static <T> Object doGetMethod(T t, String fieldName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		fieldName = StringUtil.first2UpperCase(fieldName);
		Method method = t.getClass().getMethod("get" + fieldName);
		Object o = method.invoke(t);
		return o;
	}
	
	
}
