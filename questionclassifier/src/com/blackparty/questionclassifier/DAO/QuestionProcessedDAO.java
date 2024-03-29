package com.blackparty.questionclassifier.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.QuestionProcessed;
import com.blackparty.questionclassifier.models.QuestionType;

@Repository
@Transactional
public class QuestionProcessedDAO {
	@Autowired
	public SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	public QuestionProcessed getQuestion(int id){
		QuestionProcessed qp = null;
		Session session = sf.openSession();
		qp = (QuestionProcessed)session.get(QuestionProcessed.class,id);
		return qp;
	}
}
