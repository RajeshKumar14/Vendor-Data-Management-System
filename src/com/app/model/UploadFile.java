package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FileUp_TAB")
public class UploadFile {
	@Id
	@GeneratedValue(generator="fileup",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="fileup",sequenceName="fileup_seq")
	@Column(name="fid")
	private int fileId;
	@Column(name="fname")
	private String fileName;
	/** holds file data in byte[]
	 * format
	 */
	@Lob
	@Column(name="fdata")
	private byte[] fileData;
	
	public UploadFile() {
	
	}

	public UploadFile(int fileId) {
		this.fileId = fileId;
	}

	public UploadFile(int fileId, String fileName) {
		this.fileId = fileId;
		this.fileName = fileName;
	}

	public UploadFile(int fileId, String fileName, byte[] fileData) {
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileData = fileData;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(fileData);
		result = prime * result + fileId;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadFile other = (UploadFile) obj;
		if (!Arrays.equals(fileData, other.fileData))
			return false;
		if (fileId != other.fileId)
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UploadFile [fileId=" + fileId + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}
	
	
}
