package zyf.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zyf.dao.UserDao;
import zyf.pojo.DO.UserDO;
import zyf.service.PermissionService;
import zyf.service.RoleService;
import zyf.service.UserService;
import zyf.util.BeanProxyUtil;
import zyf.util.CommonUtil;
import zyf.util.DateUtil;
import zyf.util.PropertyUtil;
import zyf.util.StringUtil;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午2:11:58
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class ZyfTest {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private PermissionService permissionService;
	
	@Test
	public void testCommonUtil() {
		Map<Object, Object> map = new HashMap<>();
		map.put("a", "b");
		System.out.println(CommonUtil.isEmpty(map));
	}

	@Test
	public void testPermissionService() {
		System.out.println(permissionService.getByRoleName("admin"));
	}
	
	@Test
	public void testDateUtil() {
		Date now = new Date();
		System.out.println(DateUtil.getYear(now));
		System.out.println(DateUtil.getMonth(now));
		System.out.println(DateUtil.getDate(now));
		System.out.println(DateUtil.getHour(now));
		System.out.println(DateUtil.getMinute(now));
		System.out.println(DateUtil.getSecond(now));
		
		System.out.println(DateUtil.toDateStringWithCustomFormat(now, "yyyy$MM-dd hh:mm:ss"));
		
		try{
			System.out.println(DateUtil.transDateStringToDate("yyyy-MM-dd hh:mm:ss", "1995-08-13 10:23:11"));
		}catch(Exception e) {
		}
		
		System.out.println(DateUtil.addMinute(now, 20));
	}
	
	@Test
	public void testStringUtil() {
		String s = "你是我的一切，我的全部，向往你的向往，幸福你的幸福1";
		String s2 = "1555555";
		String s3 = "哈哈哈zyf";
		String s4 = "收到货地方  可额\n计122\t3";
		System.out.println(StringUtil.left(s, 10));
		System.out.println(StringUtil.right(s, 10));
		
		System.out.println(StringUtil.isNumeric(s));
		System.out.println(StringUtil.isNumeric(s2));
		
		System.out.println(StringUtil.isAlpha(s));
		System.out.println(StringUtil.isAlpha(s2));
		System.out.println(StringUtil.isAlpha(s3));
		
		System.out.println(StringUtil.isAlphaNumeric(s));
		System.out.println(StringUtil.isAlphaNumeric(s2));
		System.out.println(StringUtil.isAlphaNumeric(s3));
		System.out.println(StringUtil.isAlphaNumeric(s4));
		
		System.out.println(StringUtil.isAlphaNumericSpace(s));
		System.out.println(StringUtil.isAlphaNumericSpace(s2));
		System.out.println(StringUtil.isAlphaNumericSpace(s3));
		System.out.println(StringUtil.isAlphaNumericSpace(s4));
	}
	
	@Test
	public void testStringUtil2() {
		UserDO[] userArray = new UserDO[2];
		userArray[0] = new UserDO();
		userArray[1] = new UserDO();
		userArray[0].setPassword("111");
		userArray[1].setPassword("2222");
		
		int[] ints = new int[] {1,2,3,5,8};
		
		double[] doubles = new double[] {1.2, 2.3, 6.8, 9};
		
		System.out.println(StringUtil.array2Str(userArray));
		System.out.println(StringUtil.array2Str(ints));
		System.out.println(StringUtil.array2Str(doubles));
	}
	
	@Test
	public void testSixNum() {
		UserDao dao = BeanProxyUtil.getBean(UserDao.class);
		System.out.println(dao.getByPhone("15858580733"));		
	}
}
