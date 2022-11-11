package com.app.usecases;

import java.util.Scanner;

import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;
import com.app.exceptions.SellerException;

public class SellerLoginUseCase {

	public static void main(String[] args) throws SellerException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Seller Email : ");
		String email = sc.next();
		
		System.out.println("Enter Seller password : ");
		String password = sc.next();

		
		SellerDao dao = new SellerDaoImpl();
		
		dao.loginSeller(email, password);
		
		System.out.println("Welcome Seller.....!");
	}

}


