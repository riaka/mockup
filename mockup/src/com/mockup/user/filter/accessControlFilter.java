package com.mockup.user.filter;

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

import com.mockup.user.pojo.User;
import com.mockup.util.ServiceFactory;

public class accessControlFilter implements Filter {
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
		//String[] admins=config.getServletContext().getInitParameter("Admin").split(",");
		String[] admins={"admin"};
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i].equals(user.getUserid()))
			{
				chain.doFilter(req, resp);
				return ;
			}
		}
		System.out.println(""+config.getServletContext().getContextPath()+ "/logoncheck/tousermodify");
		((HttpServletResponse) resp).sendRedirect(""+config.getServletContext().getContextPath()+ "/logoncheck/tousermodify");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

}
