package zyf.dao;

import java.util.List;

import zyf.pojo.DO.PersonDO;
import zyf.query.PersonQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午3:00:46
*/
public interface PersonDao {
	
	/**
	 * 插入一个person
	 */
	int insertPerson(PersonDO personDO);
	
	/**
	 * 修改一个Person
	 */
	int updatePerson(Long id, PersonDO personDO);
	
	/**
	 * 删除一个Person
	 */
	int deletePerson(Long id);
	
	/**
	 * 根据id查询Person
	 */
	PersonDO getPersonById(Long id);
	
	/**
	 * 根据查询条件查询Person
	 */
	List<PersonDO> getPersonByCondition(PersonQuery personQuery);
	
	/**
	 * 根据查询条件查询记录数
	 */
	Integer countPersonByCondition(PersonQuery personQuery);
}
