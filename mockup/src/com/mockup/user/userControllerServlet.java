package com.mockup.user;

import java.io.IOException;
import java.io.PrintWriter;
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
 					userService userservice = new userServiceImpl();
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
 		else if("/doregister".equals(path))
 		{
 			
 			
 			
 		}
 		else{
 			resp.sendError(resp.SC_NOT_FOUND);
 		}
		
	}

	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String path = req.getServletPath(); 		
 		path = path.substring(0,path.indexOf("."));
		if("/dologin".equals(path)){
			
			String username = req.getParameter("username");			
			String password = req.getParameter("password");
			System.out.println("1");
			System.out.println(username+password);
			userService userservice = new userServiceImpl();
			User user=userservice.login(username,password);
			if(user!=null){
				session.setAttribute("user", user);				
				getServletContext().getRequestDispatcher("/productlist").forward(req, resp);
			}else{
				req.setAttribute("message", "用户名或密码错误");
				getServletContext().getRequestDispatcher("/userlogin").forward(req, resp);
			}
			
 		} else {
 			resp.sendError(resp.SC_NOT_FOUND);
 			getServletContext().getRequestDispatcher("/error").forward(req, resp);
 		}
	}
	
}
