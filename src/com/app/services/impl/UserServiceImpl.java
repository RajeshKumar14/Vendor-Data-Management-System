package com.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.services.IUserServices;

@Service
public class UserServiceImpl implements IUserServices {
	
	@Autowired
	private IUserDao dao;

	@Override
	public int saveUser(User user) {
		return dao.saveUser(user);
	}
	@Override
	public User getUserByUmailAndPwd(String userEmail, String pwd) {
		return dao.getUserByUmailAndPwd(userEmail, pwd);
	}
	
	
	@Override
	public void deleteUserById(int userId) {
		dao.deleteUserById(userId);
		
	}
	
	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}
	@Override
	public User getUserById(int userId) {
		return dao.getUserById(userId);
	}
	@Override
	public User getUserObByEmailId(String emailId) {
		return dao.getUserObByEmailId(emailId);
	}
	
	@Override
	public boolean isUserEmailExist(String userEmail) {
		return dao.isUserEmailExist(userEmail);
	}
	
	}