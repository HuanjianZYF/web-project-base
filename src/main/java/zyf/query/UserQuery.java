package zyf.query;
/**
* @Author 庄元丰
* @CreateTime 2017年11月8日上午10:36:22
*/
public class UserQuery extends BaseQuery{
	
	/**
	 * 用户名
	 */
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserQuery [userName=" + userName + "]";
	}
	
}
