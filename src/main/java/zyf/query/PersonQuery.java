package zyf.query;
/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午3:07:56
*/
public class PersonQuery extends BaseQuery{
	
	/**
	 * Person的姓名
	 */
	private String name;
	
	/**
	 * Person的年龄
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
	
}
