package zyf.config.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午6:38:59
*/
public class MyPermissionResolver implements PermissionResolver{

	@Override
	public Permission resolvePermission(String permissionString) {
		return new MyPermission(permissionString);
	}
	
}
