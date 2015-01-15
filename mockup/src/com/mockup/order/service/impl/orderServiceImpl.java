package com.mockup.order.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mockup.order.pojo.order;
import com.mockup.order.pojo.orderDetail;
import com.mockup.order.pojo.orderLine;
import com.mockup.order.service.orderService;
import com.mockup.util.ConnectionFactory;
import com.mockup.util.DaoFactory;

public class orderServiceImpl implements orderService{

	@Override
	public List getOrderList() {
		return DaoFactory.getOrderDao().getOrderList();
	}

	@Override
	public orderDetail getOrderDetail(String orderid,String paywayid) {
		return DaoFactory.getOrderDao().getOrderDetail(orderid, paywayid);
	}
	
}
