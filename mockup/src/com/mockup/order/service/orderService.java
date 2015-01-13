package com.mockup.order.service;
import java.util.List;

import com.mockup.order.pojo.orderDetail;
public interface orderService {
	
	public List getOrderList();
	public orderDetail getOrderDetail(String orderid,String paywayid);
}
