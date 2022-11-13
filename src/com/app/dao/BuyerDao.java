package com.app.dao;

import java.util.List;

import com.app.bean.Bidding;
import com.app.bean.Buyer;
import com.app.bean.Product;
import com.app.exceptions.ProductException;

public interface BuyerDao {
	public String registerBuyer(Buyer buyer);
	
	public String loginBuyer(String email,String password);
	
	public List<Product> Searchproduct(String category) throws ProductException;
	
	public String BidProductToBuy(Bidding bidding);
}
