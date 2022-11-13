package com.app.usecases;

import java.util.List;

import com.app.bean.Seller;
import com.app.dao.AdminDao;
import com.app.dao.AdminDaoImpl;
import com.app.exceptions.SellerException;

public class ViewSellerListUseCase {

	public static void main(String[] args) throws SellerException {
		AdminDao dao = new AdminDaoImpl();
		
		List<Seller> sList = dao.ViewSellerList();
		
		sList.forEach(s-> 
						System.out.println("SellerId : "+s.getSid() + "| Seller Name : "+s.getSname() + "| Seller Email : " + s.getSemail()));

	}

}
