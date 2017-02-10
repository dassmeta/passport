package com.dassmeta.passport.web.home.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dassmeta.passport.core.service.ApplicationService;
import com.dassmeta.passport.core.service.UserDetailService;
import com.dassmeta.passport.core.service.UserService;
import com.dassmeta.passport.core.service.vo.RUserInfo;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.UserDetailVO;

@Controller
public class SSOController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private ApplicationService appService;

	//@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		AuUser user = this.userService.getUserByLoginID(loginId);
		if (user == null) {
			request.getSession().setAttribute("specter_session_error_key", "specter_no_user_error");
			return "login";
		}
		if (!user.getPassword().equals(password)) {
			request.getSession().setAttribute("specter_session_error_key", "specter_password_error");
			return "login";
		}
		UserDetailVO userDetailVO = userDetailService.findUserDetailVOById(user.getId());

		RUserInfo ru = new RUserInfo();
		BeanUtils.copyProperties(userDetailVO, ru);
		ru.setLoginId(user.getLoginId());
		ru.setPassword(user.getPassword());
		request.getSession().setAttribute("SSH_ONLINE_USER", ru);
		request.getSession().setAttribute("areaCode", ru.getOrgCode());
		request.getSession().setAttribute("specter_session_login_key", ru.getLoginId());
		String f = request.getSession().getServletContext().getRealPath("");
		request.getSession().setAttribute("userSystemList", this.appService.getUserSystemList(f));
		return "index";
	}

	public void logout(HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("SSH_ONLINE_USER");
		request.getSession().removeAttribute("specter_session_login_key");
	}
}
