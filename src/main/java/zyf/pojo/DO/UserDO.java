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
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 头像
	 */
	private String avatarUrl;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Override
	public String toString() {
		return "UserDO [phone=" + phone + ", password=" + password + ", nickName=" + nickName + ", avatarUrl="
				+ avatarUrl + "]";
	}
	
}
