package zyf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author 庄元丰
* @CreateTime 2017年10月20日上午10:28:14
*/
@RestController
public class TestController {
	
	@RequestMapping("test")
	public String test() {
		return "test";
	}
}
