package com.dassmeta.passport.dal.ibatis;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;

public interface AuUserDao extends IBaseDao<AuUser> {

	AuUser findByLoginName(String loginName);

	int updataPasswordByLoginName(String loginName, String newPassword);

	AuUserDetail getUserDetail(Long id);

	AuUser isLoginUser(AuUser user);

}