package com.mockup.shoppingcart.dao;

import com.mockup.shoppingcart.pojo.shoppingCart;

public interface shoppingcartDao {
	public void addToMyShoppingCart(shoppingCart mycart,String productid);
}
