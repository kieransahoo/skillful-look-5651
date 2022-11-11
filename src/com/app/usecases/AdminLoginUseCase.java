package com.app.usecases;

import java.util.Scanner;

import com.app.dao.AdminDao;
import com.app.dao.AdminDaoImpl;
import com.app.exceptions.AdminException;

public class AdminLoginUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin Username : ");
		String username = sc.next();
		
		System.out.println("Enter Admin password : ");
		String password = sc.next();

		AdminDao dao = new AdminDaoImpl();
		
		try {
			dao.loginAdmin(username, password);
			
			System.out.println("Welcome Admin....");
//			HODOptions.main(args);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}

	}

}
