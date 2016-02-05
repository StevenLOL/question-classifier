package com.blackparty.questionclassifier.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.blackparty.questionclassifier.models.User;
import com.blackparty.questionclassifier.service.UserService;
import com.blackparty.questionclassifier.service.UserService;

@Controller
@SessionAttributes("user_object")
public class UserController {

	@Autowired
	UserService um;

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		String destination = "login";
		System.out.println("Running UserController.login() method.");
		User fetchedUser = um.getUser(username);
		ModelAndView mav = null;
		if (fetchedUser.getPassword().contentEquals(password)) {
			destination = "dashboard";
			mav = new ModelAndView(destination, "message", "Running QController.login() method.");
			mav.addObject("user_object", fetchedUser);
		} else {
			destination = "login";
			mav = new ModelAndView(destination, "message", "Running QController.login() method.");
		}

		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute("user_object") User userObject, BindingResult bindingResult,
			SessionStatus sessionStatus) {

		ModelAndView mav = new ModelAndView("login");
		sessionStatus.setComplete();

		return mav;
	}

	@RequestMapping("/form")
	public ModelAndView formpage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("form");
		return mav;
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("dashboard");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam(defaultValue = "ciremagz", value = "username") String username,
			@RequestParam(defaultValue = "12345", value = "password") String password) {
		System.out.println("Running UserController.register() method.\n" + username + " " + password);
		User user = new User(username, password);
		um.addUser(user);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("system_message", "registration successful.");
		return mav;
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(@ModelAttribute("user_object") User user) {
		ModelAndView mav = new ModelAndView("login");
		um.deleteUser(user.getUserId());
		return mav;
	}
}
