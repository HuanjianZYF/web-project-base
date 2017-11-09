package zyf.controller.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author 庄元丰
* @CreateTime 2017年11月3日下午2:13:49
*/
@RestController
public class LoginController {
	
	@RequestMapping(value="login")
	public String login() {
		Subject currentUser = SecurityUtils.getSubject();
		
	    UsernamePasswordToken token = new UsernamePasswordToken("zyf", "123456");  
	    try {  
	        currentUser.login(token);  
	    } catch (AuthenticationException e) {  
	    	System.out.println("登录失败");
	    }  
	    
		return "ok";
	}
	
	@RequestMapping("unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}
	
}
