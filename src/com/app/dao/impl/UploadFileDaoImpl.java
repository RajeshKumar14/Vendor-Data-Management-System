package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUploadFileDao;
import com.app.model.UploadFile;

@Repository
public class UploadFileDaoImpl implements IUploadFileDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public void saveUploadFile(UploadFile file) {
		ht.save(file);	
	}
	@Override
	public List<Object[]> getFileIdAndNames() {
		String hql="select fileId,fileName from com.app.model.UploadFile"; 
		@SuppressWarnings("unchecked")
		List<Object[]> find = (List<Object[]>)ht.find(hql);
		return find;
	}
	@Override
	public UploadFile getFileObjById(int fileId) {
		return ht.get(UploadFile.class, fileId);
	}
	
	
	@Override
	public void deleteUploadFileById(int fileId) {
		ht.delete(new UploadFile(fileId));
		
	}
}
