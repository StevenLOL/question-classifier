package com.blackparty.questionclassifier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.UserDAO;
import com.blackparty.questionclassifier.models.User;

@Service
public class UserService{
	
	@Autowired
	private UserDAO userDao;
	public void addUser(User user){
		userDao.addUser(user);
	}
	public User getUser(String username){
		User user = userDao.getUser(username);
		return user;
	}
	public void deleteUser(int userId){
		userDao.deleteUser(userId);
	}
	public void updateUser(User user){
		userDao.updateUser(user);
	}
}
