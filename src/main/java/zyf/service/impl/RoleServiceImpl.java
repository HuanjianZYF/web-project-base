package zyf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zyf.dao.RoleDao;
import zyf.pojo.DO.RoleDO;
import zyf.service.RoleService;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午3:49:47
*/
@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<RoleDO> getByUserName(String userName) {
		return roleDao.getRoleByUserName(userName);
	}
	
}
