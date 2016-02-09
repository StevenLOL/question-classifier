package com.blackparty.questionclassifier.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.QuestionProcessed;
import com.blackparty.questionclassifier.models.QuestionType;
import com.blackparty.questionclassifier.models.User;

@Repository
@Transactional
public class QuestionProcessedDAO {
	@Autowired
	public SessionFactory sf;
	
	public void addQuestionProcessed(ArrayList<QuestionProcessed> qplist) {
		Session session = sf.openSession();
		for(QuestionProcessed qp : qplist){
			session.save(qp);
			session.flush();
			session.clear();
		}
			session.close();
	}
	
	@SuppressWarnings("unchecked")
	public QuestionProcessed getQuestion(int id){
		QuestionProcessed qp = null;
		Session session = sf.openSession();
		qp = (QuestionProcessed)session.get(QuestionProcessed.class,id);
		return qp;
	}
	
}
