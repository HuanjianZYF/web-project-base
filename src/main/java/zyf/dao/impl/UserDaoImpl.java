package zyf.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import zyf.dao.UserDao;
import zyf.pojo.DO.UserDO;
import zyf.query.UserQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日上午10:37:16
*/
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	private static final String NAME_SPACE = "zyf.dao.UserMapper.";
	
	@Resource
	@Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public int insertUser(UserDO userDO) {
		return getSqlSession().insert(NAME_SPACE + "insertUser", userDO);		
	}

	@Override
	public int updateUserById(UserDO userDO) {
		return getSqlSession().update(NAME_SPACE + "updateUserById", userDO);
	}

	@Override
	public int deleteUser(Long id) {
		return getSqlSession().update(NAME_SPACE + "deleteUser", id);
	}

	@Override
	public UserDO getUserById(Long id) {
		return getSqlSession().selectOne(NAME_SPACE + "selectUserById", id);
	}

	@Override
	public List<UserDO> getUserByCondition(UserQuery userQuery) {	
		return getSqlSession().selectList(NAME_SPACE + "selectUserByCondition", userQuery);
	}

	@Override
	public Integer countUserByCondition(UserQuery userQuery) {
		return getSqlSession().selectOne(NAME_SPACE + "countUserByCondition", userQuery);
	}

	@Override
	public UserDO getByUserName(String userName) {		
		return getSqlSession().selectOne(NAME_SPACE + "selectUserByUserName", userName);
	}
	
	
}
