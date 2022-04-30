package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyOperation {
	DatabaseConnectivity ob2=new DatabaseConnectivity();
	Connection conn=ob2.dbConnection();
	

	public boolean login(long fid,String password3) throws SQLException 
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from faculty_list where faculty_id=? && password3=?");
		ps.setLong(1, fid);
		ps.setString(2, password3);
		ResultSet result=ps.executeQuery();
		
		
			if(result.next())
			{
				return true; 
			}
			else
			{
				return false;
			}

}
	public boolean newstudentmarklist(long studentid,String studentname,long Maths,long Science,long English,double Attendance) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("insert into student_marksheet values(?,?,?,?,?,?,?)");
		ps.setLong(1, studentid);
		ps.setString(2, studentname);
		ps.setLong(3, Maths);
		ps.setLong(4, Science);
		ps.setLong(5,English);
		ps.setDouble(6,Attendance);
		
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	public boolean changemaths(long studentid,long newMaths) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update student_marksheet set Maths=? where student_id=? ");
		ps.setLong(1, newMaths);
		ps.setLong(2, studentid);
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	public boolean changescience(long studentid,long newScience) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update student_marksheet set Science=? where student_id=? ");
		ps.setLong(1, newScience);
		ps.setLong(2, studentid);
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	public boolean changeenglish(long studentid,long newEnglish) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update student_marksheet set English=? where student_id=? ");
		ps.setLong(1, newEnglish);
		ps.setLong(2, studentid);
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	public boolean changeattendance(long studentid,long newAttendance) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update student_marklist set Attendance=? where student_id=? ");
		ps.setLong(1, newAttendance);
		ps.setLong(2, studentid);
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	public ResultSet viewMarksheet(long studentid) throws SQLException	
	{
		PreparedStatement ps=conn.prepareStatement("select * from student_marksheet where student_id=?");
		ps.setLong(1, studentid);
		ResultSet result=ps.executeQuery();
		return result;
	}
	public ResultSet viewStudentdetails(long studentid) throws SQLException	
	{
		PreparedStatement ps=conn.prepareStatement("select * from student_details where student_id=?");
		ps.setLong(1, studentid);
		ResultSet result=ps.executeQuery();
		return result;
	}
}