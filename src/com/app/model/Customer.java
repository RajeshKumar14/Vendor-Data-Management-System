package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Cust_TAB")
public class Customer {
	
	@Id
	@GeneratedValue(generator="cust",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust",sequenceName="cust_seq")
	@Column(name="cid")
	private int custId;
	@Column(name="cname")
	private String custName;
	@Column(name="cemail")
	private String custEmail;
	@Column(name="cmobile")
	private String custMobile;
	@Column(name="cregnum")
	private String custRegNum;
	@Column(name="ctype")
	private String custType;
	@Column(name="caddress")
	private String custAddress;
	
	@Column(name="token")
	private String Token;
	@Column(name="pwd")
	private String Pwd;
	
	
	public Customer() {
	}

	public Customer(int custId) {
		super();
		this.custId = custId;
	}


	public Customer(int custId, String custName) {
		this.custId = custId;
		this.custName = custName;
	}


	public Customer(int custId, String custName, String custEmail) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
	}


	public Customer(int custId, String custName, String custEmail, String custMobile) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custMobile = custMobile;
	}


	public Customer(int custId, String custName, String custEmail, String custMobile, String custRegNum) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custMobile = custMobile;
		this.custRegNum = custRegNum;
	}


	public Customer(int custId, String custName, String custEmail, String custMobile, String custRegNum,
			String custType) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custMobile = custMobile;
		this.custRegNum = custRegNum;
		this.custType = custType;
	}


	public Customer(int custId, String custName, String custEmail, String custMobile, String custRegNum,
			String custType, String custAddress, String token) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custMobile = custMobile;
		this.custRegNum = custRegNum;
		this.custType = custType;
		this.custAddress = custAddress;
		Token = token;
	}


	public Customer(int custId, String custName, String custEmail, String custMobile, String custRegNum,
			String custType, String custAddress, String token, String pwd) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custMobile = custMobile;
		this.custRegNum = custRegNum;
		this.custType = custType;
		this.custAddress = custAddress;
		Token = token;
		Pwd = pwd;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustEmail() {
		return custEmail;
	}


	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


	public String getCustMobile() {
		return custMobile;
	}


	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}


	public String getCustRegNum() {
		return custRegNum;
	}


	public void setCustRegNum(String custRegNum) {
		this.custRegNum = custRegNum;
	}


	public String getCustType() {
		return custType;
	}


	public void setCustType(String custType) {
		this.custType = custType;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public String getToken() {
		return Token;
	}


	public void setToken(String token) {
		Token = token;
	}


	public String getPwd() {
		return Pwd;
	}


	public void setPwd(String pwd) {
		Pwd = pwd;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custMobile="
				+ custMobile + ", custRegNum=" + custRegNum + ", custType=" + custType + ", custAddress=" + custAddress
				+ ", Token=" + Token + ", Pwd=" + Pwd + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Pwd == null) ? 0 : Pwd.hashCode());
		result = prime * result + ((Token == null) ? 0 : Token.hashCode());
		result = prime * result + ((custAddress == null) ? 0 : custAddress.hashCode());
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + custId;
		result = prime * result + ((custMobile == null) ? 0 : custMobile.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custRegNum == null) ? 0 : custRegNum.hashCode());
		result = prime * result + ((custType == null) ? 0 : custType.hashCode());
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
		Customer other = (Customer) obj;
		if (Pwd == null) {
			if (other.Pwd != null)
				return false;
		} else if (!Pwd.equals(other.Pwd))
			return false;
		if (Token == null) {
			if (other.Token != null)
				return false;
		} else if (!Token.equals(other.Token))
			return false;
		if (custAddress == null) {
			if (other.custAddress != null)
				return false;
		} else if (!custAddress.equals(other.custAddress))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custId != other.custId)
			return false;
		if (custMobile == null) {
			if (other.custMobile != null)
				return false;
		} else if (!custMobile.equals(other.custMobile))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custRegNum == null) {
			if (other.custRegNum != null)
				return false;
		} else if (!custRegNum.equals(other.custRegNum))
			return false;
		if (custType == null) {
			if (other.custType != null)
				return false;
		} else if (!custType.equals(other.custType))
			return false;
		return true;
	}
	
}
