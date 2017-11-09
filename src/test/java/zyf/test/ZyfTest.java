package zyf.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zyf.dao.RoleDao;
import zyf.dao.UserDao;
import zyf.pojo.DO.UserDO;
import zyf.service.PermissionService;
import zyf.util.CommonUtil;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午2:11:58
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class ZyfTest {
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private PermissionService permissionService;
	
	@Test
	public void testCommonUtil() {
		Map<Object, Object> map = new HashMap<>();
		map.put("a", "b");
		System.out.println(CommonUtil.isEmpty(map));
	}
	
	@Test
	public void testUserDao() {
		UserDO zyf = new UserDO();
		zyf.setUserName("zyf");
		zyf.setPassword("11113");
		zyf.setId(2L);
		userDao.updateUserById(zyf);
		System.out.println(userDao.getUserById(1L));
	}
	
	@Test
	public void testRoleDao() {
		System.out.println(roleDao.getRoleByUserName("zyf"));
	}
	
	@Test
	public void testPermissionService() {
		System.out.println(permissionService.getByRoleName("admin"));
	}
}
