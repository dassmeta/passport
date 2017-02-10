package com.dassmeta.passport.web.home;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexTempController {

	/** LOGGER */
	// private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login";
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "home";

	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login";

	}

	@RequestMapping("/org")
	public String tables(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "org-manage";

	}

	@RequestMapping("/user")
	public String widgets(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "user-manage";

	}

	@RequestMapping("/role")
	public String panels(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "role-manage";

	}

	@RequestMapping("/permission")
	public String forms(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "permission-manage";

	}
}