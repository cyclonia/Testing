package com.onlinetest.beans;

import java.sql.Date;

public class RegistrationBean {
	public String firstName;
	public String lastName;
	public String email;
	public String branch;
	public String semester;
	public Date dob;
	public String gender;
	public String address;
	public String password;
	public String studentId;
	
	public String getStudentId(){
		return studentId;
	}
	public void setStudentId(String studentId){
		this.studentId=studentId;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date sqlDate) {
		this.dob = sqlDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
