package com.mockup.shoppingcart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ToOrderConfirmFilter implements Filter {

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.config = config;
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		config.getServletContext().getRequestDispatcher("/orderconfirm").forward(req, resp);
		
	}

	@Override
	public void destroy() {
		
	}
}
