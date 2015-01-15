package com.mockup.util;

import com.mockup.order.service.orderService;
import com.mockup.order.service.impl.orderServiceImpl;
import com.mockup.product.service.productService;
import com.mockup.product.service.impl.productServiceImpl;
import com.mockup.shoppingcart.service.shoppingcartService;
import com.mockup.shoppingcart.service.Impl.shoppingcartServiceImpl;
import com.mockup.user.service.userService;
import com.mockup.user.service.impl.userServiceImpl;

public class ServiceFactory {
	
	public static userService getUserService(){
		return new userServiceImpl();
	}
	public static shoppingcartService getShoppingcartService(){
		return new shoppingcartServiceImpl();
	}
	public static productService getProductService(){
		return new productServiceImpl();
	}
	public static orderService getOrderService(){
		return new orderServiceImpl();
	}
	
}
