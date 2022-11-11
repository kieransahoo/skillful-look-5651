package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.bean.Seller;
import com.app.utility.DBUtil;

public class SellerDaoImpl implements SellerDao{

	@Override
	public String registerSeller(Seller seller) {
		String message = "Seller Registered Successfully";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Seller(sname,semail,spassword) value(?,?,?)");
			ps.setString(1, seller.getSname());
			ps.setString(2, seller.getSemail());
			ps.setString(3, seller.getSpassword());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Seller Registered Successfully !";
			
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String loginSeller(String email, String password) {
		String message = "Invalid username or password";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from seller where semail=? AND spassword=?");
			
			ps.setString(1,email);
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
