package com.mockup.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class pathFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String contextpath=((HttpServletRequest)req).getContextPath()+"/";
		config.getServletContext().setAttribute("contextpath", contextpath);
		config.getServletContext().setAttribute("imagepath", contextpath +"images");
		config.getServletContext().setAttribute("csspath", contextpath +"css");
		chain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

}
