package com.mockup.product.service;

import java.util.List;

import com.mockup.product.pojo.Product;

public interface productService {
	public List getProductList();
	public Product getProduct(String productid);
}
