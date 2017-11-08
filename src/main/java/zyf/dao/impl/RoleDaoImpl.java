package zyf.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import zyf.dao.RoleDao;
import zyf.pojo.DO.RoleDO;
import zyf.query.RoleQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午8:26:24
*/
@Repository
public class RoleDaoImpl extends SqlSessionDaoSupport implements RoleDao{

	private static final String NAME_SPACE = "zyf.dao.RoleMapper.";
	
	@Resource
	@Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public int insertRole(RoleDO roleDO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRoleById(RoleDO roleDO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRoleById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleDO selectRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDO> selectRoleByCondition(RoleQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRoleByCondition(RoleQuery query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleDO getRoleByUserName(String userName) {
		return getSqlSession().selectOne(NAME_SPACE + "selectRoleByUserName", userName);
	}
	
}
