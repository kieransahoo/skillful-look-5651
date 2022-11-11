package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.exceptions.AdminException;
import com.app.utility.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String loginAdmin(String username, String password) throws AdminException {
		String message = "Invalid username or password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where username=? AND password=?");
			
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				message = "Login Successfull";
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return message;
	}

}
