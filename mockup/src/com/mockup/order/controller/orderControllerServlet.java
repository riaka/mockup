package com.mockup.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.order.pojo.orderDetail;
import com.mockup.order.service.orderService;
import com.mockup.order.service.impl.orderServiceImpl;
import com.mockup.user.pojo.User;

public class orderControllerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 			throws ServletException, IOException {
 		HttpSession session=req.getSession();
 		String path = req.getServletPath();		
 		path = path.substring(0,path.indexOf("."));
 
 		User user=(User)session.getAttribute("user");
 		if(user==null || !user.isLogon())
		{
			req.setAttribute("message", "请先登录");
			getServletContext().getRequestDispatcher("/userlogin").forward(req, resp);
		}
		else if("/toorderlist".equals(path)){
 			try{		
 				orderService orderservice = new orderServiceImpl();				
 				List orderlist = orderservice.getOrderList();				
 				req.setAttribute("orderlist", orderlist); 				
 				getServletContext().getRequestDispatcher("/orderlist").forward(req, resp);
 				
 			} catch (Exception e){
 				req.setAttribute("errormessage", e.getMessage()); 				
 				getServletContext().getRequestDispatcher("/error").forward(req, resp);
 			}			
		}else if("/toorderdetail".equals(path)){
			try{
				orderService orderservice=new orderServiceImpl();
				orderDetail orderdetail=orderservice.getOrderDetail(req.getParameter("orderid"), req.getParameter("paywayid"));
				req.setAttribute("orderdetail", orderdetail);
				getServletContext().getRequestDispatcher("/orderdetail").forward(req, resp);
			}catch(Exception e)
			{
				req.setAttribute("errormessage", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}			
		} 
		else if("/addorder".equals(path)){
		
		}
			else 	
 		 {
			req.setAttribute("errormessage","message");
			getServletContext().getRequestDispatcher("/error").forward(req, resp);
 		}
	}
}
