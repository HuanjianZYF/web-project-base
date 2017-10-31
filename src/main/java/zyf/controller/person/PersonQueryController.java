package zyf.controller.person;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import zyf.pojo.DO.PersonDO;
import zyf.service.PersonService;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午4:22:27
*/
@RestController
@RequestMapping("person")
public class PersonQueryController {
	
	@Resource
	private PersonService personService;
	
	/**
	 * 根据id查询Person
	 */
	@RequestMapping("getById")
	public String getPersonById(Long id) {
		if (id == null) {
			return "sb";
		}
		PersonDO personDO = personService.getPersonById(id);
		return JSON.toJSONString(personDO);
	}
}
