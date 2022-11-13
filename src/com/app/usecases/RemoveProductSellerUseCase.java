package com.app.usecases;

import java.util.Scanner;

import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;
import com.app.exceptions.ProductException;

public class RemoveProductSellerUseCase {

	public static void main(String[] args) throws ProductException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ProductId : ");
		int id = sc.nextInt();
		
		SellerDao dao = new SellerDaoImpl();
		
		System.out.println(dao.RemoveProductFromList(id));

	}

}
