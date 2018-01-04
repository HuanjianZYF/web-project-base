package zyf.dao;

import java.util.List;

import zyf.pojo.DO.RoleDO;
import zyf.query.RoleQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午8:19:35
*/
public interface RoleDao {
	
	/**
	 * 插入角色 
	 */
	int insertRole(RoleDO roleDO);
	
	/**
	 * 根据id更新角色
	 */
	int updateRoleById(RoleDO roleDO);
	
	/**
	 * 删除角色
	 */
	int deleteRoleById(Long id);
	
	/**
	 * 根据id查询角色
	 */
	RoleDO selectRoleById(Long id);
	
	/**
	 * 根据查询条件查询角色
	 */
	List<RoleDO> selectRoleByCondition(RoleQuery query);
	
	/**
	 * 根据查询角色查询角色数量
	 */
	int countRoleByCondition(RoleQuery query);
	
	/**
	 * 根据用户名查询角色
	 */
	List<RoleDO> getRoleByPhone(String phone);
	
}	
