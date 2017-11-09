package zyf.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
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
	public String exceptionHandle(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
		if (e instanceof UnauthenticatedException) {
			request.getRequestDispatcher("/api/login").forward(request, response);
		}
		if (e instanceof AuthorizationException) {
			return "您没有该操作的权限";
		}
		e.printStackTrace();
		return "未知异常";
	}
}
