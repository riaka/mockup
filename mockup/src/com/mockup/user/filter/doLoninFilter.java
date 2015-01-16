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
import com.mockup.util.ServiceFactory;

public class doLoninFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session=((HttpServletRequest) req).getSession();
		String username = req.getParameter("username");			
		String password = req.getParameter("password");
		User parauser=new User();
		parauser.setUserid(username);
		parauser.setPassword(password);
		ServiceFactory.getUserService().login(parauser);
		session.setAttribute("user", parauser);			
		if(parauser.isLogon())
		{
			((HttpServletResponse)resp).sendRedirect(""+config.getServletContext().getContextPath()+"/toproductlist");
		}else
		{
			session.setAttribute("message", "用户名或密码错误");
			((HttpServletResponse)resp).sendRedirect(""+config.getServletContext().getContextPath()+"/tologin");
			session.removeAttribute("message");
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

}
