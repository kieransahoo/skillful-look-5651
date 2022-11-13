package com.app.usecases;

import java.util.List;

import com.app.bean.Buyer;
import com.app.dao.AdminDao;
import com.app.dao.AdminDaoImpl;
import com.app.exceptions.BuyerException;

public class ViewAllBuyerUseCase {

	public static void main(String[] args) throws BuyerException {
		
		AdminDao dao = new AdminDaoImpl();
		
		List<Buyer> bList = dao.ViewBuyerList();
		
		bList.forEach(b-> 
						System.out.println("BuyerId : "+b.getBid() + "| Buyer Name : "+b.getBname() + "| Buyer Email : " + b.getBemail()));

	}

}
