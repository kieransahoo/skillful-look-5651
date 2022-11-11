package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Seller;
import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;

public class RegisterSellerUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Seller Name : ");
		String sname = sc.next();
		
		
		System.out.println("Enter Seller Email : ");
		String semail = sc.next();
		
		System.out.println("Enter Seller Password : ");
		String spassword = sc.next();
		
		SellerDao dao = new SellerDaoImpl();
		

		Seller seller = new Seller();
		
		seller.setSname(sname);
		seller.setSemail(semail);
		seller.setSpassword(spassword);
		
		String result = dao.registerSeller(seller);
		
		System.out.println(result);


	}

}
