package com.mockup.shoppingcart.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.product.pojo.Product;
import com.mockup.shoppingcart.pojo.shoppingCart;
import com.mockup.user.pojo.User;

public class orderConfirmServlet extends HttpServlet {
	private static String PAYWAY="0,邮局汇款,1,银行转账,货到付款";
	private Map<String,String> payway=new HashMap();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("textml;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session=req.getSession();
		shoppingCart mycart=(shoppingCart)session.getAttribute("shoppingcart");
		User user=(User)session.getAttribute("user");
		if(user==null || !user.isLogon())
			user=new User();
		if(mycart==null)
			mycart=new shoppingCart();
		String userid=user.getUserid();
		String userstreet1=user.getStreet1();
		String zip=user.getZip();
		String homephone=user.getHomephone();
		String officephone=user.getOfficephone();
		String cellphone=user.getCellphone();
		String email=user.getEmail();
		
		Product product;
		
		PrintWriter out = resp.getWriter();	
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\"css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("	");
		out.println("<!-- Header Start -->");
		out.println("");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("			<tr>");
		out.println("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"toproductlist.product\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"accessmanage/tousermanage.user\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"logoncheck/toshoppingcart\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"logoncheck/toorderlist\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"toproductlist.product\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("<!-- Header End -->");
		out.println("");
		out.println("<!-- Body Start -->");
		out.println("	<form>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=index.jsp>达内电子商务门户</a> →&nbsp<img border=\"0\" src=\"images/dog.gif\" width=\"19\" height=\"18\">&nbsp订单确认");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<br>");
		out.println("		");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\" colspan=\"2\">");
		out.println("						<font color=\"#ffffff\" size=\"2pt\">");
		out.println("							<b>用户信息</b>");
		out.println("						</font>");
		out.println("						<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='tousermodify.user';\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 valign=\"middle\" align=\"right\" width=\"40%\">用户名&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+userid+"</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"right\">联系地址&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+userstreet1+"</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"right\">邮编&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+zip+"</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"right\">家庭电话&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+homephone+"</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"right\">办公室电话&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+officephone+"</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"right\">手机&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+cellphone+"</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"right\">Email地址&nbsp:&nbsp</td>");
		out.println("				<td class=tablebody1>"+email+"</td>");
		out.println("			</tr>");
		out.println("		</table>		");
		out.println("		");
		out.println("		<br>");
		out.println("		");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\" colspan=\"2\">");
		out.println("					<font color=\"#ffffff\" size=\"2pt\">");
		out.println("						<b>付款方式</b>");
		out.println("					</font>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=tablebody2 align=\"center\" width=\"40%\"></td>");
		out.println("				<td class=tablebody1>");
		out.println("					<select name=\"付账方式\">");
		for(int i=0;i<payway.size();i++)
		{
			out.println("    						<option value=\""+i+"\" >"+payway.get(String.valueOf(i))+"</option>");

		}
		out.println("					</select>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<br>");
		out.println("		");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableborder1\">");
		out.println("			<tr>");
		out.println("				<td valign=\"middle\" align=\"center\" height=\"25\" background=\"images/bg2.gif\" width=\"8%\" colspan=\"5\">");
		out.println("					<font color=\"#ffffff\" size=\"2pt\">");
		out.println("							<b>商品购物清单</b>");
		out.println("					</font>");
		out.println("					<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location='toshoppingcart.cart';\" >");
		out.println("				</td>");
		out.println("			</tr>");
		
		for(Iterator<Product> products =mycart.getProducts().iterator();products.hasNext();)
		{
			product=products.next();
			out.println("			<tr>");
			out.println("				<td class=tablebody2 align=\"center\" width=\"3%\">1</td>");
			out.println("				<td class=tablebody1 width=\"52%\">"+product.getName()+"</td>");
			out.println("				<td class=tablebody2 width=\"15%\">"+product.getBasePrice()+"&nbsp;:&nbsp;59.0</td>");
			out.println("				<td class=tablebody1 width=\"15%\">数量&nbsp;:&nbsp;1</td>");
			out.println("				<td class=tablebody2 width=\"15%\">小计&nbsp;:&nbsp;￥59</td>");
			out.println("			</tr>");
		}
		out.println("			<tr>");
		out.println("				<td class=tablebody1 align=\"center\" colspan=\"4\"></td>");
		out.println("				<td class=tablebody1>合计&nbsp:&nbsp<font color=\"red\">￥137</font></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<br>");
		out.println("		");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\" align=\"center\">");
		out.println("					<b>请认真检查以上订单信息，确认无误后，点击&nbsp;→</b>");
		out.println("					<a href=\"addorder.order\"><img border=\"0\" src=\"images/submit.gif\"></a>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<br>");
		out.println("		</form>");
		out.println("<!-- Body End -->");
		out.println("");
		out.println("<!-- Footer Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("			<tr>");
		out.println("				<td height=\"17\" background=\"images/bot_bg.gif\">");
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
		out.println("");
		out.println("	</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	private void initPayStyle()
	{
		String[] payways=PAYWAY.split(",");
		for(int i=0;i<payways.length;i++)
			payway.put(payways[i],payways[++i]);
	}
}
