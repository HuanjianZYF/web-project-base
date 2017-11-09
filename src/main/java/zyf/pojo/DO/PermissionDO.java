package zyf.pojo.DO;

import zyf.pojo.BaseDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:13:00
*/
public class PermissionDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5557041400964755064L;

	/**
	 * 角色名
	 */
	private String roleName;
	
	/**
	 * 权限名
	 */
	private String permission;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "PermissionDO [roleName=" + roleName + ", permission=" + permission + "]";
	}
	
}
