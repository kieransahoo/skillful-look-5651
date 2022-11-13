package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Product;
import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;

public class AddNewItemUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the Product Name : ");
		String pname = sc.nextLine();
		
		System.out.println("Enter Minimum Product Price : ");
		int pprice = sc.nextInt();
	
		System.out.println("Enter Product Category : ");
		String pcategory = sc.next();
		
		
		
		System.out.println("Enter Product Quantity : ");
		int pQuantity = sc.nextInt();
		
		try{
			Product product = new Product();
			product.setProductName(pname);
			product.setProductPrice(pprice);
			product.setProductcategory(pcategory);
			product.setProductQuantity(pQuantity);
			
			SellerDao dao = new SellerDaoImpl();
			
			System.out.println(dao.AddnewItem(product));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
