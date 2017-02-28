package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {
	
	public int saveCustomer(Customer cust);
	
	public List<Customer> getAllCustomer();
	
    public void deleteCustById(int custId);
	
	public Customer getCustomerById(int custId);
	
	public void updateCust(Customer cust);
	
	public boolean isCustEmailExist(String custEmail);

	public Customer getCustObByEmailId(String emailId);
}
