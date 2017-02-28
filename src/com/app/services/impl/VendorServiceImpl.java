package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.services.IVendorServices;

@Service
public class VendorServiceImpl implements IVendorServices {
	
	@Autowired
	private IVendorDao dao;
	
	@Override
	public int saveVendor(Vendor ven) {
		return (Integer)dao.saveVendor(ven);
	}
	@Override
	public List<Vendor> getAllVendor() {
		return dao.getAllVendor();
	}
	@Override
	public void deleteVenById(int venId) {
		dao.deleteVenById(venId);
		
	}
	@Override
	public Vendor getVendorById(int venId) {
		return dao.getVendorById(venId);
	}
	@Override
	public void updateVen(Vendor ven) {
		dao.updateVen(ven);
		
	}
	
	@Override
	public boolean isVenEmailExist(String venEmail) {
		
		return dao.isVenEmailExist(venEmail);
	}
	
}
