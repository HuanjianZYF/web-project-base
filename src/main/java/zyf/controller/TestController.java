package zyf.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import zyf.helper.ResultCodeEnum;
import zyf.util.ResultUtil;

/**
* @Author 庄元丰
* @CreateTime 2017年10月20日上午10:28:14
*/
@RestController
public class TestController {
	
	@RequestMapping("test")
	public String test() {
		return JSON.toJSONString(ResultUtil.buildSuccessResult(ResultCodeEnum.UNKNOWN_ERROR));
	}
	
	@RequiresRoles(value="admin")
	@RequestMapping("test2")
	public String test2() {
		return "test2";
	}
	
}
