package com.mockup.shoppingcart.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mockup.product.pojo.Product;

public class shoppingCart {
	List<Product> products=new ArrayList();
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
}
