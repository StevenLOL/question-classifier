package com.blackparty.questionclassifier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("login", "message", "Running QController.index()");
		return mav;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView showHome(){
		
		ModelAndView mav = new ModelAndView("feed","message","Running NavigationController.showHome() method.");
		
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
}
