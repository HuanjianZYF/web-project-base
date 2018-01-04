package zyf.service;
/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午3:46:00
*/

import zyf.pojo.DO.UserDO;

public interface UserService {
	
	/**
	 * 根据用户名查询用户
	 */
	UserDO getByPhone(String phone);
	
}
