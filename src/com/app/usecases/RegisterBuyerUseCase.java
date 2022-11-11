package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Buyer;
import com.app.dao.BuyerDao;
import com.app.dao.BuyerDaoImpl;


public class RegisterBuyerUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Buyer Name : ");
		String bname = sc.next();
		
		
		System.out.println("Enter Buyer Email : ");
		String bemail = sc.next();
		
		System.out.println("Enter Buyer Password : ");
		String bpassword = sc.next();
		
		BuyerDao dao = new BuyerDaoImpl();
		

		Buyer buyer = new Buyer();
		
		
		buyer.setBname(bname);
		buyer.setBemail(bemail);
		buyer.setBpassword(bpassword);
		
		
		String result = dao.registerBuyer(buyer);
		
		System.out.println(result);

	}

}
