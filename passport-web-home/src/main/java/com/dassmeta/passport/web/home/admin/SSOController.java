package com.dassmeta.passport.web.home.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dassmeta.passport.core.service.ApplicationService;
import com.dassmeta.passport.core.service.UserDetailService;
import com.dassmeta.passport.core.service.UserService;
import com.dassmeta.passport.security.auth.AuthConstants;

@Controller
public class SSOController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private ApplicationService appService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest request) throws Exception {
		return "login";
	}

	@RequestMapping(value = AuthConstants.LOGIN_ON_URL, method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request) throws Exception {
		return "home";
	}

	@RequestMapping(value = AuthConstants.LOGIN_OUT_URL, method = RequestMethod.POST)
	public void logout(HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("SSH_ONLINE_USER");
		request.getSession().removeAttribute("specter_session_login_key");
	}
}
