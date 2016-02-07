package com.blackparty.questionclassifier.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.QuestionCategory;
import com.blackparty.questionclassifier.models.QuestionType;

@Repository
@Transactional
public class QuestionTypeDAO {

	@Autowired
	public SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	public QuestionType getType(String code){
		QuestionType qt = null;
		Session session = sf.openSession();
		qt = (QuestionType)session.get(QuestionType.class,code);
		return qt;
	}
}
