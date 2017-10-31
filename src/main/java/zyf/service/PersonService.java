package zyf.service;
/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午4:00:07
*/

import zyf.pojo.DO.PersonDO;

public interface PersonService {
	
	/**
	 * 根据id查询Person
	 */
	PersonDO getPersonById(Long id);
	
}
