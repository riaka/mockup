package com.mockup.product.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.product.pojo.Product;
 
import com.mockup.product.service.productService;
import com.mockup.product.service.impl.productServiceImpl;
import com.mockup.user.pojo.User;

public class productListServlet extends HttpServlet {

 

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String contextpath=(String)this.getServletContext().getAttribute("contextpath");
		String imagepath=(String)this.getServletContext().getAttribute("imagepath");
		String csspath=(String)this.getServletContext().getAttribute("csspath");
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		List productList = (List) req.getAttribute("productlist");		
		String userid=user.getUserid();
		Product product;
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\""+csspath+"/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\""+imagepath+"/top_bg.gif\"><img src=\""+imagepath+"/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\""+imagepath+"/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\""+imagepath+"/top_bg.gif\" align=\"right\"><img src=\""+imagepath+"/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("			<tr>");
		out.println("				<td background=\""+imagepath+"/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          					<td width=\"10%\"><a href=\""+contextpath+"toproductlist\"><img name=\"Image1\" border=\"0\" src=\""+imagepath+"/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("							<td width=\"10%\"><a href=\""+contextpath+"logoncheck/access/tousermanage\"><img name=\"Image2\" border=\"0\" src=\""+imagepath+"/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							<td width=\"10%\"><a href=\""+contextpath+"logoncheck/toshoppingcart\"><img name=\"Image4\" border=\"0\" src=\""+imagepath+"/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							<td width=\"10%\"><a href=\""+contextpath+"logoncheck/toorderlist\"><img name=\"Image5\" border=\"0\" src=\""+imagepath+"/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							<td width=\"10%\"><a href=\""+contextpath+"toproductlist\"><img name=\"Image6\" border=\"0\" src=\""+imagepath+"/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\""+imagepath+"/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=index.jsp>达内电子商务门户</a> →<img border=\"0\" src=\""+imagepath+"/dog.gif\" width=\"19\" height=\"18\">欢迎<font color=\"red\">"
				+ userid + "</font>光临！");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\""+imagepath+"/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>序号</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\""+imagepath+"/bg2.gif\" width=\"60%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>产品名称</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\""+imagepath+"/bg2.gif\" width=\"8%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>价格</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\""+imagepath+"/bg2.gif\" width=\"24%\">");
		out.println("					<font color=\"#ffffff\">");
		out.println("						<b>操作</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		 
 		
		for(int i=0;i<productList.size();i++)
		{
			product=(Product)productList.get(i);
			out.println("			<tr>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.println("					"+product.getProductid());
			out.println("				</td>");
			out.println("				");
			out.println("    <td class=tablebody1 valign=\"middle\" width=\"60%\"> &nbsp;&nbsp;<a href=\""+contextpath+"toproductdetail?productid="+product.getProductid()+"\">"+product.getName()+"</a> ");
			out.println("    </td>");
			out.println("				<td class=tablebody2 valign=\"middle\" align=\"center\" width=\"8%\">");
			out.println("					"+product.getBasePrice());
			out.println("				</td>");
			out.println("				");
			out.println("    <td class=tablebody1 valign=\"middle\" align=\"center\" width=\"24%\"> <a href=\""+contextpath+"logoncheck/addtoshoppingcart?productid="+product.getProductid()+"\"><img border=\"0\" src=\""+imagepath+"/car_new.gif\" width=\"97\" height=\"18\"></a> ");
			out.println("    </td>");
			out.println("			</tr>   ");
		}
		out.println("		</table>");
		out.println("<!-- Body End -->");
		out.println("<!-- Footer Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("			<tr>");
		out.println("				<td height=\"17\" background=\""+imagepath+"/bot_bg.gif\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("			<tr>");
		out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
		out.println("					<p align=\"center\">");
		out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
		out.println("					</p>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("<!-- Footer End -->");
		out.println("	</body>");
		out.println("</html>");
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	


	

}
