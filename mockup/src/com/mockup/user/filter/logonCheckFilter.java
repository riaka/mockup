package com.mockup.user.filter;

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

import com.mockup.user.pojo.User;

public class logonCheckFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session=((HttpServletRequest) req).getSession();
		User user=(User)session.getAttribute("user");
		if(user==null || !user.isLogon())
		{
			session.setAttribute("message", "请先登录");
			
			((HttpServletResponse) resp).sendRedirect(""+config.getServletContext().getContextPath()+"/tologin");
			session.removeAttribute("message");
			return;
		}
		chain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

}
