package com.abhi.controller;

import java.util.List;
import java.util.Scanner;

import com.abhi.model.Product;
import com.abhi.service.ProductServiceImplementation;

public class ProductListMenu {
	public static void main(String[] args) {
		
		ProductServiceImplementation prodImpl = new ProductServiceImplementation();
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" 1. Add Product\n 2. View Product By Id\n 3. View All Products\n 4. Update Product by ID \n 5. Delete Product by ID \n Please enter your choice (1-5):");
			int choice = sc.nextInt();
			
			switch (choice)
			{
				case 1:
				{
					System.out.println("--------------- Add Product --------------- ");
					System.out.println("Enter Product ID:");
					int pid = sc.nextInt();
					Boolean checkId = prodImpl.checkId(pid);
					if(!checkId) {
					System.out.println("Enter Product Name:");
					String productName = sc.next();
					System.out.println("Enter Product Price:");
					double price = sc.nextDouble();
					Product prod = new Product(pid, productName, price);
					String result = prodImpl.addProduct(prod);
					System.out.println(result);
					break;
					}
					else {
						System.out.println("ID already exists. Please enter different ID.");
						break;
					}
				}
				case 2:
				{
					System.out.println("--------------- View Product By ID --------------- ");
					System.out.println("Enter Product ID:");
					int pid = sc.nextInt();
					Product result = prodImpl.getProductById(pid);
					System.out.println(result);
					break;
				}
				case 3:
				{
					System.out.println("--------------- View All Products --------------- ");
					List<Product> result = prodImpl.viewAllProducts();
					System.out.println(result);
					break;
				}
				case 4:
				{
					System.out.println("--------------- Update Product --------------- ");
					System.out.println("Enter Product ID:");
					int pid = sc.nextInt();
					System.out.println("\n 1. Update Name\n 2.Update Price\n Enter your choice");
					int updatedChoice = sc.nextInt();
					String updatedProductName = "";
					double updatedProductPrice = 0;
					switch(updatedChoice) {
						case 1:{
							System.out.println("Enter Product Name:");
							//Scanner name = new Scanner(System.in);
							updatedProductName = sc.next();
							updatedProductPrice = 0;
							String result = prodImpl.updateProduct(pid, updatedProductName, updatedProductPrice);
							System.out.println(result);
							//name.close();
							break;
						}
						case 2:{
							System.out.println("Enter Product Price:");
							//Scanner price = new Scanner(System.in);
							updatedProductPrice = sc.nextDouble();
							updatedProductName = null;
							String result = prodImpl.updateProduct(pid, updatedProductName, updatedProductPrice);
							System.out.println(result);
							//price.close();
							break;
						}
						default: {
							System.out.println("Invalid Input");
						}
					
					}
					break;
				}
				case 5:
				{
					System.out.println("--------------- Delete Product --------------- ");
					System.out.println("Enter Product ID:");
					int pid = sc.nextInt();
					//System.out.println("");
					String result = prodImpl.deleteProduct(pid);
					System.out.println(result);
					break;
				}
				default:{
					System.out.println("Exiting program.");
				}
				//sc.close();
			}
		}
	}
}
