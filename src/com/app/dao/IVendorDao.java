package com.app.dao;

import java.util.List;
import com.app.model.Vendor;

public interface IVendorDao {
	
	public int saveVendor(Vendor ven);
	/**
	 * adding method to get all records from Ven_TAB
	 * */
	public List<Vendor> getAllVendor();
	/**
	 * Delete method to delete Vendor data from Ven_TAB
	 */
	public void deleteVenById(int venId);	
	/***
	 * this method is used to fetch Vendor 
	 * object from	 db based on 
	 * primary key ie venId
	 */
	public Vendor getVendorById(int venId);
	
	/***
	 * This method is used to update 
	 * data from UI to DB (Vendor obj)
	 */
	public void updateVen(Vendor ven);
	
	public boolean isVenEmailExist(String venEmail);

}
