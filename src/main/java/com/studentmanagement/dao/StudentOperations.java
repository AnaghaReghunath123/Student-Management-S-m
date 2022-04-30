package com.studentmanagement.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentOperations {

			DatabaseConnectivity ob1=new DatabaseConnectivity();
			Connection conn=ob1.dbConnection();
			
			public boolean login(long sid,String password1) throws SQLException 
			{
				
				PreparedStatement ps=conn.prepareStatement("select * from student_details where student_id=? && password1=?");
				ps.setLong(1, sid);
				ps.setString(2, password1);
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
			public ResultSet profilecheck(long proId) throws SQLException	
			{
				PreparedStatement ps=conn.prepareStatement("select * from student_details where student_id=?");
				ps.setLong(1, proId);
				ResultSet result=ps.executeQuery();
				return result;
			}
			public ResultSet marksheetInfo(long proId) throws SQLException	
			{
				PreparedStatement ps=conn.prepareStatement("select * from student_marksheet where student_id=?");
				ps.setLong(1, proId);
				ResultSet result=ps.executeQuery();
				return result;
			}
			public ResultSet AttendanceInfo(long proId) throws SQLException	
			{
				PreparedStatement ps=conn.prepareStatement("select * from student_marksheet where student_id=?");
				ps.setLong(1, proId);
				ResultSet result=ps.executeQuery();
				return result;
			}
}
