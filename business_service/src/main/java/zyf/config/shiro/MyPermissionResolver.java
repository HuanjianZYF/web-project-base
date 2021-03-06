package zyf.config.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午6:38:59
* 将权限字符串转化为权限实体所经过的地方，实现shiro的PermissionResolver，并配置到authorizer中
*/
public class MyPermissionResolver implements PermissionResolver{

	@Override
	public Permission resolvePermission(String permissionString) {
		return new MyPermission(permissionString);
	}
	
}
