package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VDMController {

	@RequestMapping("/vdmhome")
	public String showVDMHomePage(ModelMap map)
	{
		return "VdmHome";
	 }
	
}

