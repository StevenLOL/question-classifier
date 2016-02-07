package com.blackparty.questionclassifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.FlagCodeDAO;
import com.blackparty.questionclassifier.DAO.QuestionCategoryDAO;
import com.blackparty.questionclassifier.models.FlagCode;
import com.blackparty.questionclassifier.models.QuestionCategory;

@Service
public class QuestionCategoryService {

	@Autowired
	private QuestionCategoryDAO questionCategoryDAO;
	
	public QuestionCategory getCategory(String code){
		return questionCategoryDAO.getCategory(code);
	}
}
