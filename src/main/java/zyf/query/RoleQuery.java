package zyf.query;
/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午8:17:58
*/
public class RoleQuery extends BaseQuery{
	
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
		return "RoleQuery [userName=" + userName + ", roleName=" + roleName + "]";
	}
	
}
