package zyf.dao;

import java.util.List;

import zyf.pojo.DO.PermissionDO;
import zyf.query.PermissionQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:22:18
*/
public interface PermissionDao {
	
	/**
	 * 插入权限 
	 */
	int insertPermission(PermissionDO permissionDO);
	
	/**
	 * 根据id更新角色
	 */
	int updatePermissionById(PermissionDO permissionDO);
	
	/**
	 * 删除角色
	 */
	int deletePermissionById(Long id);
	
	/**
	 * 根据id查询角色
	 */
	PermissionDO selectPermissionById(Long id);
	
	/**
	 * 根据查询条件查询角色
	 */
	List<PermissionDO> selectPermissionByCondition(PermissionQuery query);
	
	/**
	 * 根据查询角色查询角色数量
	 */
	Integer countPermissionByCondition(PermissionQuery query);
	
	/**
	 * 根据用户名查询角色
	 */
	List<PermissionDO> getPermissionByRoleName(String roleName);
	
}
