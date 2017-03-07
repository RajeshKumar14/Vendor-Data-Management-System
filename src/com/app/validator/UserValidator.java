package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.services.IUserServices;

@Component
public class UserValidator {
	
	@Autowired
	private IUserServices service;
	
	public String doValidateUserEmail(String userEmail){
		String msg=null;
		if(service.isUserEmailExist(userEmail)){
			msg="'"+userEmail+"' already exist";
		}
		return msg;
	}

}
