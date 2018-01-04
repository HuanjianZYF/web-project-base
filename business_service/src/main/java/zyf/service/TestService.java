package zyf.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午4:23:05
*/
@Service
public class TestService {
	
	@RequiresRoles("worker")
	public String f() {
		return "sss";
	}
}
