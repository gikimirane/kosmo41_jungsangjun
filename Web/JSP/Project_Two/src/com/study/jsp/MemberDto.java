package com.study.jsp;

import java.sql.Timestamp;

public class MemberDto {
	
	String Id;
	String Pw;
	String Name;
	String Birth;
	String Gender;
	String eMail;
	String Phone ;
	Timestamp rDate;
	String Address;
	
	
//	public BDto( )
//	{
//		this.Id = Id;
//		this.Name = Name;
//		this.Pw = Pw;
//		this.rDate = rDate;
//		this.Gender = Gender;
//		this.Email = Email;
//		this.Address = Address;
//		this.Birth = Birth;
//	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String email) {
		eMail = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
		
}
