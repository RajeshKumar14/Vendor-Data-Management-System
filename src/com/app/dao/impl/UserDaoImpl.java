package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUser(User user) {
		return (Integer)ht.save(user);
	}
	
	@Override
	public User getUserByUmailAndPwd(String userEmail, String pwd) {
		User user=null;
		String hql="from "+ User.class.getName()+" where userEmail=? and userPwd=?";
		@SuppressWarnings("unchecked")
		List<User> userList=ht.find(hql, userEmail,pwd);
		if(userList!=null && !userList.isEmpty()){
			user=userList.get(0);
		}
		return user;
	}
	
	
	@Override
	public void deleteUserById(int userId) {
		ht.delete(new User(userId));
		
	}
	@Override
	public User getUserById(int userId) {
		return ht.get(User.class, userId);
	}
	
	@Override
	public void updateUser(User user) {
		ht.update(user);
		
	}
	@Override
	public boolean isUserEmailExist(String userEmail) {
		boolean flag=false;
		String hql="select count(userId) from "+User.class.getName()
				+" where userEmail=?";
		@SuppressWarnings("unchecked")
		List<Long>dataList=ht.find(hql,userEmail);
		
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	}
	
	@Override
	public User getUserObByEmailId(String emailId) {
		User user=null;
		String hql="from "+User.class.getName()
				+" where userEmail=?";
		@SuppressWarnings("unchecked")
		List<User> userList=ht.find(hql, emailId);
		if(userList!=null && !userList.isEmpty()){
			user=userList.get(0);
		}
		return user;
	}
}
