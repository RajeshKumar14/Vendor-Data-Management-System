package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);
	}
	
	@Override
	public List<Location> getAllLocations() {
		return ht.loadAll(Location.class);
	}
	
	@Override
	public void deleteLocById(int locId) {
		ht.delete(new Location(locId));	
	}
	@Override
	public Location getLocationById(int locId) {
		return ht.get(Location.class, locId);
	}
	
	@Override
	public void updateLoc(Location loc) {
		ht.update(loc);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getLocationwiseCount() {
		String hql="select locType,count(locType) "
				+ " from  "+Location.class.getName()
				+ " group by locType";
		
		return (List<Object[]>)ht.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isLocNameExist(String locName) {boolean flag=false;
	String hql="select count(locId) from "+Location.class.getName()
			+" where locName=?";
	List<Long> dataList=ht.find(hql,locName);
	
	if(dataList!=null && !dataList.isEmpty()){
		long count=dataList.get(0);
		if(count>0) flag=true;
	     }
	return flag;
    }
}
