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
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 角色名
	 */
	private String roleName;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDO [phone=" + phone + ", roleName=" + roleName + "]";
	}

}
