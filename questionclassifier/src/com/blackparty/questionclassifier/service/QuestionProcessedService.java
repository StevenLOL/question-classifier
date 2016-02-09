package com.blackparty.questionclassifier.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.QuestionProcessedDAO;
import com.blackparty.questionclassifier.models.QuestionProcessed;

@Service
public class QuestionProcessedService {

	@Autowired
	private QuestionProcessedDAO qpDao;
	
	public void addQuestion(ArrayList<QuestionProcessed> qp){
		System.out.println("addQuestion\n\n");
		qpDao.addQuestionProcessed(qp);
	}
	public QuestionProcessed getQuestion(int id){
		return qpDao.getQuestion(id);
	}

}
