package com.blackparty.questionclassifier.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user_object, question_object")
public class NavigationController {

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("login", "message", "Running QController.index()");
		return mav;
	}

	@RequestMapping("/ajaxsample")
	public ModelAndView ajaxsamplepage() {
		ModelAndView mav = new ModelAndView("ajaxsample");
		return mav;
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpServletRequest request) {
		ModelAndView mav = null;
		String page;
		if (request.getSession().getAttribute("username") != null) {
			page = "dashboard";
		} else {
			page = "login";

		}

		mav = new ModelAndView(page);
		return mav;
	}

	@RequestMapping("/feed-page")
	public ModelAndView formpage(HttpServletRequest request) {
		ModelAndView mav = null;
		String page;
		if (request.getSession().getAttribute("username") != null) {
			page = "feed-page";
		} else {
			page = "login";

		}

		mav = new ModelAndView(page);
		return mav;
	}

	@RequestMapping(value = "/test")
	public ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("feed", "message", "Running NavigationController.showHome() method.");
		return mav;
	}

	@RequestMapping(value = "/home")
	public ModelAndView displayHome() {
		ModelAndView mav = new ModelAndView("home", "message", "Running QController.displayHome() method.");
		return mav;
	}

	@RequestMapping(value = "/display_question")
	public ModelAndView displayQuestionPage() {
		ModelAndView mav = new ModelAndView("display", "message", "Running QController.displayQuestionPage() method.");

		return mav;
	}

	@RequestMapping(value = "/register")
	public ModelAndView displayRegisterPage() {
		ModelAndView mav = new ModelAndView("register", "message",
				"Running NavigationController.displayRegisterPage() method.");
		return mav;

	}

}
