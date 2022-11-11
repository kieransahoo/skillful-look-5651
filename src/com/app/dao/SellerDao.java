package com.app.dao;

import com.app.bean.Seller;
import com.app.exceptions.AdminException;

public interface SellerDao {
	public String registerSeller(Seller seller);
	
	public String loginSeller(String email,String password);
}
