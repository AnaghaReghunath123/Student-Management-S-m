package com.studentmanagement.model;

public class SchoolEmployee {
	int School_Employee_id;
	String School_Employee_name;
	String Password;
	
	
	public SchoolEmployee() {
		super();
	
	}
	public SchoolEmployee(int school_Employee_id, String school_Employee_name, String password) {
		super();
		School_Employee_id = school_Employee_id;
		School_Employee_name = school_Employee_name;
		this.Password = password;
	}
	public int getSchool_Employee_id() {
		return School_Employee_id;
	}
	public void setSchool_Employee_id(int school_Employee_id) {
		School_Employee_id = school_Employee_id;
	}
	public String getSchool_Employee_name() {
		return School_Employee_name;
	}
	public void setSchool_Employee_name(String school_Employee_name) {
		School_Employee_name = school_Employee_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
