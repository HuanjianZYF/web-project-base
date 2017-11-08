package zyf.global;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Author 庄元丰
* @CreateTime 2017年11月3日下午1:58:50
*/
@ControllerAdvice
public class ExceptionHandleController {
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String exceptionHandle(Exception e) {
		if (e instanceof UnauthenticatedException) {
			return "请登录";
		}
		return "未知异常";
	}
}
