package zyf.config.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;

import zyf.pojo.DO.PermissionDO;
import zyf.service.PermissionService;
import zyf.util.CommonUtil;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:04:51
*/
public class MyRolePermissionResolver implements RolePermissionResolver{

	@Resource
	private PermissionService permissionService;
	
	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		List<Permission> resultPermissionList = new ArrayList<Permission>();
		
		List<PermissionDO> permissionList = permissionService.getByRoleName(roleString);
		if (CommonUtil.isNotEmpty(permissionList)) {
			for (PermissionDO permission : permissionList) {
				resultPermissionList.add(new MyPermission(permission.getPermission()));
			}
		}
		
		return resultPermissionList;
	}
	
}
