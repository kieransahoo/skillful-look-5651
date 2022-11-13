package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Bidding;
import com.app.dao.BuyerDao;
import com.app.dao.BuyerDaoImpl;


public class BidProductToBuyUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id  : ");
		int pid = sc.nextInt();
		
		
		System.out.println("Enter Your  BuyerId : ");
		int buyerId = sc.nextInt();
		
		System.out.println("Enter Your Bid Price : ");
		int  bidprice = sc.nextInt();
		
		BuyerDao dao = new BuyerDaoImpl();
		

		Bidding bidding = new Bidding();
		
		bidding.setProductId(pid);
		bidding.setBuyerId(buyerId);
		bidding.setBidPrice(bidprice);
		
		String result = dao.BidProductToBuy(bidding);
		
		System.out.println(result);

	}

}
