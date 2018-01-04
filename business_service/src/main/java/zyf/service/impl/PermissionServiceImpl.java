package zyf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zyf.dao.PermissionDao;
import zyf.pojo.DO.PermissionDO;
import zyf.service.PermissionService;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:32:17
*/
@Service
public class PermissionServiceImpl implements PermissionService{

	@Resource
	private PermissionDao permissionDao;
	
	@Override
	public List<PermissionDO> getByRoleName(String roleName) {
		return permissionDao.getPermissionByRoleName(roleName);
	}
	
}
