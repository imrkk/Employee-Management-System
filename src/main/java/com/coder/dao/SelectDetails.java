package com.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coder.beans.AddEmpDetails;

public class SelectDetails {
	
	//employee details by specific id
	public static AddEmpDetails getEmployeeById(int id) {
		
		AddEmpDetails e = new AddEmpDetails();
		
		try {
			Connection con = GetConDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from EmployeeDetailsTable where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				e.setId(rs.getInt(1));        // by the help of getter and setter
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setCity(rs.getString(6));
				e.setCountry(rs.getString(7));
			}
			con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return e;
		
	}
	
	//all employee details
	public static List<AddEmpDetails> getAllEmployees(){
		
		List<AddEmpDetails> list = new ArrayList<AddEmpDetails>();
		
		try {
			Connection con = GetConDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from EmployeeDetailsTable");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				AddEmpDetails e = new AddEmpDetails();	
				e.setId(rs.getInt(1));        // by the help of getter and setter
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setCity(rs.getString(6));
				e.setCountry(rs.getString(7));
				
				list.add(e);
			}
			con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return list;
	}
	

}
