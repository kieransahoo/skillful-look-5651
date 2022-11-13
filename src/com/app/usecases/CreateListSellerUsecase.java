package com.app.usecases;

import java.util.List;

import com.app.bean.Product;
import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;
import com.app.exceptions.ProductException;

public class CreateListSellerUsecase {

	public static void main(String[] args) throws ProductException {
		SellerDao dao = new SellerDaoImpl();
		
		List<Product> pList = dao.CreateListOfProduct();
		
		pList.forEach(p -> {
			System.out.println("==============================================");
			System.out.println("ProductID : "+p.getProductId());
			System.out.println("ProductName : "+p.getProductName());
			System.out.println("ProductPrice : "+p.getProductPrice());
			System.out.println("ProductCategory : "+p.getProductcategory());
			System.out.println("ProductQuantity : "+p.getProductQuantity());
			
		});
		

	}

}
