package com.blackparty.questionclassifier.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.QuestionItem;
import com.blackparty.questionclassifier.models.User;

@Transactional
@Repository
public class QuestionItemDAO {

	
	
	@Autowired
	private SessionFactory sf;
	
	public void addQuestion(QuestionItem qi) {
		Session session = sf.openSession();
		session.save(qi);
		session.flush();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public QuestionItem getQuestion(int id){
		QuestionItem qi = null;
		Session session = sf.openSession();
		Query query = session.createQuery("from QUESTION_ITEM_TABLE where QUESTION_ID=:id");
		query.setInteger("id",id);
		qi = (QuestionItem)query.uniqueResult();
		return qi;
	}

	public void updateQuestion(QuestionItem newQi){
		Session session = sf.openSession();
		QuestionItem qi = (QuestionItem)session.get(QuestionItem.class,newQi.getQuestionId());
		session.update(newQi);
		session.flush();
		session.close();
	}
	public void deleteQuestion(int id) {
		Session session = sf.openSession();
		QuestionItem qi = (QuestionItem)session.get(QuestionItem.class,id);
		session.delete(qi);
		session.flush();
		session.close();
	}
}
