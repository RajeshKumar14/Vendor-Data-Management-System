package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {
	
	@Autowired
	private CodecUtil codecUtil;
	
	
	/*
	 * This method will check request pwd and token
	 * values with DB encoded values (pwd,token) after decoding
	 */
	private boolean isValidPwdandToken(String reqPwd,String reqToken,Customer cust){
		boolean flag=false;
		//read db values
		String ePwd=cust.getPwd();
		String eToken=cust.getToken();
		//decode them
		String dbPwd=codecUtil.doDecode(ePwd);
		String dbToekn=codecUtil.doDecode(eToken);
		//compare with req values
		if(dbPwd.equals(reqPwd) && dbToekn.equals(reqToken))
		{
			flag=true;
		}
		return flag;
	}
	
	//It returns true for non-select operations
	//of type SELLER-non select
	public boolean isValidCustforItemProcess(String reqPwd,String reqToken,Customer cust){
	 boolean status=false;
     boolean flag=isValidPwdandToken(reqPwd, reqToken, cust);
     if(flag && cust.getCustType().equals("SELLER")){
    	 status=true;
           }		
		return status;
	}
	//cust type should not be null
	public boolean isValidCustForViewItem(String reqPwd,String reqToken,Customer cust){
		boolean status=false;
		boolean flag=isValidPwdandToken(reqPwd, reqToken, cust);
		if(flag && cust.getCustType()!=null && 
			 (cust.getCustType().equals("CONSUMER")) ||
				cust.getCustType().equals("SELLER")){
			status=true;
		}
		
		return status;
	}
}