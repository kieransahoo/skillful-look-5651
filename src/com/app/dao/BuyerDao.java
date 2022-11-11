package com.app.dao;

import com.app.bean.Buyer;

public interface BuyerDao {
	public String registerBuyer(Buyer buyer);
	
	public String loginBuyer(String email,String password);
}
