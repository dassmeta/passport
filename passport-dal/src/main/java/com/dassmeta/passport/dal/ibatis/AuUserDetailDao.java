package com.dassmeta.passport.dal.ibatis;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UserDetailVO;

public interface AuUserDetailDao extends IBaseDao<AuUserDetail> {

	UserDetailVO selectUserOrgDetailByUserId(Long id);

}