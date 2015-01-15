package com.mockup.shoppingcart.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mockup.product.pojo.Product;
import com.mockup.shoppingcart.pojo.shoppingCart;
import com.mockup.util.ConnectionFactory;

public class shoppingcartDaoImpl implements shoppingcartDao {

	@Override
	public void addToMyShoppingCart(shoppingCart mycart, String productid) {
		String query="select * from product where productid='"+productid+"';";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product product = new Product();
		try {	
			conn = ConnectionFactory.getConn();
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
				mycart.getProducts().add(product);
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
	}

}
