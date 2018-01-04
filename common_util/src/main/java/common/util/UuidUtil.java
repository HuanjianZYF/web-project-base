package common.util;

import java.util.UUID;

/**
* @Author 庄元丰
* @CreateTime 2017年11月10日下午3:07:17
*/
public class UuidUtil {
	
	/**
	 * 产生一个uuid
	 */
	public static String genernateUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
