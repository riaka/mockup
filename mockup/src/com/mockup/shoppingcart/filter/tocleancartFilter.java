package com.mockup.shoppingcart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.shoppingcart.pojo.shoppingCart;

public class tocleancartFilter implements Filter {
	
	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.config = config;

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpSession session=((HttpServletRequest)req).getSession();		
		shoppingCart mycart=(shoppingCart)session.getAttribute("shoppingcart");
		mycart.getProducts().clear();
		((HttpServletResponse)resp).sendRedirect(""+config.getServletContext().getContextPath()+"/logoncheck/toshoppingcart");
			
	}

	@Override
	public void destroy() {

	}

}
