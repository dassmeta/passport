package com.dassmeta.passport.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UserDetailVO;
import com.dassmeta.passport.dal.ibatis.AuOrgInfoDao;
import com.dassmeta.passport.dal.ibatis.AuUserDetailDao;

@Service("userDetailService")
public class UserDetailService {

	@Autowired
	private AuUserDetailDao userDetailDao;

	@Autowired
	private AuOrgInfoDao orgInfoDao;

	public AuUserDetail findUserDetailById(Long id) {
		return userDetailDao.findByPrimaryKey(id);
	}

	public UserDetailVO findUserDetailVOById(Long id) {
		return userDetailDao.selectUserOrgDetailByUserId(id);
	}

}
