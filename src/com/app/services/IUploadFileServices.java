package com.app.services;

import java.util.List;

import com.app.model.UploadFile;

public interface IUploadFileServices {
	
	public void saveUploadFile(UploadFile file);
	public List<Object[]> getFileIdAndNames();
	public UploadFile getFileObjById(int fileId);
	public void deleteUploadFileById(int fileId );
}
