package zyf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zyf.dao.PersonDao;
import zyf.pojo.DO.PersonDO;
import zyf.service.PersonService;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午4:19:37
*/
@Service
public class PersonServiceImpl implements PersonService{

	@Resource
	private PersonDao personDao;
	
	public PersonDO getPersonById(Long id) {
		return personDao.getPersonById(id);
	}
	
}
