package com.dassmeta.passport.core.service.impl;

import cn.widewisdom.entity.auth.AuOrgInfo;
import cn.widewisdom.entity.auth.AuUser;
import cn.widewisdom.entity.auth.AuUserDetail;
import cn.widewisdom.service.CertificationService;
import cn.widewisdom.ws.authenticate.UserDetailServiceResponse;
import cn.widewisdom.ws.bean.Department;
import cn.widewisdom.ws.dao.AuthenticateUserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CertificationServiceImpl implements CertificationService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AuthenticateUserDAO authenticateUserDAO;

	public UserDetailServiceResponse loadUserDetail(String appCode, String loginID) {
		UserDetailServiceResponse response = new UserDetailServiceResponse();
		AuUser user = this.authenticateUserDAO.getUserByLoginID(loginID);
		if (user == null) {
			return response;
		}
		AuUserDetail d = this.authenticateUserDAO.getUserDetail(user.getId());

		AuOrgInfo orgInfo = d.getOrg();

		BeanUtils.copyProperties(d, response);
		BeanUtils.copyProperties(user, response);

		Department department = new Department();
		BeanUtils.copyProperties(orgInfo, department);

		response.setDepartment(department);

		response.setDepartmentID(orgInfo.getId().toString());

		response.setJobName(d.getJobName());

		response.setIdentityCard(d.getIdentityCard());

		return response;
	}
}
