package zyf.service;
/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午3:48:57
*/

import java.util.List;

import zyf.pojo.DO.RoleDO;

public interface RoleService {
	
	/**
	 * 根据用户名查询角色
	 */
	List<RoleDO> getByUserName(String userName);
	
}
