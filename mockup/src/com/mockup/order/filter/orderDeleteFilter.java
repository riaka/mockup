package com.mockup.order.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.mockup.order.pojo.orderDetail;
import com.mockup.util.ServiceFactory;

public class orderDeleteFilter implements Filter {
	FilterConfig config=null;
    public orderDeleteFilter() {
        // TODO Auto-generated constructor stub
     }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		try{
			orderDetail orderdetail=ServiceFactory.getOrderService().getOrderDetail(req.getParameter("orderid"), req.getParameter("paywayid"));
			req.setAttribute("orderdetail", orderdetail);
			chain.doFilter(req, resp);
		}catch(Exception e)
		{
			req.setAttribute("errormessage", e.getMessage());
			((HttpServletResponse)resp).sendRedirect(""+config.getServletContext().getContextPath()+"/error");
		}			
	}
	public void init(FilterConfig Config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=Config;
	}

}
