package com.app.usecases;

import java.util.Scanner;

import com.app.dao.BuyerDao;
import com.app.dao.BuyerDaoImpl;

public class BuyerLoginUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Buyer Email : ");
		String email = sc.next();
		
		System.out.println("Enter Buyer password : ");
		String password = sc.next();

		
		BuyerDao dao = new BuyerDaoImpl();
		
		dao.loginBuyer(email, password);
		
		System.out.println("Welcome Buyer.....!");

	}

}
