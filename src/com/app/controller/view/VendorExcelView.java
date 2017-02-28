package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractExcelView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, 
			HttpServletRequest req, 
			HttpServletResponse res)throws Exception {
		
		//create sheet and add to book
		//1.reading data from map
		List<Vendor> venList=(List<Vendor>)map.get("venListObj");
		
		//2.create sheet from book
		HSSFSheet sheet=book.createSheet("Vendor");
		
		//3.set header
		setHeader(sheet);
		//4.set body
		setBody(sheet,venList);
		
	              }
	private void setHeader(HSSFSheet sheet){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Location");
		row.createCell(3).setCellValue("EmailId");
		row.createCell(4).setCellValue("MobileNo");
		        }
	
	private void setBody(HSSFSheet sheet,List<Vendor> venList) {
		int rowNum=1;
		for(Vendor ven:venList){
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ven.getVenId());
			row.createCell(1).setCellValue(ven.getVenName());
			row.createCell(2).setCellValue(ven.loc.getLocName());
			row.createCell(3).setCellValue(ven.getVenEmail());
			row.createCell(4).setCellValue(ven.getVenMobile());
		        }
	        }
     }
