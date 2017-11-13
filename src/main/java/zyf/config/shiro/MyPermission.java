package zyf.config.shiro;

import org.apache.shiro.authz.Permission;


/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午6:37:20
* Permission实体类，每一个权限都是一个shiro提供的Permission接口的实现类
*/
public class MyPermission implements Permission{

	private String permissionStr;
	
	public MyPermission(String str) {
		this.permissionStr = str;
	}

	public boolean implies(Permission p) {
		if (!(p instanceof MyPermission)) {
			return false;
		}
		
		if (((MyPermission)p).getPermissionStr().equals(permissionStr)) {
			return true;
		}
		
		return false;
	}

	public String getPermissionStr() {
		return permissionStr;
	}

	public void setPermissionStr(String permissionStr) {
		this.permissionStr = permissionStr;
	}
	
}
