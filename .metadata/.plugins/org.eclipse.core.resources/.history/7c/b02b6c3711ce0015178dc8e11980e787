package com.blackparty.questionclassifier.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackparty.questionclassifier.models.User;

@Repository
@Transactional
public class UserDAO {
	
	@Autowired
	private SessionFactory sf;
	
	public void addUser(User u) {
		
		Session session = sf.openSession();
		session.save(u);
		session.flush();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String username){
		User user = null;
		Session session = sf.openSession();
		Query query = session.createQuery("from User where username=:name");
		query.setString("name",username);
		user = (User)query.uniqueResult();
		return user;
	}

	
	public void updateUser(User newUser){
		Session session = sf.openSession();
		User oldUser = (User)session.get(User.class,newUser.getUserId());
		session.update(newUser);
		session.flush();
		session.close();
	}
	public void deleteUser(int userId) {
		Session session = sf.openSession();
		User user = (User)session.get(User.class,userId);
		session.delete(user);
		session.flush();
		session.close();
	}
}
