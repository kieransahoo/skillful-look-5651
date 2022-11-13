package com.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Bidding;
import com.app.bean.Buyer;
import com.app.bean.Seller;
import com.app.bean.Sold;
import com.app.exceptions.AdminException;
import com.app.exceptions.BuyerException;
import com.app.exceptions.SellerException;
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

	@Override
	public List<Buyer> ViewBuyerList() throws BuyerException {
		List<Buyer> bList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("bid");
				String name = rs.getString("bname");
				String email = rs.getString("bemail");
				String password = rs.getString("bpassword");
				
				Buyer buyer = new Buyer(id,name,email,password);
				
				bList.add(buyer);
				
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return bList;
	}

	@Override
	public List<Seller> ViewSellerList() throws SellerException {
		
		List<Seller> bList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from seller");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				String email = rs.getString("semail");
				String password = rs.getString("spassword");
				
				Seller seller = new Seller(id,name,email,password);
				
				bList.add(seller);
				
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return bList;
	}

	@Override
	public List<Sold> ViewSellingReport() {
		List<Sold> sList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from sold");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("productId");
				String name = rs.getString("productName");
				int soldprice = rs.getInt("soldPrice");
				int  buyer = rs.getInt("buyerId");
				Date  sDate = rs.getDate("solddate");
				
				Sold sp = new Sold(id,name,soldprice,buyer,sDate);
				
				sList.add(sp);
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return sList;
	}

	@Override
	public List<Bidding> ViewBiddingList() {
		List<Bidding> bList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bidding");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int productId = rs.getInt("productId");
				int buyerId = rs.getInt("buyerId");
				int bidprice = rs.getInt("bidPrice");
				
				
				Bidding bidding = new Bidding(productId,buyerId,bidprice);
				
				bList.add(bidding);
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return bList;
	}

}
