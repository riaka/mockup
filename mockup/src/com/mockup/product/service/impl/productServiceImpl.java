package com.mockup.product.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mockup.product.pojo.Product;
 
import com.mockup.product.service.productService;
import com.mockup.util.ConnectionFactory;
import com.mockup.util.DaoFactory;

public class productServiceImpl implements productService {

	

	@Override
	public List getProductList() 
	{
		return DaoFactory.getProductDao().getProductList();
	}

	@Override
	public Product getProduct(String productid) {
		return DaoFactory.getProductDao().getProduct(productid);
	}

}
