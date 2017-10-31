package zyf.pojo.DO;

import zyf.pojo.BaseDO;

/**
* @Author 庄元丰
* @CreateTime 2017年10月20日上午11:37:59
*/
public class PersonDO extends BaseDO{
	
	/**
	 * 序列化id 
	 */
	private static final long serialVersionUID = 5405831578901744542L;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "PersonDO [name=" + name + ", age=" + age + "]";
	}
}
