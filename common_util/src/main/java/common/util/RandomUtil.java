package common.util;

import java.util.concurrent.ThreadLocalRandom;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午2:11:09
*/
public class RandomUtil {
	
	/**
	 * 生成6位随机数字作为验证码
	 */
	public static String generateSixNum() {
		return new Integer(100000 + ThreadLocalRandom.current().nextInt(899999)).toString();
	}
}
