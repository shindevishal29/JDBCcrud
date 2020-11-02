package com.hefshine.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {

	

	public void employeeCreate() {
	
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/vishal001";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);  
			
			String sql="insert into employee_table (id,name,age) values(?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,104);
			stmt.setString(2, "vishal");
			stmt.setInt(3, 24);
			
			int rowInserted= stmt.executeUpdate();
			if(rowInserted>0)
				System.out.println("A new row inserted sucessfully");
	        
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void employeeRead(){
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/vishal001","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select* from employee_table");
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			con.close();
			}
			
			catch(Exception e)
			{System.out.println(e);}}
	
	public void employeeUpdate()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/vishal001","root","root");
		
		String sql="update Employee_table set age=?, name=? where id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, 25);
		stmt.setString(2, "tushar");
		stmt.setInt(3, 104);
		
		int rowsUpdated = stmt.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
	} }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void employeeDelete()
	{
		try{Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/vishal001","root","root");
	
	String sql="delete from employee_table where id=?";
	PreparedStatement stmt=con.prepareStatement(sql);
	stmt.setInt(1,101);
	
	int rowsDeleted = stmt.executeUpdate();
	if (rowsDeleted > 0) {
	    System.out.println("A user was deleted successfully!");
	}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
