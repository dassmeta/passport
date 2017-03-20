package com.dassmeta.passport.security.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.ibatis.AuUserDao;

@Service("userReam")
public class UserRealm extends AuthorizingRealm {

	private final static Logger LOG = LoggerFactory.getLogger(UserRealm.class);

	private static final String REALM_NAME = "PASSPORT-USERREALM";

	@Autowired
	private AuUserDao userDao;

	@Override
	public void setName(String name) {
		super.setName(REALM_NAME);
	}

	/**
	 * 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (LOG.isInfoEnabled()) {
			LOG.info("doGetAuthorizationInfo invoke,principals:{}", principals);
		}
		// String username = (String) principals.fromRealm(getName()).iterator().next();
		// if (username != null) {
		// AuUser user = userDao.findByLoginName(username);
		// if (user != null) {
		// SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// return info;
		// }
		// }
		return null;
	}

	/**
	 * 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		if (LOG.isInfoEnabled()) {
			LOG.info("doGetAuthenticationInfo invoke,authcToken:{}", authcToken);
		}
		try {
			String username = (String) authcToken.getPrincipal();
			AuUser user = userDao.findByLoginName(username);
			if (user == null) {
				throw new UnknownAccountException();// 没找到帐号
			}
			// if (Boolean.TRUE.equals(user.getLocked())) {
			// throw new LockedAccountException(); // 帐号锁定
			// }

			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getLoginId(), // 用户名
					user.getPassword(), // 密码
					getName() // realm name
			);
			authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getLoginId() + "passport-passport-salt"));
			return authenticationInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
