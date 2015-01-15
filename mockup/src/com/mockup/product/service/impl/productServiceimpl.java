package com.mockup.product.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mockup.product.pojo.Product;
 
import com.mockup.product.service.productService;
import com.mockup.util.sqlConnect;

public class productServiceimpl implements productService {

	

	@Override
	public List getProductList() 
	{
		List productList;
		productList = new ArrayList();		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try 
		{	
			conn = sqlConnect.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");
			
			while(rs.next())
			{
				Product product = new Product();

				product.setProductid(rs.getString("productid"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setBasePrice(rs.getString("basePrice"));
				product.setCategoryid(rs.getString("categoryid"));
				product.setAuthor(rs.getString("author"));
				product.setPublish(rs.getString("publish"));
				product.setPages(rs.getString("pages"));
				product.setImages(rs.getString("images"));
				
				productList.add(product);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying products ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying products ",e);
			}
		}
		return productList;
	}

	@Override
	public Product getProduct(String productid) {
		String query="select * from product where productid='"+productid+"';";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product product = new Product();
		try {	
			conn = sqlConnect.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()){		
				product.setProductid(rs.getString("productid"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setBasePrice(rs.getString("basePrice"));
				product.setCategoryid(rs.getString("categoryid"));
				product.setAuthor(rs.getString("author"));
				product.setPublish(rs.getString("publish"));
				product.setPages(rs.getString("pages"));
				product.setImages(rs.getString("images"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying products ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying products ",e);
			}
		}
		return product;
	}

}
