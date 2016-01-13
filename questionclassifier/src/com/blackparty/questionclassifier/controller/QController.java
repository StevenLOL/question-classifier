package com.blackparty.questionclassifier.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import edu.stanford.nlp.trees.TypedDependency;

import com.blackparty.models.User;
import com.blackparty.questionclassifier.core.RelationshipExtractor;
import com.blackparty.questionclassifier.core.Tagger;
import com.blackparty.questionclassifier.core.Uploader;

@Controller
@SessionAttributes("user_object")
public class QController {
	private String systemMessage;
	private boolean flag;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index", "message", "Running QController.index()");
		return mav;
	}

	@RequestMapping(value = "/feed")
	public ModelAndView showFeedPage(@RequestParam("file") MultipartFile file,
			@ModelAttribute("user_object") User user) {
		
		if (!file.isEmpty()) {
			try {
				Uploader u = new Uploader();
				System.out.println("Uploading File..");
				u.upload(file,user,"Knowledge");
			} catch (Exception e) {
				systemMessage = "Upload failed";
				e.getMessage();
			}
		} else {
			systemMessage = "File is empty";
		}
		ModelAndView mav = new ModelAndView("feed", "message", "Running QController.showFeedPage() method.");
		mav.addObject("system_message",systemMessage);
		return mav;
	}


	@RequestMapping(value = "/relational_dependency")
	public ModelAndView getRelationalDependency(@RequestParam(value = "message", required = true) String input) {
		ModelAndView mav = new ModelAndView("feed", "message", "Running QController.index()");
		RelationshipExtractor re = new RelationshipExtractor(input);
		Collection<TypedDependency> returnedInput = re.extract(input);
		mav.addObject("returned_input", returnedInput);
		mav.addObject("input", input);
		return mav;
	}

	@RequestMapping(value = "/display_question")
	public ModelAndView displayQuestionPage() {
		ModelAndView mav = new ModelAndView("display", "message", "Running QController.displayQuestionPage() method.");

		return mav;
	}

	@RequestMapping(value = "/home")
	public ModelAndView displayHome() {
		ModelAndView mav = new ModelAndView("home", "message", "Running QController.displayHome() method.");

		return mav;
	}

	@RequestMapping(value = "/pos_tag")
	public ModelAndView getPosTag(@RequestParam(value = "message") String input) {
		ModelAndView mav = new ModelAndView("feed", "message", "Running QController.index()");
		Tagger tagger = new Tagger();
		String tagged = tagger.tag(input);
		mav.addObject("returned_input", tagged);
		mav.addObject("input", input);
		return mav;
	}

}
