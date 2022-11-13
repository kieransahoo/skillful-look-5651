package com.app.dao;

import java.util.List;

import com.app.bean.Bidding;
import com.app.bean.Buyer;
import com.app.bean.Seller;
import com.app.bean.Sold;
import com.app.exceptions.AdminException;
import com.app.exceptions.BuyerException;
import com.app.exceptions.SellerException;

public interface AdminDao {

	public String loginAdmin(String username,String password) throws AdminException;
	
	public List<Buyer> ViewBuyerList() throws BuyerException;
	
	public List<Seller> ViewSellerList() throws SellerException;
	
	public List<Sold> ViewSellingReport();
	
	public List<Bidding> ViewBiddingList();
}
