package com.studentmanagement.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SchoolEmployeeOperations {
	

		DatabaseConnectivity ob=new DatabaseConnectivity();
		Connection conn=ob.dbConnection();
		
		public boolean login(int eid,String password) throws SQLException 
		{
			
			PreparedStatement ps=conn.prepareStatement("select * from school_employee where emp_id=? && password=?");
			ps.setInt(1, eid);
			ps.setString(2, password);
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
		public boolean openstudentProfile(long studentid,String studentname,String address,long phone,String admittingclass,double tutionfee,String password1) throws SQLException
		{
			PreparedStatement ps=conn.prepareStatement("insert into student_details values(?,?,?,?,?,?,?)");
			ps.setLong(1, studentid);
			ps.setString(2, studentname);
			ps.setString(3, address);
			ps.setLong(4, phone);
			ps.setString(5,admittingclass);
			ps.setDouble(6,tutionfee);
			ps.setString(7, password1);
			
			int affectedRows=ps.executeUpdate();
			
			if(affectedRows>0)
				return true;
			else
				return false;
		}
		public boolean deleteProfile(long proId) throws SQLException
		{
			PreparedStatement ps=conn.prepareStatement("delete from bank_user where student_id=?");
			ps.setLong(1, proId);
			int affectedRows=ps.executeUpdate();
			if(affectedRows>0)
				return true;
			else
				return false;
		}
		public ResultSet studentInfoCheck(long proId) throws SQLException	
		{
			PreparedStatement ps=conn.prepareStatement("select * from student_details where student_id=?");
			ps.setLong(1, proId);
			ResultSet result=ps.executeQuery();
			return result;
		}
		
}
