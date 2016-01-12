package com.blackparty.questionclassifier.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.stanford.nlp.trees.TypedDependency;

import com.blackparty.questionclassifier.core.RelationshipExtractor;
import com.blackparty.questionclassifier.core.Tagger;

@Controller
public class QController {
	
	@RequestMapping(value="/")
    public ModelAndView index(
            @RequestParam(defaultValue = "What is the probability that it lands on heads exactly one time?",value = "sentence") String input
    ){
        ModelAndView mav = new ModelAndView("index","message","Running QController.index()");
        RelationshipExtractor re = new RelationshipExtractor(input);
        Collection<TypedDependency> returnedInput = re.extract(input);
        mav.addObject("returned_input",returnedInput);
        mav.addObject("input",input);
        return mav;
    }

    @RequestMapping(value = "/relational_dependency")
    public ModelAndView getRelationalDependency(
    		@RequestParam(value = "message",required = true)String input
    		){
    	 ModelAndView mav = new ModelAndView("index","message","Running QController.index()");
         RelationshipExtractor re = new RelationshipExtractor(input);
         Collection<TypedDependency> returnedInput = re.extract(input);
         mav.addObject("returned_input",returnedInput);
         mav.addObject("input",input);
         return mav;
    }
    
    @RequestMapping(value="/pos_tag")
    public ModelAndView getPosTag(
    		@RequestParam(value="message")String input
    		){
    	ModelAndView mav = new ModelAndView("index","message","Running QController.index()");
    	Tagger tagger = new Tagger();
    	String tagged = tagger.tag(input);
    	mav.addObject("returned_input",tagged);
    	mav.addObject("input",input);
    	return mav;
    }
	

}
