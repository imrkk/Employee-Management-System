package com.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.coder.beans.AddEmpDetails;

public class SaveDetails {
	
	public static int save(AddEmpDetails e) {
		int status = 0;
		
		try {
			Connection con = GetConDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into EmpDetailsTable(name,password,email,address,city,country)values(?,?,?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());		//calling from "AddEmpDetails" where we have made getter and setter
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getAddress());
			ps.setString(5, e.getCity());
			ps.setString(6, e.getCountry());
			
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
			
		
		return status;
	}

}
