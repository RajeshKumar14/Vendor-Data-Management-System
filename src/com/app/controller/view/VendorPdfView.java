package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter arg2, 
			HttpServletRequest arg3, 
			HttpServletResponse arg4)throws Exception {
		
		//1.read data from map
		List<Vendor> venList=(List<Vendor>)map.get("venListObj");
		
		//2.construct data as table
		PdfPTable table=new PdfPTable(5);
		
		//3.add header
		table.addCell("Id");
		table.addCell("Name");
		table.addCell("Location");
		table.addCell("EmailId");
		table.addCell("MobileNo");
		//4.add data
		for(Vendor ven:venList){
			table.addCell(Integer.toString(ven.getVenId()));
			table.addCell(ven.getVenName());
			table.addCell(ven.loc.getLocName());
			table.addCell(ven.getVenEmail());
			table.addCell(ven.getVenMobile());
			
		}
		
		//5.add elements to Document
		Paragraph p=new Paragraph("Vendor List");
		document.add(p);
		document.add(table);
		
	}  
	
	
	

}
