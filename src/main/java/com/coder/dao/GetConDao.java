package com.coder.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "123456789";
			con = DriverManager.getConnection(url,username,password);
			
			if(con.isClosed()) {
				System.out.println("Connection is closed");
			}else {
				System.out.println("Connection is created");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
		
	}
	


}
