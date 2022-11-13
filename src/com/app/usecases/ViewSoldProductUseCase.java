package com.app.usecases;

import java.util.List;

import com.app.bean.Product;
import com.app.bean.Sold;
import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;

public class ViewSoldProductUseCase {

	public static void main(String[] args) {
		SellerDao dao = new SellerDaoImpl();
		
		List<Sold> sList = dao.ViewSoldProduct();
		
		sList.forEach(s -> {
			System.out.println("==============================================");
			System.out.println("ProductID : "+s.getProductID());
			System.out.println("ProductName : "+s.getProductName());
			System.out.println("ProductPrice : "+s.getPrice());
			System.out.println("BuyerId : "+s.getBuyerId());
			System.out.println("Sold Date : "+s.getSoldDate());
			
		});

	}

}
