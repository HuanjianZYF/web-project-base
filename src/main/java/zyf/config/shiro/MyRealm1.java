package zyf.config.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import zyf.pojo.DO.RoleDO;
import zyf.pojo.DO.UserDO;
import zyf.service.RoleService;
import zyf.service.UserService;
import zyf.util.CommonUtil;

/**
* @Author 庄元丰
* @CreateTime 2017年11月3日上午11:22:12
*/
public class MyRealm1 extends AuthorizingRealm{

	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	/**
	 * 权限验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//得到用户名
		String phone = principals.getPrimaryPrincipal().toString();
		
		List<RoleDO> roleList = roleService.getByPhone(phone);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		if (CommonUtil.isNotEmpty(roleList)) {
			for (RoleDO role : roleList) {
				info.addRole(role.getRoleName());
			}
		}
		
		return info;
	}

	/**
	 * 登陆时的身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String phone = (String)token.getPrincipal();  //得到用户名  
		UserDO userDO = userService.getByPhone(phone);
		if (userDO == null) {
			throw new RuntimeException("用户不存在");
		}
		String password = userDO.getPassword();
		        
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；  
        return new SimpleAuthenticationInfo(phone, password, getName());
	}
	
}
