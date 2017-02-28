package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUploadFileDao;
import com.app.model.UploadFile;
import com.app.services.IUploadFileServices;

@Service
public class UploadFileServiceImpl implements IUploadFileServices{
	@Autowired
	private IUploadFileDao dao;

	@Override
	public void saveUploadFile(UploadFile file) {
		dao.saveUploadFile(file);
		
	}

	@Override
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}

	@Override
	public UploadFile getFileObjById(int fileId) {
		return dao.getFileObjById(fileId);
	}
	@Override
	public void deleteUploadFileById(int fileId) {
		dao.deleteUploadFileById(fileId);
		
	}

}
