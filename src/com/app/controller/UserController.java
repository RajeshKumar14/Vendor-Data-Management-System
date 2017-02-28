package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.services.IUserServices;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
@Controller
public class UserController {
	@Autowired
	private IUserServices service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	
	/**
	 * show reg page
	 */
	@RequestMapping("/regUser")
	public String showPage(){
		return "UserReg";
	}
	/**
	 * insert data to DB
	 */
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user")User user,ModelMap map){
		//gen pwd and set obj
		String pwd=codeUtil.getPwd();
		user.setUserPwd(pwd);
		//save obj to DB using SL
		int userId=service.saveUser(user);
		//send msg to UI
		map.addAttribute("msg","User Registered with Id:"+userId);
		//send email
		String text="welcome to user. Id is:"+user.getUserEmail()+
				", password is:"+user.getUserPwd();
		commonUtil.sendEmail(user.getUserEmail(), "User Registered..", text);
		return "UserReg";
	}
	/**
	 * show loginPage
	 */
	@RequestMapping("/showLogin")
	public String showLogin(){
		return "UserLogin";
	}

	/**
	 * Login process
	 */
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String doLoginUser(
			@RequestParam("userId")String userEmail,
			@RequestParam("password")String pwd,
			HttpServletRequest req,ModelMap map){
		
		
		String pageName=null;
		User user=service.getUserByUmailAndPwd(userEmail, pwd);
		if(user!=null){
			//create session and goto home page
			HttpSession ses=req.getSession();
			ses.setAttribute("userName", user.getUserName());
			pageName="LocationReg";
		}else{
			//create error msg and goto login page
			map.addAttribute("msg", "Invalid username/password,plz try again");
			pageName="UserLogin";
		}
		
	 return pageName;	
	}
	
	/**
	 * Logout process
	 */
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest req,ModelMap map){
		//read current session of user
		HttpSession ses=req.getSession(false);
		ses.setAttribute("userName", null);
		ses.invalidate();
		map.addAttribute("msg", "Logout success...");
		return "UserLogin";
	}

}




