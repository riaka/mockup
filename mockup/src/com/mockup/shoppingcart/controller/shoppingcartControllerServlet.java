package com.mockup.shoppingcart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.shoppingcart.pojo.shoppingCart;
import com.mockup.shoppingcart.service.shoppingcartService;
import com.mockup.shoppingcart.service.Impl.shoppingcartServiceImpl;
import com.mockup.user.pojo.User;
import com.mockup.user.service.userService;
import com.mockup.user.service.impl.userServiceImpl;

public class shoppingcartControllerServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String path = req.getServletPath(); 		
 		path = path.substring(0,path.indexOf("."));
 		HttpSession session=req.getSession();
 		User user=(User)session.getAttribute("user");
		if(user==null || !user.isLogon())
		{
			req.setAttribute("message", "请先登录");
			getServletContext().getRequestDispatcher("/userlogin").forward(req, resp);
		}
		else
		{
			shoppingCart mycart=(shoppingCart)session.getAttribute("shoppingcart");
			if(mycart==null)
			{
				mycart=new shoppingCart();
				session.setAttribute("shoppingcart",mycart );
			}
			if("/addtoshoppingcart".equals(path))
			{
				try{
					shoppingcartService productservice=new shoppingcartServiceImpl();
					productservice.addToMyShoppingCart(mycart,req.getParameter("productid"));										
					getServletContext().getRequestDispatcher("/shoppingcart").forward(req, resp);				
				} catch (Exception e){
					req.setAttribute("errormessage", e.getMessage());		
					getServletContext().getRequestDispatcher("/error").forward(req, resp);
				}
			}
	 		else if("/tocleancart".equals(path))
	 		{
	 			mycart.getProducts().clear();
	 			getServletContext().getRequestDispatcher("/shoppingcart").forward(req, resp);
	 		}
			else if("/toshoppingcart".equals(path))
			{							
				getServletContext().getRequestDispatcher("/shoppingcart").forward(req, resp);				
 			
			} 
			else if("/toorderConfirm".equals(path))
			{
				getServletContext().getRequestDispatcher("/orderconfirm").forward(req, resp);
				
			}
			else
			{
				resp.sendError(resp.SC_NOT_FOUND);
			}
			
		}
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
}
