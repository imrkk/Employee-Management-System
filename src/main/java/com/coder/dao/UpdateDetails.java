package com.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.coder.beans.AddEmpDetails;

public class UpdateDetails {
	
	public static int update(AddEmpDetails e) {
		
		int status = 0;
		
		try {
			Connection con = GetConDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update EmpDetailsTable set name=?,password=?,email=?,address=?,city=?,country=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());		//calling from "AddEmpDetails" where we have made getter and setter
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getAddress());
			ps.setString(5, e.getCity());
			ps.setString(6, e.getCountry());
			ps.setInt(7, e.getId());
			
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		
		return status;
	}

}
