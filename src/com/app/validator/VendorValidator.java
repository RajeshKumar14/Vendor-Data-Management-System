package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.services.IVendorServices;

@Component
public class VendorValidator {
	
	@Autowired
	private IVendorServices service;
	
	public String doValidateVenEmail(String venEmail){
		String msg=null;
		if(service.isVenEmailExist(venEmail)){
			msg="'"+venEmail+"' already exist";
		}
		return msg;
	}

}
