package com.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.services.IItemServices;

@Service
public class ItemServicesImpl implements IItemServices{
	@Autowired
	private IItemDao dao;
	
	@Override
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}
}
