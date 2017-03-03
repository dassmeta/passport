package com.dassmeta.passport.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dassmeta.passport.core.service.CertificationService;
import com.dassmeta.passport.dal.ibatis.AuUserDao;

@Service("certificationService")
public class CertificationServiceImpl implements CertificationService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AuUserDao userDao;

	// public UserDetailServiceResponse loadUserDetail(String appCode, String loginID) {
	// UserDetailServiceResponse response = new UserDetailServiceResponse();
	// AuUser user = userDao.findByLoginName(loginID);
	// if (user == null) {
	// if (logger.isInfoEnabled()) {
	// logger.info("loadUserDetail by loginID is null! loginID=" + loginID);
	// }
	// return response;
	// }
	// AuUserDetail d = this.userDao.getUserDetail(user.getId());
	//
	// AuOrgInfo orgInfo = d.getOrg();
	//
	// BeanUtils.copyProperties(d, response);
	// BeanUtils.copyProperties(user, response);
	//
	// Department department = new Department();
	// BeanUtils.copyProperties(orgInfo, department);
	//
	// response.setDepartment(department);
	//
	// response.setDepartmentID(orgInfo.getId().toString());
	//
	// response.setJobName(d.getJobName());
	//
	// response.setIdentityCard(d.getIdentityCard());
	//
	// return response;
	// }
}
