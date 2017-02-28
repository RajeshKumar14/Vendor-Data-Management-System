package com.app.services;

import com.app.model.User;

public interface IUserServices {
	
	public int saveUser(User user);
	
	public User getUserByUmailAndPwd(String userEmail,String pwd);
	
	public void deleteUserById(int userId);
	
	public User getUserById(int userId);
		
	public void updateUser(User user);
		
	public boolean isUserEmailExist(String userEmail);

	public User getUserObByEmailId(String emailId);
}
