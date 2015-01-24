package com.mockup.shoppingcart.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.order.pojo.payWay;
import com.mockup.shoppingcart.pojo.shoppingCart;

public class toorderconfirmFilter implements Filter {

	private FilterConfig config;
	private static String PAYWAY="1,邮局汇款,2,银行转账,3,货到付款";
	private List<payWay> payway=new ArrayList<payWay>();
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.config = config;
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session=((HttpServletRequest) req).getSession();
		shoppingCart mycart=(shoppingCart)session.getAttribute("shoppingcart");
		
		if(mycart.getProducts().isEmpty())
		{
			((HttpServletResponse)resp).sendRedirect(""+config.getServletContext().getContextPath()+"/logoncheck/toshoppingcart");
			return ;
		}
		this.initPayStyle();
		((HttpServletRequest)req).setAttribute("payways", payway);
		req.getRequestDispatcher("/orderConfirm.vm").forward(req, resp);
		return ;
		//chain.doFilter(req, resp);
		
	}
	private void initPayStyle()
	{
		String[] payways=PAYWAY.split(",");
		payway.clear();
		for(int i=0;i<payways.length;)
		{
			payWay pay=new payWay();
			pay.setPaywayid(Integer.valueOf(payways[i++]));
			pay.setStyle(payways[i++]);
			payway.add(pay);
		}
	}
	@Override
	public void destroy() {
		
	}
}
