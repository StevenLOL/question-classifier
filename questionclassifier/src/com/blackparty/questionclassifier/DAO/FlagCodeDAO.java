package com.blackparty.questionclassifier.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.FlagCode;


@Repository
@Transactional
public class FlagCodeDAO {

	public SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	public FlagCode getFlag(String code){
		FlagCode fc = null;
		Session session = sf.openSession();
		fc = (FlagCode)session.get(FlagCode.class,code);
		return fc;
	}
}