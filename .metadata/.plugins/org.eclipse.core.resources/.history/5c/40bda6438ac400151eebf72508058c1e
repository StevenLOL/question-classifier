package com.blackparty.questionclassifier.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.UserDAO;
import com.blackparty.questionclassifier.models.User;

@Service
public class UserManagerImpl implements UserManager{

	@Autowired
	private UserDAO userDao;
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.addUser(user);
		
	}

	@Override
	public List<User> getUser(String username) {
		// TODO Auto-generated method stub
		return this.userDao.getUser(username);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		this.userDao.deleteUser(username);
	}
	
}
