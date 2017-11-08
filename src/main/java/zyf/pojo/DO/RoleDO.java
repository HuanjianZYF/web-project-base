package zyf.pojo.DO;

import zyf.pojo.BaseDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午8:16:18
*/
public class RoleDO extends BaseDO{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 7886195384765443296L;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 角色名
	 */
	private String roleName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDO [userName=" + userName + ", roleName=" + roleName + "]";
	}
	
}
