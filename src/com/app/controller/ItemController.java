package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
	
		@RequestMapping("/home")
		public String showItemHomePage(ModelMap map)
		{
			return "Home";
		 }
	
	}
