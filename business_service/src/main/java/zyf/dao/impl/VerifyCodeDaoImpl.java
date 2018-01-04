package zyf.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import zyf.dao.VerifyCodeDao;
import zyf.pojo.DO.VerifyCodeDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午1:49:43
*/
@Repository
public class VerifyCodeDaoImpl extends SqlSessionDaoSupport implements VerifyCodeDao{
	private static final String NAME_SPACE = "zyf.dao.VerifyCodeMapper.";
	
	@Resource
	@Qualifier("sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public int insertVerifyCode(VerifyCodeDO verifyCodeDO) {
		return getSqlSession().insert(NAME_SPACE + "insertVerifyCode", verifyCodeDO);
	}

	@Override
	public int updateVerifyCodeByPhone(VerifyCodeDO verifyCodeDO) {
		return getSqlSession().update(NAME_SPACE + "updateVerifyCodeByPhone", verifyCodeDO);
	}

	@Override
	public VerifyCodeDO getByPhone(String phone) {
		return getSqlSession().selectOne(NAME_SPACE + "selectVerifyCodeByPhone", phone);
	}

	@Override
	public int deleteByPhone(String phone) {
		return getSqlSession().delete(NAME_SPACE + "deleteVerifyCode", phone);
	}
	
}
