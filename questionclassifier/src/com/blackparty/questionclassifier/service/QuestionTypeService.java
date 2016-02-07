package com.blackparty.questionclassifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.FlagCodeDAO;
import com.blackparty.questionclassifier.DAO.QuestionTypeDAO;
import com.blackparty.questionclassifier.models.FlagCode;
import com.blackparty.questionclassifier.models.QuestionType;

@Service
public class QuestionTypeService {
	@Autowired
	private QuestionTypeDAO qtDao;
	
	public QuestionType getType(String code){
		return qtDao.getType(code);
	}
}