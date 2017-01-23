package com.dassmeta.passport.web.home;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/** LOGGER */
	// private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String home(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login";

	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "index";

	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login";

	}

	@RequestMapping("/charts")
	public String charts(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "charts";

	}

	@RequestMapping("/tables")
	public String tables(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "tables";

	}

	@RequestMapping("/widgets")
	public String widgets(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "widgets";

	}

	@RequestMapping("/panels")
	public String panels(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "panels";

	}

	@RequestMapping("/forms")
	public String forms(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "forms";

	}
}