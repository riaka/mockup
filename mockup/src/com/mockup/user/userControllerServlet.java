package com.mockup.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.user.pojo.User;
import com.mockup.user.service.userService;
import com.mockup.user.service.impl.userServiceImpl;

public class userControllerServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getServletPath(); 		
 		path = path.substring(0,path.indexOf("."));
 		HttpSession session=req.getSession();
 		userService userservice = new userServiceImpl();
 		if("/tousermanage".equals(path)){
 			User user=(User)session.getAttribute("user");
 			if(user==null)
 			{
 				req.setAttribute("message", "请先登录");
 				getServletContext().getRequestDispatcher("/userlogin").forward(req, resp);
 			}
 			else if(user.getUserid().equals(User.ADMIN))
 			{
 				try{
 					List<User> users=userservice.getUserList();					
 					req.setAttribute("users", users);				
 					getServletContext().getRequestDispatcher("/usermanage").forward(req, resp);				
 				} catch (Exception e){
 					req.setAttribute("errormessage", e.getMessage());		
 					getServletContext().getRequestDispatcher("/error").forward(req, resp);
 				}
 			}
 			else
 			{
 				getServletContext().getRequestDispatcher("/usermodify").forward(req, resp);
 			}
 		}
 		else if("/tologin".equals(path)){
 			getServletContext().getRequestDispatcher("/userlogin").forward(req, resp);		
 		}
 		else if("/toregister".equals(path)){
 			getServletContext().getRequestDispatcher("/userregister").forward(req, resp);
 		}
 		else if("/dologin".equals(path)){
			String username = req.getParameter("username");			
			String password = req.getParameter("password");
			
			User user=userservice.login(username,password);
			if(user!=null){
				session.setAttribute("user", user);		
				getServletContext().getRequestDispatcher("/toproductlist.product").forward(req, resp);
			}else{
				req.setAttribute("message", "用户名或密码错误");
				getServletContext().getRequestDispatcher("/userlogin").forward(req, resp);
			}
			
 		} 
 		else if("/doregister".equals(path))
 		{	
 			getServletContext().getRequestDispatcher("/error").forward(req, resp);
 			User user=new User();
			user.setUserid(req.getParameter("username"));
			user.setPassword(req.getParameter("password"));
			user.setStreet1(req.getParameter("street1"));
			user.setStreet2(req.getParameter("street2"));
			user.setCity(req.getParameter("city"));
			user.setProvince(req.getParameter("province"));
			user.setCountry(req.getParameter("country"));
			user.setZip(req.getParameter("zip"));
			user.setEmail(req.getParameter("email"));
			user.setHomephone(req.getParameter("homephone"));
			user.setCellphone(req.getParameter("cellphone"));
			user.setOfficephone(req.getParameter("officephone"));
 			
 			try{					
				Boolean flag = userservice.registerUser(user);	
				if(flag)
				{
					session.setAttribute("user", user);
					System.out.println("注册成功");
					getServletContext().getRequestDispatcher("/toproductlist.product").forward(req, resp);
				}
				else{
					getServletContext().getRequestDispatcher("/userregister").forward(req, resp);
				}
			} catch (Exception e){
				req.setAttribute("errormessage", e.getMessage());		
				getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}
 		}
		else {
 			resp.sendError(resp.SC_NOT_FOUND);
 			getServletContext().getRequestDispatcher("/error").forward(req, resp);
 		}
		
	}

	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doGet(req, resp);

		
	}
	
}
