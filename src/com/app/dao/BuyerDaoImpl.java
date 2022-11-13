package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Bidding;
import com.app.bean.Buyer;
import com.app.bean.Product;
import com.app.exceptions.ProductException;
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

	@Override
	public List<Product> Searchproduct(String category) throws ProductException {
		List<Product> pList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from product where productcategory = ?");
			
			ps.setString(1, category);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("productId");
				String name = rs.getString("productName");
				int baseprice = rs.getInt("productPrice");
				String pcategory = rs.getString("productcategory");
				int quantity = rs.getInt("productQuantity");
				
				Product p = new Product(id,name,baseprice,pcategory,quantity);
				
				pList.add(p);
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public String BidProductToBuy(Bidding bidding) {
		String message = "Invalid Bidding !";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into bidding value(?,?,?)");
			
			ps.setInt(1, bidding.getProductId());
			ps.setInt(2, bidding.getBuyerId());
			ps.setInt(3, bidding.getBidPrice());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Bidding Place Successfully !";
			
			
		}catch(SQLException e) {
			
			message = e.getMessage();
		}
		
		return message;
	}

	

}

