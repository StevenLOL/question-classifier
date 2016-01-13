package com.blackparty.questionclassifier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blackparty")
public class UserController {

	@RequestMapping("/home")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/userdashboard")
	public String dashboard() {
		return "dashboard";
	}
}
