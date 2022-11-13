package com.app.dao;

import java.util.List;

import com.app.bean.Product;
import com.app.bean.Seller;
import com.app.bean.Sold;
import com.app.exceptions.AdminException;
import com.app.exceptions.ProductException;

public interface SellerDao {
	
//	Register himself or herself as seller.
	public String registerSeller(Seller seller);
	
	public String loginSeller(String email,String password);
	
	
	
//	Create list of items to sell.
	public List<Product> CreateListOfProduct() throws ProductException;
//
//	Update Item price, quantity, etc.
	public String UpdateProduct(Product product) throws ProductException;
//
//	Add new Item in the list.
	public String AddnewItem(Product product) throws ProductException;
//
//	Remove items from the list.
	public String RemoveProductFromList(int id) throws ProductException;

//	View the sold Item history.
	public List<Sold> ViewSoldProduct();
}
