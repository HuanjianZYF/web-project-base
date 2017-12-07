package zyf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zyf.dao.VerifyCodeDao;
import zyf.pojo.DO.VerifyCodeDO;
import zyf.service.VerifyCodeService;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午2:06:55
*/
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService{

	@Resource
	private VerifyCodeDao verifyCodeDao;
	
	@Override
	public int insertVerifyCode(VerifyCodeDO verifyCodeDO) {
		return verifyCodeDao.insertVerifyCode(verifyCodeDO);
	}

	@Override
	public int updateVerifyCodeByPhone(VerifyCodeDO verifyCodeDO) {
		return verifyCodeDao.updateVerifyCodeByPhone(verifyCodeDO);
	}

	@Override
	public VerifyCodeDO getByPhone(String phone) {
		return verifyCodeDao.getByPhone(phone);
	}

	@Override
	public int deleteByPhone(String phone) {
		return verifyCodeDao.deleteByPhone(phone);
	}
	
}
