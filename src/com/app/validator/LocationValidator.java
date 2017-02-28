package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.services.ILocationService;

@Component
public class LocationValidator {
	@Autowired
	private ILocationService service;
	
	public String doValidateLocName(String locName){
		String msg=null;
		if(service.isLocNameExist(locName)){
			msg="'"+locName+"' already exist";
		}
		return msg;
	}
}
