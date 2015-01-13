package com.mockup.order.pojo;

import java.util.ArrayList;
import java.util.List;

import com.mockup.user.pojo.User;

public class orderDetail {
	private int orderid;
	private payWay payway=new payWay();
	private List<orderLine> orderlines=new ArrayList();
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public int getPaywayid() {
		return payway.getPaywayid();
	}
	public void setPaywayid(int id) {
		this.payway.setPaywayid(id);;
	}
	public String getPayStyle()
	{
		return payway.getStyle();
	}
	public void setPayStyle(String paystyle)
	{
		this.payway.setStyle(paystyle);
	}
	public List<orderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(orderLine orderline) {
		this.orderlines.add(orderline);
	}
	
	public orderDetail()
	{
	}
	
}
