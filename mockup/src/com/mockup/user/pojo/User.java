package com.mockup.user.pojo;

public class User {

	public static String ADMIN="admin";
	private String userid="";
	private String password="";
	private UserInformation info=new UserInformation();
	private boolean logon=false;
	public UserInformation getInfo() {
		return info;
	}

	public void setInfo(UserInformation info) {
		this.info = info;
	}

	public boolean isLogon() {
		return logon;
	}

	public void setLogon(boolean status) {
		this.logon = status;
	}

	public User(){};
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStreet1() {
		return info.street1;
	}
	public void setStreet1(String street1) {
		this.info.street1 = street1;
	}
	public String getStreet2() {
		return info.street2;
	}
	public void setStreet2(String street2) {
		this.info.street2 = street2;
	}
	public String getCity() {
		return info.city;
	}
	public void setCity(String city) {
		this.info.city = city;
	}
	public String getProvince() {
		return info.province;
	}
	public void setProvince(String province) {
		this.info.province = province;
	}
	public String getCountry() {
		return info.country;
	}
	public void setCountry(String country) {
		this.info.country = country;
	}
	public String getZip() {
		return info.zip;
	}
	public void setZip(String zip) {
		this.info.zip = zip;
	}
	public String getEmail() {
		return info.email;
	}
	public void setEmail(String email) {
		this.info.email = email;
	}
	public String getHomephone() {
		return info.homephone;
	}
	public void setHomephone(String homephone) {
		this.info.homephone = homephone;
	}
	public String getCellphone() {
		return info.cellphone;
	}
	public void setCellphone(String cellphone) {
		this.info.cellphone = cellphone;
	}
	public String getOfficephone() {
		return info.officephone;
	}
	public void setOfficephone(String officephone) {
		this.info.officephone = officephone;
	}
	
	private class UserInformation {
		public String street1="";
		public String street2="";
		public String city="";
		public String province="";
		public String country="";
		public String zip="";
		public String email="";
		public String homephone="";
		public String cellphone="";
		public String officephone="";
		
		
	}
}
