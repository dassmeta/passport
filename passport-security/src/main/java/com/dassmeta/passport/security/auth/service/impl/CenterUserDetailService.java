package com.dassmeta.passport.security.auth.service.impl;

import com.dassmeta.passport.security.auth.entity.UserDetail;
import com.dassmeta.passport.security.auth.service.UserDetailService;

public class CenterUserDetailService implements UserDetailService {
	public UserDetail loadUserDetailByLoginId(String loginId) {
		// //CertificationStub.UserDetail d = CertificationClient.loadPermissions(loginId);
		// if (d == null) {
		// return null;
		// }
		// String userId = d.getUserId();
		// String password = d.getPassword();
		//
		// CertificationStub.Permission[] pso = d.getPermissions();
		//
		// Permission[] pst = (Permission[]) null;
		// if ((pso != null) && (pso[0] != null)) {
		// pst = new Permission[pso.length];
		// for (int i = 0; i < pso.length; i++) {
		// pst[i] = new Permission();
		// BeanUtils.copyProperties(pso[i], pst[i]);
		// }
		// }
		// UserDetail detail = new UserDetail(userId, loginId, password, pst);
		//
		// return detail;
		return null;
	}
}
