package zyf.dao;

import java.util.List;

import zyf.pojo.DO.UserDO;
import zyf.query.UserQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日上午10:32:46
*/
public interface UserDao {
	/**
	 * 插入一个user
	 */
	int insertUser(UserDO userDO);
	
	/**
	 * 修改一个user
	 */
	int updateUserById(UserDO userDO);
	
	/**
	 * 删除一个User
	 */
	int deleteUser(Long id);
	
	/**
	 * 根据id查询User
	 */
	UserDO getUserById(Long id);
	
	/**
	 * 根据查询条件查询User
	 */
	List<UserDO> getUserByCondition(UserQuery userQuery);
	
	/**
	 * 根据查询条件查询记录数
	 */
	Integer countUserByCondition(UserQuery userQuery);
	
	/**
	 * 根据手机号查询
	 */
	UserDO getByPhone(String phone);
}
