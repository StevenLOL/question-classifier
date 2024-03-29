package com.blackparty.questionclassifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.QuestionItemDAO;
import com.blackparty.questionclassifier.DAO.UserDAO;
import com.blackparty.questionclassifier.models.QuestionItem;
import com.blackparty.questionclassifier.models.User;


@Service
public class QuestionItemService {
	
	@Autowired
	private QuestionItemDAO qiDao;
	
	public void addQuestion(QuestionItem qi){
		qiDao.addQuestion(qi);
	}
	public QuestionItem getQuestionItem(int id){
		QuestionItem qi = qiDao.getQuestion(id);
		return qi;
	}
	public void deleteQuestion(int id){
		qiDao.deleteQuestion(id);
	}
	public void updateQuestion(QuestionItem newQi){
		qiDao.updateQuestion(newQi);
	}
}
