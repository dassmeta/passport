package com.dassmeta.passport.web.home.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dassmeta.passport.util.OnlineUser;

public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	// @Autowired
	// private PrivilegeProvider privilegeProvider;
	// @Autowired
	// private AuthenticationProvider authenticationProvider;

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute index.action");
		}

		HttpSession session = request.getSession();

		OnlineUser user = (OnlineUser) session.getAttribute("SSH_ONLINE_USER");
		if (user != null) {
			// String appcode = "aegean-login";

			return "success";
		}
		try {
			response.sendRedirect("/manage/login.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
