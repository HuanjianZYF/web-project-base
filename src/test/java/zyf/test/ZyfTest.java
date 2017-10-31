package zyf.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zyf.dao.PersonDao;
import zyf.pojo.DO.PersonDO;
import zyf.query.PersonQuery;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午2:11:58
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class ZyfTest {
	
	@Resource
	private PersonDao personDao;
	
	@Test
	public void testPersonMapper() {
		PersonDO zyf = new PersonDO();
		zyf.setAge(23);
		zyf.setName("zyf");
		
		PersonQuery query = new PersonQuery();
		query.setAge(22);
		query.setOffset(1);
		query.setLimit(10);
		
		personDao.insertPerson(zyf);
		System.out.println(personDao.getPersonById(2L));
		System.out.println(personDao.getPersonByCondition(query));
	}
	
}
