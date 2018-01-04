package zyf.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import zyf.dao.PermissionDao;
import zyf.pojo.DO.PermissionDO;
import zyf.query.PermissionQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:24:46
*/
@Repository
public class PermissionDaoImpl extends SqlSessionDaoSupport implements PermissionDao{

	private static final String NAME_SPACE = "zyf.dao.PermissionMapper.";
	
	@Resource
	@Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public int insertPermission(PermissionDO permissionDO) {
		return getSqlSession().insert(NAME_SPACE + "insertPermission", permissionDO);
	}

	@Override
	public int updatePermissionById(PermissionDO permissionDO) {
		return getSqlSession().update(NAME_SPACE + "updatePermissionById", permissionDO);
	}

	@Override
	public int deletePermissionById(Long id) {
		return getSqlSession().update(NAME_SPACE + "deletePermission", id);
	}

	@Override
	public PermissionDO selectPermissionById(Long id) {
		return getSqlSession().selectOne(NAME_SPACE + "selectPermissionById", id);
	}

	@Override
	public List<PermissionDO> selectPermissionByCondition(PermissionQuery query) {
		return getSqlSession().selectList(NAME_SPACE + "selectPermissionByCondition", query);
	}

	@Override
	public Integer countPermissionByCondition(PermissionQuery query) {
		Integer count = getSqlSession().selectOne(NAME_SPACE + "countPermissionByCondition", query);
		return count == null ? 0 : count;
	}

	@Override
	public List<PermissionDO> getPermissionByRoleName(String roleName) {
		return getSqlSession().selectList(NAME_SPACE + "selectPermissionByRoleName", roleName);
	}

}
