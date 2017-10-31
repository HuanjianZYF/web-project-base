package zyf.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import zyf.dao.PersonDao;
import zyf.pojo.DO.PersonDO;
import zyf.query.PersonQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午3:14:12
*/
@Repository
public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDao {
	
	private static final String NAME_SPACE = "zyf.dao.PersonMapper.";
	
	@Resource
	@Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	public int insertPerson(PersonDO personDO) {
		return getSqlSession().insert(NAME_SPACE + "insertPerson", personDO);
	}

	//底层接口不判 personDO 空了
	public int updatePerson(Long id, PersonDO personDO) {		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", personDO.getName());
		map.put("age", personDO.getAge());
		return getSqlSession().update(NAME_SPACE + "updatePerson", map);
	}

	public int deletePerson(Long id) {
		return getSqlSession().update(NAME_SPACE + "deletePerson", id);
	}

	public PersonDO getPersonById(Long id) {
		return getSqlSession().selectOne(NAME_SPACE + "selectPersonById", id);
	}

	public List<PersonDO> getPersonByCondition(PersonQuery personQuery) {
		return getSqlSession().selectList(NAME_SPACE + "selectPersonByCondition", personQuery);
	}

	public Integer countPersonByCondition(PersonQuery personQuery) {
		Integer count = getSqlSession().selectOne(NAME_SPACE + "countPersonByCondition", personQuery);
		return count == null ? 0 :count;
	}
	
}
