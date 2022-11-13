package com.app.Main;

import java.util.Scanner;

import com.app.dao.AdminDao;
import com.app.dao.AdminDaoImpl;
import com.app.dao.BuyerDao;
import com.app.dao.BuyerDaoImpl;
import com.app.dao.SellerDao;
import com.app.dao.SellerDaoImpl;
import com.app.exceptions.BuyerException;
import com.app.exceptions.ProductException;
import com.app.exceptions.SellerException;
import com.app.usecases.AddNewItemUseCase;
import com.app.usecases.AdminLoginUseCase;
import com.app.usecases.BidProductToBuyUseCase;
import com.app.usecases.BuyerLoginUseCase;
import com.app.usecases.CreateListSellerUsecase;
import com.app.usecases.RegisterBuyerUseCase;
import com.app.usecases.RegisterSellerUseCase;
import com.app.usecases.RemoveProductSellerUseCase;
import com.app.usecases.SearchproductBuyerUseCase;
import com.app.usecases.SellerLoginUseCase;
import com.app.usecases.UpdateProductSellerUseCase;
import com.app.usecases.ViewAllBuyerUseCase;
import com.app.usecases.ViewBiddingListUseCase;
import com.app.usecases.ViewSellerListUseCase;
import com.app.usecases.ViewSoldProductUseCase;

public class Navigation {
	private static AdminDao admin = new AdminDaoImpl();
	private static BuyerDao buyer = new BuyerDaoImpl();
	private static SellerDao seller = new  SellerDaoImpl();
	
	public static void SelectOption(){
		
		boolean choice = true;
		
		while(choice) {
			System.out.println("Select Option to Continue");
			System.out.println("1 . Admin Log In\r\n"
					+ "2 . Seller Log In\r\n"
					+ "3 . Buyer Log In\r\n"
					+ "4 . Register as Buyer\r\n"
					+ "5 . Register as Seller");
			
			Scanner sc = new Scanner(System.in);
			
			int choose = sc.nextInt();
			
			switch(choose) {
				case 1: 
					try {
						AdminLoginUseCase.main(null);
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
						break;
					}
					
					boolean adminchoice = true;
					
					while(adminchoice) {
						System.out.println("Select Option to Continue");
						System.out.println("1.View Buyer List\r\n"
								+ "2.View Seller List\r\n"
								+ "3.View Sold Product List\r\n"
								+ "4.View Bidding Report");
						
						int adminchoose = sc.nextInt();
						
						switch(adminchoose) {
						case 1:
							System.out.println("*-----Buyer List-----*");
							try {
								ViewAllBuyerUseCase.main(null);
							} catch (BuyerException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Do You want to Continue....true/false");
							adminchoice = sc.nextBoolean();
							break;
						case 2 :
							System.out.println("*-----Seller List-----*");
							try {
								ViewSellerListUseCase.main(null);
							} catch (SellerException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Do You want to Continue....true/false");
							adminchoice = sc.nextBoolean();
							break;
						case 3 :
							System.out.println("*-----Sold Product List-----*");
							ViewSoldProductUseCase.main(null);
							System.out.println("Do You want to Continue....true/false");
							adminchoice = sc.nextBoolean();
							break;
						case 4 :
							System.out.println("*-----Bidding List-----*");
							ViewBiddingListUseCase.main(null);
							System.out.println("Do You want to Continue....true/false");
							adminchoice = sc.nextBoolean();
							break;
						default :
							System.out.println("Invalid Option...!");
							System.out.println("Do You want to Continue....true/false");
							adminchoice = sc.nextBoolean();
							break;
						}
					}
					break;
				case 2 :
					try {
						SellerLoginUseCase.main(null);
					} catch (SellerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					boolean sellerchoice = true;
					
					while(sellerchoice) {
						System.out.println("Select Option to Continue");
						System.out.println("1.Create List of Product\r\n"
								+ "2.Update Product\r\n"
								+ "3.Add New Item\r\n"
								+ "4.Remove Product From List\r\n"
								+ "5.View Sold Products");
						
						int sellerchoose = sc.nextInt();
						
						switch(sellerchoose) {
						case 1:
							System.out.println("*-----Create Product List-----*");
							try {
								CreateListSellerUsecase.main(null);
							} catch (ProductException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Do You want to Continue....true/false");
							sellerchoice = sc.nextBoolean();
							break;
						case 2 :
							System.out.println("*-----Update Product-----*");
							UpdateProductSellerUseCase.main(null);
							System.out.println("Do You want to Continue....true/false");
							sellerchoice = sc.nextBoolean();
							break;
						case 3 :
							System.out.println("*-----Add New Product-----*");
							AddNewItemUseCase.main(null);
							System.out.println("Do You want to Continue....true/false");
							sellerchoice = sc.nextBoolean();
							break;
						case 4 :
							System.out.println("*-----Remove Product-----*");
							try {
								RemoveProductSellerUseCase.main(null);
							} catch (ProductException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Do You want to Continue....true/false");
							sellerchoice = sc.nextBoolean();
							break;
						case 5 :
							System.out.println("*-----Sold Product List-----*");
							ViewSoldProductUseCase.main(null);
							System.out.println("Do You want to Continue....true/false");
							sellerchoice = sc.nextBoolean();
							break;
						default :
							System.out.println("Invalid Option...!");
							System.out.println("Do You want to Continue....true/false");
							adminchoice = sc.nextBoolean();
							break;
							
						}
					}
					break;
				case 3:
				BuyerLoginUseCase.main(null);
				
				boolean buyerchoice = true;
				
				while(buyerchoice) {
					System.out.println("Select Option to Continue");
					System.out.println("1.Search Product\r\n"
							+ "2.Bid Product To Buy");
					
					int buyerchoose = sc.nextInt();
					
					switch(buyerchoose) {
					case 1 :
						System.out.println("*-----Search product By Category-----*");
						try {
							SearchproductBuyerUseCase.main(null);
						} catch (ProductException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Do You want to Continue....true/false");
						buyerchoice = sc.nextBoolean();
						break;
					case 2 :
						System.out.println("*-----Bid Product To Buy-----*");
						BidProductToBuyUseCase.main(null);
						System.out.println("Do You want to Continue....true/false");
						buyerchoice = sc.nextBoolean();
						break;
					default :
						System.out.println("Invalid Option...!");
						System.out.println("Do You want to Continue....true/false");
						buyerchoice = sc.nextBoolean();
						break;
					}
					
				}
				break;
			case 4 :
				RegisterBuyerUseCase.main(null);
				break;
			case 5 :
				RegisterSellerUseCase.main(null);
				break;
			default :
				break;
				
			}
			System.out.println("Do you wan to continue....true/false");
			choice = sc.nextBoolean();
			if(!choice) {
				System.out.println("Thank You....!");
			}
				
			
		}
		
	}
	
}
