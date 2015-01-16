package com.mockup.product.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mockup.product.pojo.Product;
import com.mockup.product.service.productService;
import com.mockup.product.service.impl.productServiceImpl;

/**
 * Servlet Filter implementation class productDetailFilter
 */
public class productDetailFilter implements Filter {

	FilterConfig config=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try{
			productService productService;
			productService = new productServiceImpl();
			Product product= productService.getProduct(req.getParameter("productid"));
			req.setAttribute("product", product);
			chain.doFilter(req, resp);
		}catch(Exception e)
		{
			req.setAttribute("errormessage", e.getMessage());
			config.getServletContext().getRequestDispatcher("/error").forward(req, resp);
		}	
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		
	}


}
