package com.mockup.shoppingcart.service.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mockup.product.pojo.Product;
import com.mockup.shoppingcart.pojo.shoppingCart;
import com.mockup.shoppingcart.service.shoppingcartService;
import com.mockup.util.ConnectionFactory;
import com.mockup.util.DaoFactory;

public class shoppingcartServiceImpl implements shoppingcartService {

	@Override
	public void addToMyShoppingCart(shoppingCart mycart,String productid) {
		DaoFactory.getShoppingcartDao().addToMyShoppingCart(mycart, productid);
	}
	
}
