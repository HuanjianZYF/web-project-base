package zyf.query;
/**
* @Author 庄元丰
* @CreateTime 2017年11月8日上午10:36:22
*/
public class UserQuery extends BaseQuery{
	
	/**
	 * 手机号
	 */
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserQuery [phone=" + phone + "]";
	}
	
}
