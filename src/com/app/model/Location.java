package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="LOC_TAB")
public class Location {
	@Id
	@GeneratedValue(generator="loc",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="loc",sequenceName="loc_seq")
	@Column(name="l_id")
	private int locId;
	@Column(name="l_name")
	private String locName;
	@Column(name="l_type")
	private String locType;
	
	//constructors
	public Location() {
	}

	public Location(int locId) {
		this.locId = locId;
	}

	public Location(int locId, String locName, String locType) {
		this.locId = locId;
		this.locName = locName;
		this.locType = locType;
	}
	//set,get methods
	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	//toString method
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locType=" + locType + "]";
	}

	//hashcode and equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + locId;
		result = prime * result + ((locName == null) ? 0 : locName.hashCode());
		result = prime * result + ((locType == null) ? 0 : locType.hashCode());
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
		Location other = (Location) obj;
		if (locId != other.locId)
			return false;
		if (locName == null) {
			if (other.locName != null)
				return false;
		} else if (!locName.equals(other.locName))
			return false;
		if (locType == null) {
			if (other.locType != null)
				return false;
		} else if (!locType.equals(other.locType))
			return false;
		return true;
	}
	
	
	
	
	
}
