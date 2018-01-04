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
		return getSqlSession().insert(NAME_SPACE + "insertRole", roleDO);
	}

	@Override
	public int updateRoleById(RoleDO roleDO) {
		return getSqlSession().update(NAME_SPACE + "updateRoleById", roleDO);
	}

	@Override
	public int deleteRoleById(Long id) {
		return getSqlSession().update(NAME_SPACE + "deleteRole", id);
	}

	@Override
	public RoleDO selectRoleById(Long id) {
		return getSqlSession().selectOne(NAME_SPACE + "selectRoleById", id);
	}

	@Override
	public List<RoleDO> selectRoleByCondition(RoleQuery query) {
		return getSqlSession().selectList(NAME_SPACE + "selectRoleByCondition", query);
	}

	@Override
	public int countRoleByCondition(RoleQuery query) {
		Integer count = getSqlSession().selectOne(NAME_SPACE + "countRoleByCondition", query);
		return count == null ? 0 : count;
	}

	@Override
	public List<RoleDO> getRoleByPhone(String phone) {
		return getSqlSession().selectList(NAME_SPACE + "getRoleByPhone", phone);
	}
	
}
