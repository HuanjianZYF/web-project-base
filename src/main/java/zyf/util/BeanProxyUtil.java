package zyf.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午2:56:46
*/
public class BeanProxyUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanProxyUtil.applicationContext = applicationContext;
	}
	
	/**
	 * 根据类型得到bean
	 */
	public static <T> T getBean(Class<T> t) {
		return (T)applicationContext.getBean(t);
	}
	
	/**
	 * 根据bean名得到bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName, Class<T> t) {
		return (T)applicationContext.getBean(beanName);
	}

}
