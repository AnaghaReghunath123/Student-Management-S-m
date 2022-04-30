package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity 
{
	
public Connection dbConnection()
{
	

	{
		Connection conn=null;
		
		String databaseUrl="jdbc:mysql://localhost:3306/studentmanagementsystem";
		String userName="root";
		String userPassword="Anagha@123";
		
		
			try {
				conn=DriverManager.getConnection(databaseUrl, userName, userPassword);
			} 
			
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			return conn;

	}

}
}
