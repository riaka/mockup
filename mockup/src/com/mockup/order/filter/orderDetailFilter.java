package com.mockup.order.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.mockup.order.pojo.orderDetail;
import com.mockup.order.service.orderService;
import com.mockup.order.service.impl.orderServiceImpl;

/**
 * Servlet Filter implementation class orderListFilter
 */
public class orderDetailFilter implements Filter {

	FilterConfig config=null;
    /**
     * Default constructor. 
     */
    public orderDetailFilter() {
        // TODO Auto-generated constructor stub
    	
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		try{
			orderService orderservice=new orderServiceImpl();
			orderDetail orderdetail=orderservice.getOrderDetail(req.getParameter("orderid"), req.getParameter("paywayid"));
			req.setAttribute("orderdetail", orderdetail);
			config.getServletContext().getRequestDispatcher("/toorderdetail").forward(req, resp);
		}catch(Exception e)
		{
			req.setAttribute("errormessage", e.getMessage());
			config.getServletContext().getRequestDispatcher("/error").forward(req, resp);
		}			

		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig Config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=Config;
	}

}
