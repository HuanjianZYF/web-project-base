package zyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Author 庄元丰
* @CreateTime 2017年11月10日下午7:55:03
*/
public class HelloWorld {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.info("hello,world!");
		logger.debug("wss");
		logger.error("122");
		logger.trace("222");

	}
}
