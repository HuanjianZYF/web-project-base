package zyf.service;
/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:31:19
*/

import java.util.List;

import zyf.pojo.DO.PermissionDO;

public interface PermissionService {
	
	/**
	 * 根据角色名查询角色权限
	 */
	List<PermissionDO> getByRoleName(String roleName);
}
