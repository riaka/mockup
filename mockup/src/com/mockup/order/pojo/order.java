package com.mockup.order.pojo;

public class order {
	int orderid;
	String name;
	double cost;
	String userid;
	int statusid;
	payWay payway=new payWay();
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getPaywayid() {
		return payway.getPaywayid();
	}
	public void setPaywayid(int paywayid) {
		this.payway.setPaywayid(paywayid);
	}
	public void setPayStyle(String paystyle)
	{
		this.payway.setStyle(paystyle);
	}
	public String getPayStyle()
	{
		return this.payway.getStyle();
	}
}
