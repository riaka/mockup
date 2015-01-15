package com.mockup.order.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mockup.order.dao.orderDao;
import com.mockup.order.pojo.order;
import com.mockup.order.pojo.orderDetail;
import com.mockup.order.pojo.orderLine;
import com.mockup.util.ConnectionFactory;

public class orderDaoImpl implements orderDao {

	@Override
	public List getOrderList() {
		List orderList = new ArrayList();
		String query="select orderid,name,cost,userid,statusid,orders.paywayid,paystyle  from orders,payway where orders.paywayid = payway.paywayid ;";
		Connection conn = null;		
		Statement stmt = null;		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.getConn();		
			stmt = conn.createStatement();		
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				order order = new order();
				order.setOrderid(rs.getInt("orderid"));
				order.setName(rs.getString("orderid"));
				order.setCost(rs.getDouble("cost"));
				order.setUserid(rs.getString("userid"));
				order.setStatusid(rs.getInt("statusid"));
				order.setPaywayid(rs.getInt("paywayid"));
				order.setPayStyle(rs.getString("paystyle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying orders ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying database ",e);
			}
		}
		return orderList;
	}

	@Override
	public orderDetail getOrderDetail(String orderid, String paywayid) {
		orderDetail orderdetail =new orderDetail();
		String query="select paystyle,lineid,amount,product.productid,product.name,basePrice from product,payway,orderline where orderline.orderid=''"
				+ " and payway.paywayid='' and orderline.productid=product.productid;";
		Connection conn = null;		
		Statement stmt = null;		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.getConn();		
			stmt = conn.createStatement();	
			rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				int orderID=Integer.valueOf(orderid);
				orderdetail.setOrderid(orderID);
				orderdetail.setPaywayid(Integer.valueOf(paywayid));
				orderdetail.setPayStyle(rs.getString("paystyle"));
				
				do{
					orderLine orderline=new orderLine();
					orderline.setAmount(rs.getInt("amount"));
					orderline.setBaseprice(rs.getDouble("basePrice"));
					orderline.setLineid(rs.getInt("lineid"));
					orderline.setName(rs.getString("name"));
					orderline.setOrderid(orderID);
					orderline.setProductid(rs.getInt("productid"));
					orderdetail.setOrderlines(orderline);
				}while(rs.next());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying orders ",e);	
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying database ",e);
			}
		}
		return orderdetail;
	}

}
