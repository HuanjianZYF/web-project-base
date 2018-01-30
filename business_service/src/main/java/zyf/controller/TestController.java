package zyf.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import zyf.service.TestService;

/**
* @Author 庄元丰
* @CreateTime 2017年10月20日上午10:28:14
*/
@RestController
public class TestController {
	
	@Resource
	private TestService testService;
	
	@RequestMapping("test")
	@RequiresAuthentication
	public String test() {
		return "test";
	}
	
	@RequiresRoles(value="admin")
	@RequestMapping("test2")
	public String test2() {
		return "test2";
	}
	
	@RequiresRoles(value="user")
	@RequestMapping("test3")
	public String test3() {
		return "test3";
	}
	
	@RequestMapping("test4")
	public String test4() {
		return "test44";
	}
	
	@RequiresPermissions("a:b:c:d")
	@RequestMapping("test5")
	public String test5() {
		return "test5";
	}
	
	@RequestMapping("test6")
	public String test6() {
		return JSON.toJSONString(testService.f());
	}
}
