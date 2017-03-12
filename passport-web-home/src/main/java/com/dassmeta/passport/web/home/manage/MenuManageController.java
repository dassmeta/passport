package com.dassmeta.passport.web.home.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dassmeta.passport.core.service.PermissionService;

@Controller
public class MenuManageController {

	@Autowired
	private PermissionService permissionService;

}
