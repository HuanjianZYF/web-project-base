package zyf.service;

import zyf.pojo.DO.VerifyCodeDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午1:56:56
*/
public interface VerifyCodeService {
	
	/**
	 * 插入一条验证码
	 */
	int insertVerifyCode(VerifyCodeDO verifyCodeDO);
	
	/**
	 * 根据手机号更新验证码
	 */
	int updateVerifyCodeByPhone(VerifyCodeDO verifyCodeDO);
	
	/**
	 * 查询一个手机号的验证码
	 */
	VerifyCodeDO getByPhone(String phone);
	
	/**
	 * 根据手机号删除验证码
	 */
	int deleteByPhone(String phone);
}
