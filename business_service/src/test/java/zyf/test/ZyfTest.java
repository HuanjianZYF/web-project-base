package zyf.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.util.CommonUtil;
import common.util.DateUtil;
import common.util.PropertyUtil;
import common.util.StringUtil;
import zyf.dao.UserDao;
import zyf.pojo.DO.UserDO;
import zyf.redis.RedisService;
import zyf.service.PermissionService;
import zyf.service.RoleService;
import zyf.service.UserService;
import zyf.util.BeanProxyUtil;


/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午2:11:58
*/

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/spring-context.xml")
public class ZyfTest {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private PermissionService permissionService;

	@Resource
	private RedisService redisService;
	
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
	@Ignore
	public void testSixNum() {
		UserDao dao = BeanProxyUtil.getBean(UserDao.class);
		System.out.println(dao.getByPhone("15858580733"));		
	}

	@Test
	public void testMdule(){
		System.out.println(PropertyUtil.getProperty("db.user"));
	}

	@Test
	public void testRedis(){
		Map<String, Object> map = new HashMap<>();
		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		redisService.setKeyValue("zyf2", map);
		System.out.print(redisService.getKey("zyf"));
		System.out.println("*\n*\n*\n*\n*\n*\n" + redisService.getKey("name"));
//		redisService.deleteKey("zyf");
	}

	@Test
	public void testLong(){
		Long a = new Long(2);
		String b = a.toString();
		System.out.println(b);
	}

	@Test
	public void testCandler() {
		Calendar startTime = Calendar.getInstance();
		startTime = Calendar.getInstance();
		startTime.set(Calendar.HOUR_OF_DAY, 0);
		startTime.set(Calendar.MINUTE, 0);
		startTime.set(Calendar.SECOND, 0);
		startTime.set(Calendar.MILLISECOND, 0);
		System.out.println(startTime.getTime());
	}

	@Test
	public void testInteger(){
		Date a = new Date();
		System.out.println(a.getTime() - 1000 * 60 * 60 * 24 *2);
	}

	@Test
	public void testFormat() {
		double a = 1.2233344;

		BigDecimal big = new BigDecimal(a);
		double f1 = big.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

		System.out.println(f1);
	}
}
