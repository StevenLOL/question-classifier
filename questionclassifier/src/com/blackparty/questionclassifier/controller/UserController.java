package com.blackparty.questionclassifier.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.blackparty.questionclassifier.core.UserManager;
import com.blackparty.questionclassifier.core.UserManagerImpl;
import com.blackparty.questionclassifier.models.User;


@Controller
@SessionAttributes("user_object")
public class UserController {
	UserManager um = new UserManagerImpl();
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(value="username")String username,
			@RequestParam(value="password")String password
			) {
		String destination ="login";
		User user = new User(username, password);
		List<User> userList = um.getUser(username);
		if(userList.get(0).getPassword().contentEquals(password)){
			destination = "home";
		}else{
			destination = "login";
		}
		ModelAndView mav = new ModelAndView(destination, "message", "Running QController.login() method.");
		mav.addObject("user_object", user);
		return mav;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(
			@RequestParam(value="username")String username,
			@RequestParam(value="password")String password
			){
		User user = new User(username, password);		
		um.addUser(user);
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value="delete")
	public ModelAndView delete(
			@RequestParam(value="username")String username
			){
		ModelAndView mav = new ModelAndView("login");
		um.deleteUser(username);
		return mav;	
	}
}
