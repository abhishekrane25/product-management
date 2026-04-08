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
	public String updateProduct(int pid, String updatedProductName, double updatedProductPrice) {
		for(Product p: pl)
		{
			if(p.getPid()==pid) {
				if(updatedProductName != null) {
					p.setProductName(updatedProductName);
					return "Product ID:"+pid+" updated Successfully";
				}
				else if(updatedProductPrice>0) {
					p.setPrice(updatedProductPrice);
					return "Product ID:"+pid+" updated Successfully";
				}
				else {
					return "Invalid choice";
				}
			}
			else {
				return "Product ID not found.";
			}
		}
		return "Invalid Choice 1";
	}

	@Override
	public String deleteProduct(int pid) {
		for(Product p: pl) {
			if(p.getPid()==pid) {
				pl.remove(p);
			}
			return "Product ID:"+pid+"deleted Successfully";
		}
		return "Invalid Product ID";
	}

	@Override
	public Boolean checkId(int pid) {
		for(Product p: pl) {
			if(p.getPid()==pid) {
				return true;
			}
		}
		return false;
	}
	

}
