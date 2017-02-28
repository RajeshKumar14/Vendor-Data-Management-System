package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveVendor(Vendor ven) {
		return (Integer)ht.save(ven);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return ht.loadAll(Vendor.class);
	}

	@Override
	public void deleteVenById(int venId) {
		ht.delete(new Vendor(venId));
		
	}

	@Override
	public Vendor getVendorById(int venId) {
		return ht.get(Vendor.class, venId);
	}

	@Override
	public void updateVen(Vendor ven) {
		ht.update(ven);
		
	}
	
	@Override
	public boolean isVenEmailExist(String venEmail) {
		boolean flag=false;
		String hql="select count(venId) from "+Vendor.class.getName()
				+" where venEmail=?";
		@SuppressWarnings("unchecked")
		List<Long>dataList=ht.find(hql,venEmail);
		
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	    }
}
