package zyf.util;
/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午2:38:44
*/

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtil.class);
	
	private static final Properties PROPERTIES = new Properties();
	
	static {
		load("/properties/application.properties");
	}
	
	private static void load(String path) {
		InputStream in = PropertyUtil.class.getResourceAsStream(path);
		
		if (in != null) {
			try {
				PROPERTIES.load(in);
			} catch(IOException e) {
				LOGGER.error("配置文件读取失败");
			}
		}
	}
	
	/**
	 * 得到一个属性值
	 */
	public static String getProperty(String propertyName) {
		return StringUtil.trim(PROPERTIES.getProperty(propertyName));
	}
}
