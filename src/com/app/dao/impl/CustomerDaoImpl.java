package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl  implements ICustomerDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveCustomer(Customer cust) {
		return (Integer)ht.save(cust);
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return ht.loadAll(Customer.class);
	}
	
	@Override
	public void deleteCustById(int custId) {
		ht.delete(new Customer(custId));
	}
	
	public Customer getCustomerById(int custId) {
		return ht.get(Customer.class, custId);
	}
	
	@Override
	public void updateCust(Customer cust) {
		ht.update(cust);
		}
	
	@Override
	public boolean isCustEmailExist(String custEmail) {
		boolean flag=false;
		String hql="select count(custId) from "+Customer.class.getName()
				+" where custEmail=?";
		@SuppressWarnings("unchecked")
		List<Long>dataList=ht.find(hql,custEmail);
		
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	   }
	
	@Override
	public Customer getCustObByEmailId(String emailId){
		Customer cust=null;
		String hql="from "+Customer.class.getName()
				+" where custEmail=?";
		@SuppressWarnings("unchecked")
		List<Customer> custList=ht.find(hql, emailId);
		if(custList!=null && !custList.isEmpty()){
			cust=custList.get(0);
		}
		return cust;
	}
}
