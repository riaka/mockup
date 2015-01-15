package com.mockup.order.dao;

import java.util.List;

import com.mockup.order.pojo.orderDetail;

public interface orderDao {
	public List getOrderList();
	public orderDetail getOrderDetail(String orderid,String paywayid);
}
