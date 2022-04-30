package com.studentmanagement.model;

public class Faculty {
	int Faculty_id;
	String Faculty_name;
	String Password3;
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faculty(int faculty_id, String faculty_name, String password3) {
		super();
		Faculty_id = faculty_id;
		Faculty_name = faculty_name;
		Password3 = password3;
	}
	public int getFaculty_id() {
		return Faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		Faculty_id = faculty_id;
	}
	public String getFaculty_name() {
		return Faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		Faculty_name = faculty_name;
	}
	public String getPassword3() {
		return Password3;
	}
	public void setPassword3(String password3) {
		Password3 = password3;
	}
	@Override
	public String toString() {
		return "Faculty [Faculty_id=" + Faculty_id + ", Faculty_name=" + Faculty_name + ", Password3=" + Password3
				+ "]";
	}
	
}
