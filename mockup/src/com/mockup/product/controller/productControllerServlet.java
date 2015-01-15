package com.mockup.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mockup.order.pojo.orderDetail;
import com.mockup.order.service.orderService;
import com.mockup.order.service.impl.orderServiceImpl;
import com.mockup.product.pojo.Product;
import com.mockup.product.service.productService;
import com.mockup.product.service.impl.productServiceImpl;
import com.mockup.user.pojo.User;

public class productControllerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 			throws ServletException, IOException {
 		
 		String path = req.getServletPath();	
 		path = path.substring(0,path.indexOf("."));
 	
 		
 		if("/toproductlist".equals(path)){
 			try{
 				productService productservice = new productServiceImpl();
 				
 				List productlist = productservice.getProductList();
 				
 				req.setAttribute("productlist", productlist);
 				
 				getServletContext().getRequestDispatcher("/productlist").forward(req, resp);
 				
 			} catch (Exception e){
 				req.setAttribute("errormessage", e.getMessage());
 				getServletContext().getRequestDispatcher("/error").forward(req, resp);
 			}			
		}else if("/toproductdetail".equals(path)){
			try{
				productService productService;
				productService = new productServiceImpl();
				Product product= productService.getProduct(req.getParameter("productid"));
				req.setAttribute("product", product);
				getServletContext().getRequestDispatcher("/productdetail").forward(req, resp);
			}catch(Exception e)
			{
				req.setAttribute("errormessage", e.getMessage());
				getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}			
		} else 
			
 		 {
			req.setAttribute("errormessage","message");
			getServletContext().getRequestDispatcher("/error").forward(req, resp);
 		}
	}
}



