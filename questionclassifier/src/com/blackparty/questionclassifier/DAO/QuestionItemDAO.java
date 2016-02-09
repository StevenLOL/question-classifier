package com.blackparty.questionclassifier.DAO;

import java.util.List;

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
	public List<QuestionItem> getAllQuestions(int id){
		System.out.println("getting all questions\n"+id);
		List<QuestionItem> qiList = null;
		Session session = sf.openSession();
		Query query = session.createQuery("from QuestionItem where user_id=:id");
		query.setInteger("id",id);
		qiList = query.list();
		System.out.println(">> "+qiList.size());
		for(QuestionItem e: qiList){
			System.out.println(e.toString());
		}
		session.flush();
		session.close();
		return qiList;
	}
	@SuppressWarnings("unchecked")
	public QuestionItem getQuestion(int id){
		QuestionItem qi = null;
		Session session = sf.openSession();
		Query query = session.createQuery("from QuestionItem where question_id=:id");
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
