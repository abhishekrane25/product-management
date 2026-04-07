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
			System.out.println(" 1. Add Product\n 2.View Product By Id\n 3. View All Products\n 4.Delete Product by ID \n Please enter your choice (1-4):");
			int choice = sc.nextInt();
			
			switch (choice)
			{
				case 1:
				{
					System.out.println("--------------- Add Product --------------- ");
					System.out.println("Enter Product ID:");
					int pid = sc.nextInt();
					System.out.println("Enter Product Name:");
					String productName = sc.nextLine();
					System.out.println("Enter Product Price:");
					double price = sc.nextDouble();
					Product prod = new Product(pid, productName, price);
					String result = prodImpl.addProduct(prod);
					System.out.println(result);
					break;
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
					System.out.println("1. Update Product Name\n 2. Update Product Price\n Enter choice of update: ");
					int updateChoice = sc.nextInt();
					switch (updateChoice) {
						case 1: 
						{
							System.out.println("Enter product name:");
							String productName = sc.nextLine();
							
							String result = prodImpl.updateProduct(pid, productName);
							
						}
					}
				}
				
			}
				
			
		}
	}
}
