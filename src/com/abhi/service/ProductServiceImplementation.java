package com.abhi.service;


import java.util.ArrayList;
import java.util.List;

import com.abhi.model.Product;

public class ProductServiceImplementation implements IProductService {

	ArrayList<Product> pl = new ArrayList<Product>();
	
	@Override
	public String addProduct(Product prod) {
		pl.add(prod);
		return "Product Added to the list successfully!";
	}

	@Override
	public Product getProductById(int pid) {
		for(Product p: pl) {
			if(p.getPid() == pid) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Product> viewAllProducts() {
		return pl;
	}

	@Override
	public String updateProduct(int pid, Product prod) {
		pl.set(pid, prod);
		return "Product ID:"+pid+" updated Successfully";
	}

	@Override
	public String deleteProduct(int pid) {
		pl.remove(pid);
		return "Product ID:"+pid+" deleted Successfully";
	}
	

}
