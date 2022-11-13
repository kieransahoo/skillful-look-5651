package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Product;
import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;

public class UpdateProductSellerUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product id to update :");
		int id = sc.nextInt();
		
		System.out.println("Enter update product Name  :");
		String name  = sc.next();
		
		System.out.println("Enter update product Price  :");
		int price = sc.nextInt();
		
		System.out.println("Enter update product Category  :");
		String category = sc.next();
		
		System.out.println("Enter update product Quantity  :");
		int quantity = sc.nextInt();
		
		try{
			Product product = new Product();
			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductcategory(category);
			product.setProductQuantity(quantity);
			product.setProductId(id);
			
			SellerDao dao = new SellerDaoImpl();
			
			System.out.println(dao.UpdateProduct(product));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		

	}

}
