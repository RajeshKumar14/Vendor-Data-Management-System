package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.services.ICustomerServices;

@Service
public class CustomerServicesImpl implements ICustomerServices{
	
	@Autowired
	private ICustomerDao dao;
	
	@Override
	public int saveCustomer(Customer cust) {
		return (Integer)dao.saveCustomer(cust);
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}
	
	@Override
	public void deleteCustById(int custId) {
	dao.deleteCustById(custId);
		
	}
	@Override
	public Customer getCustomerById(int custId) {
		return dao.getCustomerById(custId);
	}
	@Override
	public void updateCust(Customer cust) {
		dao.updateCust(cust);
		
	}
	@Override
	public boolean isCustEmailExist(String custEmail) {
		return dao.isCustEmailExist(custEmail);
	}
	@Override
	public Customer getCustObByEmailId(String emailId) {
		return dao.getCustObByEmailId(emailId);
	}
	
}
