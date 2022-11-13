package com.app.usecases;

import java.util.Scanner;

import com.app.dao.BuyerDao;
import com.app.dao.BuyerDaoImpl;
import com.app.exceptions.ProductException;

public class SearchproductBuyerUseCase {

	public static void main(String[] args) throws ProductException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Category : ");
		String category = sc.next();
		
		BuyerDao dao = new BuyerDaoImpl();
		
		System.out.println(dao.Searchproduct(category));

	}

}
