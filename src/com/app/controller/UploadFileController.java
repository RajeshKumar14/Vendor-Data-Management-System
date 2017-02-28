package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.app.model.UploadFile;
import com.app.services.IUploadFileServices;

@Controller
public class UploadFileController {

	   @Autowired
	   private IUploadFileServices service;
	
	     //show UI page
		@RequestMapping("/uploadFile")
		public String showUploadFile(ModelMap map){
			//reading file details and seding to UI
		 	List<Object[]> obList=service.getFileIdAndNames();
		 	
		 	map.addAttribute("obList",obList);
			
		 	return "FileUpload";
		}
		//
		@RequestMapping(value="/uploadData",method=RequestMethod.POST)
		public String doUpload(
			@RequestParam("filessobj")CommonsMultipartFile fileObj){
			
			if(fileObj!=null){
				String fileName=fileObj.getOriginalFilename();
				byte[] arr=fileObj.getBytes();
				//convert to obj
				UploadFile fileUploadObj=new UploadFile();
				fileUploadObj.setFileName(fileName);
				fileUploadObj.setFileData(arr);
				service.saveUploadFile(fileUploadObj);
				
			    }
			
			return  "redirect:uploadFile";
		}
		
		@RequestMapping("/downloadFile")
		public void downloadFile(@RequestParam("fileId")int fileId,HttpServletResponse res){
			UploadFile file=service.getFileObjById(fileId);
			
			//add one response header
			res.setHeader("Content-Disposition", "attachment;filename="+file.getFileName());
			try {
				FileCopyUtils.copy(file.getFileData(), res.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		/**
		 * This method is used to delete
		 * data from database
		 * and sending all in UI page
		 */
		@RequestMapping("deleteFile")
		public String deleteUploadFile(@RequestParam("FileId")int id)
		{
			service.deleteUploadFileById(id);
			return "redirect:uploadFile";
		}
		
}
