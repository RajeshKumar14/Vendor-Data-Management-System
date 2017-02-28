package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveItem(Item item) {
		return (Integer)ht.save(item);
	}
	
}
