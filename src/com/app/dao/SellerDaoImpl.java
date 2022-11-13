package com.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Product;
import com.app.bean.Seller;
import com.app.bean.Sold;
import com.app.exceptions.ProductException;
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

	@Override
	public List<Product> CreateListOfProduct() throws ProductException {
		List<Product> pList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from product");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("productId");
				String name = rs.getString("productName");
				int baseprice = rs.getInt("productPrice");
				String category = rs.getString("productcategory");
				int quantity = rs.getInt("productQuantity");
				
				Product p = new Product(id,name,baseprice,category,quantity);
				
				pList.add(p);
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public String UpdateProduct(Product product) {
		String message = "Invalid Product ID !";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update product set productName = ? ,productPrice = ? , productcategory = ? , productQuantity = ? where productId = ?");
			
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getProductPrice());
			ps.setString(3, product.getProductcategory());
			ps.setInt(4, product.getProductQuantity());
			ps.setInt(5, product.getProductId());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Product Updated Successfully !";
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return message;
		
		
		
	}

	@Override
	public String AddnewItem(Product product) {
		String message = "Product Cannot be added , Invalid Details !";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into product(productName,productPrice, productcategory, ProductQuantity) value(?, ?, ?,?) ");
			
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getProductPrice());
			ps.setString(3, product.getProductcategory());
			ps.setInt(4, product.getProductQuantity());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Product Added Successfully !";
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String RemoveProductFromList(int id) {
		String message = "Invalid Product Id ";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from product where productId=?");
			
			ps.setInt(1, id);
			int x = ps.executeUpdate();
			if(x>0)
				message = "Product Removed Successfully !";
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<Sold> ViewSoldProduct() {
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
	
}
