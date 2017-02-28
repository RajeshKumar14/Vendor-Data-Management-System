package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.services.IVendorServices;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
import com.app.validator.VendorValidator;

@Controller
public class VendorController {
	
	@Autowired
	private IVendorServices service;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private VendorValidator validator;
	
	/**
	 * To integrate location with
	 * vendor using Locationutil
	 * has-a with vendorcontroller
	 */
	@Autowired
	private LocationUtil locUtil;
	
	@RequestMapping("/regVen")
	public String showVenReg(ModelMap map)
	{
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj",locList);
		return "VendorReg";
		}
	/**
	 * Use this below method
	 * to save data.
	 * On click submit from UI
	 * page request should come to here
	 * as post Type,
	 * read model attribute name:vendor 
	 * copy to local variable
	 */
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String saveVenData(@ModelAttribute("vendor")Vendor ven,
			ModelMap map,
			@RequestParam("inpFile")CommonsMultipartFile file){
		//check data with validator 
		String msg=validator.doValidateVenEmail(ven.getVenEmail());
		if(msg!=null){
			//data has error
			map.addAttribute("msg",msg);
		}else{
			//save data-no error
		int venId=service.saveVendor(ven);
		msg="Vendor Saved with id:"+venId;
		map.addAttribute("msg", msg);
		
           /**send email also**/
		  commonUtil.sendEmail(ven.getVenEmail(),"Registered as Vendor", msg,file);
		     }
		/**adding lines to display locations after insert*/ 
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList );
		/**End*/
		return "VendorReg";
	}
	/**
	 * This method is used to
	 * fetch all records from DB
	 * using SL and sends to UI
	 * using ModelMap , it is executed
	 * when 'viewAllVen' req is made
	 * It can be called from InsertVen Page
	 */
	//provide url
	@RequestMapping("/viewAllVen")
	public String showAllVen(ModelMap map){
		//read data from SL
		List<Vendor> venList=service.getAllVendor();
		//send to UI 
		map.addAttribute("venListObj", venList);
		//specify UI page name
		return  "VendorData";
	}
	
	/**
	 * This method is used to 
	 * display edit page/update page
	 * when user clicks on update
	 * link. It will display editpage
	 * with data reads from DB using id
	 * It goes to VendorUpdate JSP page
	 */
	@RequestMapping("/updateVen")
	public String showEditPage(@RequestParam("VenId")int venId,ModelMap map){
		/**adding lines to display locations before update*/ 
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList );
		/**End*/
	
		Vendor ven=service.getVendorById(venId);
		map.addAttribute("venObj",ven);
		return "VendorUpdate";
	}
	/**
	 * this method is used to
	 * get obj from UI form
	 * and sends to service layer
	 * and redirect to Show Page.
	 * THis is type POST.
	 */
	@RequestMapping(value="/venUpdate",method=RequestMethod.POST)
	public String updateVenData(
	  @ModelAttribute("vendor")Vendor ven){
		service.updateVen(ven);
		return "redirect:viewAllVen";
	}
	
	/**
	 * This method is used to delete
	 * data from database
	 * and sending all in UI page
	 */
	@RequestMapping("deleteVen")
	public String deleteVen(@RequestParam("VenId")int id)
	{
		service.deleteVenById(id);
		return "redirect:viewAllVen";
	}
	
	/**
	 * This method will be
	 * executed on click of hyper link for
	 * data export to excel. fetch data from DB
	 * using service layer and send to
	 * ExcelView impl class with ModelMap help.  
	 */
	@RequestMapping("/venExcelExport")
	public String exportDataExcel(ModelMap map){
		List<Vendor> venList=service.getAllVendor();
		map.addAttribute("venListObj", venList);
		return "VenExcel";
	}
	
	/**
	 * for pdf export
	 * 
	 */
	@RequestMapping("/venPdfExport")
	public String exportDataPdf(ModelMap map){
		List<Vendor> venList=service.getAllVendor();
		map.addAttribute("venListObj", venList);
		return "VenPdf";
	}
	
	
}
