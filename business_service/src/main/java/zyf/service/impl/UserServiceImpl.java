package zyf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zyf.dao.UserDao;
import zyf.pojo.DO.UserDO;
import zyf.service.UserService;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午3:47:17
*/
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public UserDO getByPhone(String phone) {
		return userDao.getByPhone(phone);
	}
	
}
