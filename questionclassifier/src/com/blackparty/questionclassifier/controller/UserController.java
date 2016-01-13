package com.blackparty.questionclassifier.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.blackparty.models.User;


@Controller
@SessionAttributes("user_object")
public class UserController {
	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(value="username")String username,
			@RequestParam(value="password")String password
			) {
		User user = new User(username,password);
		ModelAndView mav = new ModelAndView("home", "message", "Running QController.login() method.");
		mav.addObject("user_object", user);
		return mav;
	}
	
}
