package zyf.dao;

import zyf.pojo.DO.VerifyCodeDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日下午1:45:20
*/
public interface VerifyCodeDao {
	
	/**
	 * 插入一条验证码
	 */
	int insertVerifyCode(VerifyCodeDO verifyCodeDO);
	
	/**
	 * 根据手机号更新一条验证码
	 */
	int updateVerifyCodeByPhone(VerifyCodeDO verifyCodeDO);
	
	/**
	 * 根据手机号查询一条验证码
	 */
	VerifyCodeDO getByPhone(String phone);
	
	/**
	 * 删除一个手机号的验证码
	 */
	int deleteByPhone(String phone);
}
