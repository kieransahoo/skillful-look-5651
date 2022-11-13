package com.app.usecases;

import java.util.List;

import com.app.bean.Bidding;
import com.app.bean.Sold;
import com.app.dao.AdminDao;
import com.app.dao.AdminDaoImpl;


public class ViewBiddingListUseCase {

	public static void main(String[] args) {
		AdminDao dao = new AdminDaoImpl();
		
		List<Bidding> bList = dao.ViewBiddingList();
		
		bList.forEach(b -> {
			System.out.println("Product ID : "+ b.getProductId()+" | "+"Buyer ID : "+b.getBuyerId()+" | "+"Bidding Price : "+ b.getBidPrice());
			
		});

	}

}
