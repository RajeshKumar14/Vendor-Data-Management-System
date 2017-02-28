package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.services.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;

@Controller
public class LocationController {
	@Autowired
	private ILocationService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private LocationUtil util;
	@Autowired
	private LocationValidator validator;
	
	/**show loc reg page on
	 *  enter url as /regLoc
	 */
	@RequestMapping("/regLoc")
	public String showPage(){
		return "LocationReg";
	}
	
	/**
	 * Use this below method
	 * to save data.
	 * On click submit from UI
	 * page request should come to here
	 * as post Type,
	 * read model attribute name:location 
	 * copy to local variable
	 */
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String saveLocData(@ModelAttribute("location")Location loc,ModelMap map){
		//check data with validator 
				String msg=validator.doValidateLocName(loc.getLocName());
				if(msg!=null){
					//data has error
					map.addAttribute("msg",msg);
				}else{
					//save data-no error
					int id=service.saveLocation(loc);
					map.addAttribute("msg", "saved with id:"+id);
				}
		return "LocationReg";
	}
	
	/**
	 * This method is used to
	 * fetch all records from DB
	 * using SL and sends to UI
	 * using ModelMap , it is executed
	 * when 'viewAllLoc' req is made
	 * It can be called from Insert Page
	 */
	//provide url
	@RequestMapping("/viewAllLoc")
	public String showAllLoc(ModelMap map){
		//read data from SL
		List<Location> locList=service.getAllLocations();
		//send to UI 
		map.addAttribute("locListObj", locList);
		//specify UI page name
		return  "LocationData";
	}
	/**
	 * This method is used to delete
	 * data from database
	 * and sending all in UI page
	 */
	@RequestMapping("deleteLoc")
	public String deleteLoc(@RequestParam("LocId")int id)
	{
		service.deleteLocById(id);
		return "redirect:viewAllLoc";
	}
	
	/**
	 * This method is used to 
	 * display edit page/update page
	 * when user clicks on update
	 * link. It will display editpage
	 * with data reads from DB using id
	 * It goes to LocationUpdate JSP page
	 */
	@RequestMapping("/updateLoc")
	public String showEditPage(@RequestParam("LocId")int locId,ModelMap map){
		
		Location loc=service.getLocationById(locId);
		map.addAttribute("locObj",loc);
		
		return "LocationUpdate";
	}
	/**
	 * this method is used to
	 * get obj from UI form
	 * and sends to service layer
	 * and redirect to Show Page.
	 * THis is type POST.
	 */
	@RequestMapping(value="/locUpdate",method=RequestMethod.POST)
	public String updateLocData(@ModelAttribute("location")Location loc, ModelMap map){
		//check data with validator 
		String msg=validator.doValidateLocName(loc.getLocName());
		if(msg!=null){
			//data has error
			map.addAttribute("msg",msg);
		}else{
			//save data-no error
			service.updateLoc(loc);	
		}
		return "redirect:viewAllLoc";
	}
	
	/***
	 * This method is used to fetch
	 * data from SL and path using context
	 * and send those to Util to generate Charts
	 * at last send to UI page 
	 */
	@RequestMapping("/generateReport")
	public String generateCharts(){
		List<Object[]> list=service.getLocationwiseCount();
		String path=context.getRealPath("/");
		
		util.generatePiechart(path, list);
		util.generateBarchart(path, list);
		
		return "LocReport";
	}
	
	
}
