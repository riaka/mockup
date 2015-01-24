package com.mockup.product.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.product.pojo.Product;
import com.mockup.product.service.productService;
import com.mockup.product.service.impl.productServiceImpl;
import com.mockup.user.pojo.User;
import com.mockup.util.ServiceFactory;

/**
 * Servlet Filter implementation class productFilter
 */
public class productListFilter implements Filter {

	FilterConfig config=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=((HttpServletRequest) req).getSession();
		User user=(User)session.getAttribute("user");
		if(user==null)
			session.setAttribute("user", new User());
		try{		
				List productlist = ServiceFactory.getProductService().getProductList();
				
				req.setAttribute("productlist", productlist);
				
				req.getRequestDispatcher("productList.vm").forward(req, resp);
				return;
				//chain.doFilter(req, resp);
				
			} catch (Exception e){
				req.setAttribute("errormessage", e.getMessage());
				((HttpServletResponse)resp).sendRedirect(""+config.getServletContext().getContextPath()+"/error");
			}	

		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		
	}

	


}
