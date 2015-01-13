package com.mockup.shoppingcart.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mockup.product.pojo.Product;

public class shoppingCart {
	private static shoppingCart shoppingcart=null;
	List<Product> products=new ArrayList();
	public static shoppingCart getMyShoppingCart()
	{
		if(shoppingcart==null)
			shoppingcart=new shoppingCart();
		return shoppingcart;
	}
	private shoppingCart(){};
	
	public void add(Product product)
	{
		products.add(product);
	}
	public List<Product> getProducts() {
		return products;
	}
	
}
