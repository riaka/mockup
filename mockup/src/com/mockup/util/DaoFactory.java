package com.mockup.util;

import com.mockup.order.dao.orderDao;
import com.mockup.order.dao.impl.orderDaoImpl;
import com.mockup.product.dao.productDao;
import com.mockup.product.dao.impl.productDaoImpl;
import com.mockup.shoppingcart.dao.shoppingcartDao;
import com.mockup.shoppingcart.dao.shoppingcartDaoImpl;
import com.mockup.user.dao.userDao;
import com.mockup.user.dao.impl.userDaoImpl;

public class DaoFactory {
	public static orderDao getOrderDao()
	{
		return new orderDaoImpl();		
	}
	public static productDao getProductDao()
	{
		return new productDaoImpl();		
	}
	public static shoppingcartDao getShoppingcartDao()
	{
		return new shoppingcartDaoImpl();		
	}
	public static userDao getUserDao()
	{
		return new userDaoImpl();
	}
}
