package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.bean.Buyer;
import com.app.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public String registerBuyer(Buyer buyer) {
		String message = "Buyer Registered Successfully";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Buyer(bname,bemail,bpassword) value(?,?,?)");
			ps.setString(1, buyer.getBname());
			ps.setString(2, buyer.getBemail());
			ps.setString(3, buyer.getBpassword());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Buyer Registered Successfully !";
			
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String loginBuyer(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
