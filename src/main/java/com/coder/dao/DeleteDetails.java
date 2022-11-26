package com.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDetails {
	
	public static int delete (int id) {
		
		int status = 0;
		
		try {
			Connection con = GetConDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from EmpDetailsTable where id=?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		return status;
	}

}
