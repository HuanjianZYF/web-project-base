package zyf.query;
/**
* @Author 庄元丰
* @CreateTime 2017年11月9日下午5:14:50
*/
public class PermissionQuery extends BaseQuery{
	
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
		return "PermissionQuery [roleName=" + roleName + ", permission=" + permission + "]";
	}
	
}
