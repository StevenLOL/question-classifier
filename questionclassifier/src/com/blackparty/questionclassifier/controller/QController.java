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

import com.blackparty.questionclassifier.core.RelationshipExtractor;
import com.blackparty.questionclassifier.core.Splitter;
import com.blackparty.questionclassifier.core.Tagger;
import com.blackparty.questionclassifier.core.TaggerImpl;
import com.blackparty.questionclassifier.core.Uploader;
import com.blackparty.questionclassifier.models.QuestionItem;
import com.blackparty.questionclassifier.models.User;

@Controller
@SessionAttributes("user_object")
public class QController {
	private String systemMessage;
	private boolean flag;
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
	@RequestMapping(value = "/pos_tag")
	public ModelAndView getPosTag(@RequestParam(value = "message") String input) {
		ModelAndView mav = new ModelAndView("feed", "message", "Running QController.getPostTag()");
		Tagger tagger = new TaggerImpl();
		String tagged = tagger.tag(input);
		mav.addObject("returned_input", tagged);
		mav.addObject("input", input);
		return mav;
	}
	@RequestMapping(value="/process")
	public ModelAndView startProcess(
			@RequestParam(value="message")String input
			){
		ModelAndView mav = new ModelAndView("feed","message","Running QController.process() method.");
		
		Splitter split= new Splitter();
		QuestionItem qi = split.distribute(input);
		TaggerImpl tagger = new TaggerImpl();
		qi.displayWordValues();
		qi = tagger.tag(qi);
		qi.displayWordWithTags();
		return mav;
	}

}
