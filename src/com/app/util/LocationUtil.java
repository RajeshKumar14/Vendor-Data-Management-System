package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.services.ILocationService;

@Component
public class LocationUtil {
	
	@Autowired
	private ILocationService service;
	
	/**
	*write a method to get all locations
	*/
	public List<Location> getAllLocations()
	{
	return service.getAllLocations();
	}
	/***
	 * Charts Generation process
	 */
	/**
	 * Pie chart method
	 */
	public void generatePiechart(String path,List<Object[]> list){
		//1.construct dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob: list){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		//2.convert to JFreeChart ob using ChartFactory
		
		JFreeChart chart=ChartFactory.createPieChart3D("Locationwise Report", dataset, true, true, false);
		
		//3.save As Image using ChartUtils
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportA.jpg"), chart, 400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * Bar chart method
	 */
	public void generateBarchart(String path,List<Object[]> list){
		//1.construct data set
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:list){
			dataset.setValue(new Double(ob[1].toString()),ob[0].toString(),"");
		}
		//2.convert to JFreeChart ob using ChartFactory
		JFreeChart chart=ChartFactory.createBarChart3D("Locationwise Report", "Location Type", "Location count", dataset);
		//3.save As Image using ChartUtils
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportB.jpg"), chart, 400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
