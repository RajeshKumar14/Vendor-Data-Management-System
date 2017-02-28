package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.services.ICustomerServices;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;
@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerServices service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;

	@RequestMapping("/regCust")
	public String showVenReg(ModelMap map)
	{
		return "CustomerReg";
		}
	
	/**
	 * Use this below method
	 * to save data.
	 * On click submit from UI
	 * page request should come to here
	 * as post Type,
	 * read model attribute name:Customer 
	 * copy to local variable
	 */
	/**
	 * save data to db
	 * 1.read cust from Container using ModelAttribute
	 */
	@RequestMapping(value="/insertCust",method=RequestMethod.POST)
	public String saveCustData(@ModelAttribute("Customer")Customer cust,ModelMap map){
		//2.generate pwd and token
		String Pwd=codeUtil.getPwd();
		String Token=codeUtil.getToken();
		
		//3.convert above data to encoded format
		String encPwd=codecUtil.doEncode(Pwd);
		String encToken=codecUtil.doEncode(Token);
		
		//4.set encoded pwd,tocken to cust obj
		cust.setToken(codecUtil.doEncode(encToken));
		cust.setPwd(codecUtil.doEncode(encPwd));
		
		//5.save data to d
		int custId=service.saveCustomer(cust);
		
		//6.send email
		if(custId!=0)
		   {
	String subject="Hello Mr/Ms/Mrs. "+cust.getCustName()+".This is regarding registration to VDM.";
	String message="You are Successfully registered as a "+cust.getCustType()+
				".Your Password is: "+Pwd+" and accessToken is: "+Token 
				+". User Name is :"+cust.getCustEmail();
		commonUtil.sendEmail(cust.getCustEmail(), subject, message);
		    }
		
		//7.send message to UI
		String msg="Customer Saved with id:"+custId;
		map.addAttribute("msg", msg);
		return "CustomerReg";
	}
	
	/**
	 * This method is used to
	 * fetch all records from DB
	 * using SL and sends to UI
	 * using ModelMap , it is executed
	 * when 'viewAllCust' req is made
	 * It can be called from InsertCust Page
	 */
	//provide url
	@RequestMapping("/viewAllCust")
	public String showAllCust(ModelMap map){
		//read data from SL
		List<Customer> custList=service.getAllCustomer();
		//send to UI 
		map.addAttribute("custListObj", custList);
		//specify UI page name
		return  "CustomerData";
	}
	
	
	@RequestMapping("/updateCust")
	public String showEditPage(@RequestParam("CustId")int custId,ModelMap map){
	
		Customer cust=service.getCustomerById(custId);
		map.addAttribute("custObj",cust);
		return "CustomerUpdate";
	}
	
	/**
	 * this method is used to
	 * get obj from UI form
	 * and sends to service layer
	 * and redirect to Show Page.
	 * THis is type POST.
	 */
	@RequestMapping(value="/custUpdate",method=RequestMethod.POST)
	public String updateCustData(@ModelAttribute("customer")Customer cust){
		service.updateCust(cust);
		return "redirect:viewAllCust";
	}
	
	/**
	 * This method is used to delete
	 * data from database
	 * and sending all in UI page
	 */
	@RequestMapping("deleteCust")
	public String deleteCust(@RequestParam("CustId")int id)
	{
		service.deleteCustById(id);
		return "redirect:viewAllCust";
	}
	
}
