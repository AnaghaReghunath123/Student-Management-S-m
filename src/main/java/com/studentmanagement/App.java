package com.studentmanagement;

import java.sql.ResultSet;
import java.util.Scanner;

import com.studentmanagement.dao.FacultyOperation;
import com.studentmanagement.dao.SchoolEmployeeOperations;
import com.studentmanagement.dao.StudentOperations;

public class App 
{
    public static void main( String[] args )
    {
    	boolean status=true;
    	try
    	{
    		do
    		{
        Scanner scan=new Scanner(System.in);
        System.out.println("=======================================================================");
        System.out.println("                            Welcome to XYZ School                        ");
        System.out.println("=======================================================================");
        System.out.println("1 -> School Employee");
        System.out.println("2 -> Student");
        System.out.println("3 -> Faculty");
        System.out.println("Enter your user type:");
        int userType=scan.nextInt();
        
        if(userType==1)
        {
        	
        	System.out.println("Enter your Employee id:");
        	int eid=scan.nextInt();
        	System.out.println("Enter Password:");
        	String password=scan.next();
        	
        	SchoolEmployeeOperations ob=new SchoolEmployeeOperations();
        	//System.out.println(ob.login(eid, password));
        	if(ob.login(eid, password))
        	{
                System.out.println("=======================================================================");
        		System.out.println("Login successfull!!");
                System.out.println("=======================================================================");
        		System.out.println("1.Create New Student Profile\r\n"
        				+ "2.Delete Student Profile\r\n"
        				+ "3.View Student Datails\r\n"
        				+ "4.Update Student Details\r\n");
        	int op=scan.nextInt();
        	if(op==1)
        	{
        		System.out.println("Enter Student Id for the new user:");
        		long studentid=scan.nextLong();
        		System.out.println("Enter Student Name:");
        		String studentname=scan.next();
        		System.out.println("Enter Student address:");
        		String address=scan.next();
        		System.out.println("Enter phone number:");
        		long phone=scan.nextLong();
        		System.out.println("Enter Admission Class of new student:");
        		String admittingclass=scan.next();
        		System.out.println("Enter Tution fee of student:");
        		double tutionfee=scan.nextDouble();
        		System.out.println("Set Password for the new student :");
        		String password1=scan.next();
        		if(ob.openstudentProfile(studentid,studentname,address,phone,admittingclass,tutionfee,password1))
        		{
                    System.out.println("=======================================================================");
        			System.out.println("Account created successfully!!");
                    System.out.println("=======================================================================");

        		}
        		else
        		{   System.out.println("=======================================================================");
        			System.out.println("Problem in account creation!!");
                    System.out.println("=======================================================================");

        		}
        	}
        	else if(op==2)
        	{
        		System.out.println("Enter the Student Id for deleting profile:");
        		long proId=scan.nextLong();
        		if(ob.deleteProfile(proId))
        		{
        			System.out.println("Profile Deleted successfully!!");
        		}
        		else
        		{
        			System.out.println("Problem occurred!!");
        		}
        	}
        	else if(op==3)
        	{
        		System.out.println("Enter Student Id to check the Information:");
        		long proId=scan.nextLong();
        		ResultSet result=ob.studentInfoCheck(proId);
        		while(result.next())
        		{
        			System.out.println("=======================================================================");
        			System.out.println("--- Student Details ----");
                    System.out.println("=======================================================================");

        			System.out.println("Student Name :"+result.getString(2));
        			System.out.println("Student Address :"+result.getString(3));
        			System.out.println("Student Phone number :"+result.getLong(4));
        			System.out.println("Class :"+result.getString(5));
        			System.out.println("Tution Fees:"+result.getDouble(6));
        			
        		}
        	}
        	
        }
        }
        	else if(userType==2)
            {
            	System.out.println("Enter your Student id:");
            	long sid=scan.nextLong();
            	System.out.println("Enter Password:");
            	String password1=scan.next();
            	
            	StudentOperations ob1=new StudentOperations();
            	
            	if(ob1.login(sid, password1))
            	{
            		System.out.println("=======================================================================");
            		System.out.println("Login Successfull!!");
            		System.out.println("=======================================================================");

            		System.out.println("1.View My Profile\r\n"
            				+ "2.View My MarkSheet\r\n"
            				+ "3.View Tution Fee");
            		int operation=scan.nextInt();
            		
            	
            	if(operation==1)
        		{
        			
            		System.out.println("Enter your Student Id to check the Information:");
            		long proId=scan.nextLong();
            		ResultSet result=ob1.profilecheck(proId);
            		while(result.next())
            		{
            			System.out.println("=======================================================================");
            			System.out.println("--- My Profile ----");
                        System.out.println("=======================================================================");

            			System.out.println("Name :"+result.getString(2));
            			System.out.println("Address :"+result.getString(3));
            			System.out.println("Phone number :"+result.getLong(4));
            			System.out.println("Class :"+result.getString(5));
            			System.out.println("Tution Fees:"+result.getDouble(6));
            			
            		}
        			
        		}
        		else if(operation==2)
        		{
        			
        			
        			System.out.println("Enter your Student Id to check the MarkSheet:");
            		long proId=scan.nextLong();
            		ResultSet result=ob1.marksheetInfo(proId);
            		while(result.next())
            		{
            			System.out.println("=======================================================================");
            			System.out.println("--- My MarkSheet ----");
                        System.out.println("=======================================================================");

            			System.out.println("Name :"+result.getString(2));
            			System.out.println("Maths Marks :"+result.getString(3));
            			System.out.println(" Science Marks:"+result.getLong(4));
            			System.out.println("English Marks :"+result.getString(5));          			
            			
            		}
        			
        			
        		}
        		else if(operation==3)
        		{
        			System.out.println("Enter your Student Id to check the Attendance:");
            		long proId=scan.nextLong();
            		ResultSet result=ob1.AttendanceInfo(proId);
            		while(result.next())
            		{
            			System.out.println("=======================================================================");
            			System.out.println("--- My MarkSheet ----");
                        System.out.println("=======================================================================");

            			System.out.println("Name :"+result.getString(2));
            			System.out.println("Attendance :"+result.getString(6));
        			
        			
            		}
        		}
            	}
            }
        		else if(userType==3)
                {
                	System.out.println("Enter your Faculty id:");
                	long fid=scan.nextLong();
                	System.out.println("Enter Password:");
                	String password2=scan.next();
                	
                	FacultyOperation ob2=new FacultyOperation();
                	
                	if(ob2.login(fid, password2))
                	{
                		System.out.println("=======================================================================");
                		System.out.println("Login Successfull!!");
                		System.out.println("=======================================================================");

                		System.out.println("1.Add Data to Marksheet\r\n"
                				+ "2.Update Marksheet\r\n"
                				+ "3.View Student Details\r\n"
                				+ "4.view marksheet");
                		int operationf=scan.nextInt();
                		
                		if(operationf==1)
                		{
                			System.out.println("Enter Student Id for the new student:");
                    		long studentid=scan.nextLong();
                    		System.out.println("Enter Student Name:");
                    		String studentname=scan.next();
                    		System.out.println("Enter Maths Marks ");
                    		long Maths=scan.nextLong();
                    		System.out.println("Enter Science Marks:");
                    		long Science=scan.nextLong();
                    		System.out.println("Enter English marks:");
                    		long English=scan.nextLong();
                    		System.out.println("Enter Attendance Percentage of student:");
                    		double Attendance=scan.nextDouble();
                    	
                    		if(ob2.newstudentmarklist(studentid,studentname,Maths,Science,English,Attendance))
                    		{
                                System.out.println("=======================================================================");
                    			System.out.println("Account created successfully!!");
                                System.out.println("=======================================================================");

                    		}
                    		else
                    		{   System.out.println("=======================================================================");
                    			System.out.println("Problem in account creation!!");
                                System.out.println("=======================================================================");

                    		}
                    	}
                		if(operationf==2)
                		{
                			System.out.println("Enter the Student Id to update:");
                			long studentid=scan.nextLong();
                			System.out.println("1.Update Maths Mark\r\n"
                					+ "2. Update Science Marks\r\n"
                					+ "3. Update English Marks\r\n"
                					+ "4. Change Attendance");
                			int subject=scan.nextInt();
                			if(subject==1)
                			{	
                			System.out.println("Enter your New Maths Mark:");
                    		long newMaths=scan.nextLong();
                    			if(ob2.changemaths(studentid, newMaths))
                    				{
                    					System.out.println("Maths Mark Changed Successfully!!");
                    				}
                    			else
                    				{
                    					System.out.println("Problem in update!!");
                    				}
                			}
                    		else if(subject==2)
                    		{
                    		System.out.println("Enter your New Science Mark:");
                        	long newScience=scan.nextLong();
                        		if(ob2.changescience(studentid, newScience))
                        			{
                        				System.out.println("Science Mark Changed Successfully!!");
                        			}
                        		else
                        			{
                        				System.out.println("Problem in update!!");
                        			}
                    			
                    		}
                    		else if(subject==3)
                    		{
                    			System.out.println("Enter your New English Mark:");
                            	long newEnglish=scan.nextLong();
                            		if(ob2.changeenglish(studentid, newEnglish))
                            			{
                            				System.out.println("Science Mark Changed Successfully!!");
                            			}
                            		else
                            			{
                            				System.out.println("Problem in update!!");
                            			}
                    		}
                    		else if(subject==4)
                    		{
                    			System.out.println("Enter your New Attendance Percentage:");
                            	long newAttendance=scan.nextLong();
                            		if(ob2.changeattendance(studentid, newAttendance))
                            			{
                            				System.out.println("Attendance Changed Successfully!!");
                            			}
                            		else
                            			{
                            				System.out.println("Problem in update!!");
                            			}
                    		}
                    	}
                	
                	
                	if(operationf==3)
                	{
                		System.out.println("Enter Student Id to view Student Details:");
                		long studentid=scan.nextLong();
                		ResultSet result=ob2.viewStudentdetails(studentid);
                		while(result.next())
                		{
                			System.out.println("=======================================================================");
                			System.out.println("--- Student Details ----");
                            System.out.println("=======================================================================");

                			System.out.println("Student Name :"+result.getString(2));
                			System.out.println("Student Address :"+result.getString(3));
                			System.out.println("Student Phone number :"+result.getLong(4));
                			System.out.println("Class :"+result.getString(5));
                			System.out.println("Tution Fees:"+result.getDouble(6));
                			
                		}
                			
                	}
                	if(operationf==4)
                	{
                		System.out.println("Enter Student Id to view Marksheet:");
                		long studentid=scan.nextLong();
                		ResultSet result=ob2.viewStudentdetails(studentid);
                		while(result.next())
                		{
                			System.out.println("=======================================================================");
                			System.out.println("--- Student Details ----");
                            System.out.println("=======================================================================");

                			System.out.println("Student Name :"+result.getString(2));
                			System.out.println("Maths Mark :"+result.getString(3));
                			System.out.println("Science mark :"+result.getLong(4));
                			System.out.println("English Mark:"+result.getString(5));
                			System.out.println("Attendance Percentage:"+result.getDouble(6));
                			
                		}
                			
                	}
                
                	}
                }
        		else
            	{
            		System.out.println("=======================================================================");
            		System.out.println("Wrong Id or password!!");
            		System.out.println("=======================================================================");

            	}
            	
    		
        	
            	}
    	
    	
        while(status=true);
    
    		}	
    		
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    		
        
    		
    	}
    }


