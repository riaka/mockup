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

public class doregisterFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest) req).getSession();
		User user = (User) session.getAttribute("newuser");
		if (user == null)
			user = new User();
		user.setUserid(req.getParameter("userid"));
		user.setPassword(req.getParameter("password"));
		user.setStreet1(new String(req.getParameter("street1").getBytes("ISO-8859-1"), "UTF-8"));
		user.setStreet2(new String(req.getParameter("street2").getBytes("ISO-8859-1"), "UTF-8"));
		user.setCity(new String(req.getParameter("city").getBytes("ISO-8859-1"), "UTF-8"));
		user.setProvince(req.getParameter("province"));
		user.setCountry(req.getParameter("country"));
		user.setZip(req.getParameter("zip"));
		user.setEmail(req.getParameter("email"));
		user.setHomephone(req.getParameter("homephone"));
		user.setCellphone(req.getParameter("cellphone"));
		user.setOfficephone(req.getParameter("officephone"));
		try {
			Boolean flag = ServiceFactory.getUserService().registerUser(user);		
			if (flag) {
				session.setAttribute("user", user);
				((HttpServletResponse)resp).sendRedirect(""
						+ config.getServletContext().getContextPath()
						+ "/toproductlist");
			} else {
				session.setAttribute("newuser", user);
				((HttpServletResponse)resp).sendRedirect(""
						+ config.getServletContext().getContextPath()
						+ "/toregister");
			}
		} catch (Exception e) {
			req.setAttribute("errormessage", e.getMessage());
			config.getServletContext().getRequestDispatcher("/error").forward(req,
					resp);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

}
