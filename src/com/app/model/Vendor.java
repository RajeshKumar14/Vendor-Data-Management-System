package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Ven_TAB")
public class Vendor {
	@Id
	@GeneratedValue(generator="ven",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="ven",sequenceName="ven_seq")
	@Column(name="v_id")
	private int venId;
	@Column(name="v_name")
	private String venName;
	@ManyToOne
	@JoinColumn(name="locFk")
	public Location loc;
	@Column(name="v_email")
	private String venEmail;
	@Column(name="v_mobile")
	private String venMobile;
	
	//constructors
	public Vendor() {
	
	}
	public Vendor(int venId) {
		this.venId = venId;
	}
	public Vendor(int venId, String venName) {
		this.venId = venId;
		this.venName = venName;
	}
	
    public Vendor(int venId, String venName, Location loc) {
		this.venId = venId;
		this.venName = venName;
		this.loc = loc;
	}
    
    public Vendor(int venId, String venName, Location loc, String venEmail) {
		this.venId = venId;
		this.venName = venName;
		this.loc = loc;
		this.venEmail = venEmail;
	}

   public Vendor(int venId, String venName, Location loc, String venEmail, String venMobile) {
	    this.venId = venId;
	    this.venName = venName;
	    this.loc = loc;
	    this.venEmail = venEmail;
	    this.venMobile = venMobile;
      }
//setter and getter method
    public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	public String getVenEmail() {
		return venEmail;
	}
	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}
	public String getVenMobile() {
		return venMobile;
	}
	public void setVenMobile(String venMobile) {
		this.venMobile = venMobile;
	}
	//toString method
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", loc=" + loc + ", venEmail=" + venEmail
				+ ", venMobile=" + venMobile + "]";
	}
	
	//Hash Code method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + ((venEmail == null) ? 0 : venEmail.hashCode());
		result = prime * result + venId;
		result = prime * result + ((venMobile == null) ? 0 : venMobile.hashCode());
		result = prime * result + ((venName == null) ? 0 : venName.hashCode());
		return result;
	}

	//Equal Method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (venEmail == null) {
			if (other.venEmail != null)
				return false;
		} else if (!venEmail.equals(other.venEmail))
			return false;
		if (venId != other.venId)
			return false;
		if (venMobile == null) {
			if (other.venMobile != null)
				return false;
		} else if (!venMobile.equals(other.venMobile))
			return false;
		if (venName == null) {
			if (other.venName != null)
				return false;
		} else if (!venName.equals(other.venName))
			return false;
		return true;
	}
		
}
