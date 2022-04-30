package com.studentmanagement.model;

public class Sudent {
	int Student_id;
	String Student_name;
	String Student_address;
	long Phone_number;
	double Tution_fee;
	String Password1;
	
	public Sudent() {
		super();
		
	}
	public Sudent(int student_id, String student_name, String student_address, long phone_number, double tution_fee,
			String password1) {
		super();
		Student_id = student_id;
		Student_name = student_name;
		Student_address = student_address;
		Phone_number = phone_number;
		Tution_fee = tution_fee;
		Password1 = password1;
	}
	public int getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getStudent_address() {
		return Student_address;
	}
	public void setStudent_address(String student_address) {
		Student_address = student_address;
	}
	public long getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(long phone_number) {
		Phone_number = phone_number;
	}
	public double getTution_fee() {
		return Tution_fee;
	}
	public void setTution_fee(double tution_fee) {
		Tution_fee = tution_fee;
	}
	public String getPassword1() {
		return Password1;
	}
	public void setPassword(String password1) {
		Password1 = password1;
	}
	
}