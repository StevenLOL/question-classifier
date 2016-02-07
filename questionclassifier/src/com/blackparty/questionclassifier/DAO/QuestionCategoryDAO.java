package com.blackparty.questionclassifier.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.QuestionCategory;
import com.blackparty.questionclassifier.models.User;

@Repository
@Transactional
public class QuestionCategoryDAO {
	@Autowired
	public SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	public QuestionCategory getCategory(String code){
		QuestionCategory qc = null;
		Session session = sf.openSession();
		qc = (QuestionCategory)session.get(QuestionCategory.class,code);
		return qc;
	}
}
