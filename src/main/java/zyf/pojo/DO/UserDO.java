package zyf.pojo.DO;

import zyf.pojo.BaseDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日上午10:33:33
*/
public class UserDO extends BaseDO{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 2218111788937305328L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDO [userName=" + userName + ", password=" + password + "]";
	}
	
}
