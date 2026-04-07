package com.abhi.service;

import java.util.List;

import com.abhi.model.Product;

public interface IProductService {
	
	String addProduct(Product prod);
	Product getProductById(int pid);
	List<Product> viewAllProducts();
	String updateProduct(int pid, Product prod);
	String deleteProduct(int pid);
	
	
}
