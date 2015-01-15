package com.mockup.product.dao;

import java.util.List;

import com.mockup.product.pojo.Product;

public interface productDao {
	public List getProductList();
	public Product getProduct(String productid);
}
