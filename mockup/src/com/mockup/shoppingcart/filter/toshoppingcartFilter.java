package com.mockup.shoppingcart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mockup.shoppingcart.pojo.shoppingCart;

public class toshoppingcartFilter implements Filter {
	
	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.config = config;
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		req.getRequestDispatcher("/shoppingCart.vm").forward(req, resp);
		return;
		//chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
