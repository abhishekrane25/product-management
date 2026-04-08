package com.abhi.service;

import java.util.List;

import com.abhi.model.Product;

public interface IProductService {
	
	String addProduct(Product prod);
	Product getProductById(int pid);
	List<Product> viewAllProducts();
	String updateProduct(int pid, String updatedProductName, double updatedProductPrice);
	String deleteProduct(int pid);
	Boolean checkId(int pid);
	
	
}
