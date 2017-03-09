package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SellVDMController {
	
	@RequestMapping("/pricing")
	public String showSellerPricingPage(ModelMap map)
	{
		return "Pricing";
	 }
	@RequestMapping("/priyakart")
	public String showVDMHomeSellPage(ModelMap map)
	{
		return "Priyakart";
	}

}
