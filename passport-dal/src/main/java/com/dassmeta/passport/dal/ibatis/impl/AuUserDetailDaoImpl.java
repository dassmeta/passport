package com.dassmeta.passport.dal.ibatis.impl;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UserDetailVO;
import com.dassmeta.passport.dal.ibatis.AuUserDetailDao;

public class AuUserDetailDaoImpl extends IBatisBaseDao<AuUserDetail> implements AuUserDetailDao {

	public UserDetailVO selectUserOrgDetailByUserId(Long id) {
		return getSqlSession().selectOne("com.dassmeta.passport.dal.ibatis.AuUserDetailDao.selectUserOrgDetailByUserId", id);
	}
}
