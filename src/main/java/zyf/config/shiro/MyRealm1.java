package zyf.config.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import zyf.dao.UserDao;
import zyf.pojo.DO.UserDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月3日上午11:22:12
*/
public class MyRealm1 extends AuthorizingRealm{

	@Resource
	private UserDao userDao;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 登陆时的身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  //得到用户名  
		UserDO userDO = userDao.getByUserName(username);
		if (userDO == null) {
			throw new RuntimeException("用户不存在");
		}
		String password = userDO.getPassword();
		        
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；  
        return new SimpleAuthenticationInfo(username, password, getName());
	}
	
}
