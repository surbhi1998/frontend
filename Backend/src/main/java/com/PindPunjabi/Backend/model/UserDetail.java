package com.PindPunjabi.Backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class UserDetail {
	
	 @Id
	 String UserName;
	 String password;
	 String MobileNo;
	 String Email;
	 String Address;
	
	 public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	 
	 
}
