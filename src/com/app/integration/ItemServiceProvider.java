package com.app.integration;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.services.ICustomerServices;
import com.app.services.IItemServices;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Path("/itemService")
@Component
public class ItemServiceProvider {
	@Autowired
	private ICustomerServices custService;
	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemServices itemService;
	
	@POST
	@Path("/saveItem")
	public String saveItem(
			@HeaderParam("user")String un,
			@HeaderParam("password")String pwd,
			@HeaderParam("token")String token,
			String json){
		boolean flag=false;
		//user name should not be empty or null
		if(un==null || "".equals(un.trim()))
			return "Empty/Invalid user name!!";
		//get customer obj/null from DB using user name/email Id
		Customer cust=custService.getCustObByEmailId(un);
		if(cust==null)
			return "Username is invalid";
		//validate given customer object for save opr.
		//with pwd and token data
		flag=custValidator.isValidCustforItemProcess(pwd, token, cust);
		if(!flag)
			return "Invalid Authentication details(pwd,token)/Invalid cust type for operation";
		
		Item ob=(Item)jsonUtil.convertJsonToObj(json, Item.class);
		if(ob==null)
			return "No item details found";
		//set custId and save item
		ob.setCustId(cust.getCustId());
		int itemId=itemService.saveItem(ob);
		
		if(itemId!=0)
			return "Item saved with Id:"+itemId;
		else
			return "Item not saved..";
	}
}