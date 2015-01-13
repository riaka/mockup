package com.mockup.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mockup.mysql.sqlConnect;
import com.mockup.user.pojo.User;
import com.mockup.user.service.userService;
import com.mockup.user.service.impl.userServiceImpl;

public class userModifyServlet extends HttpServlet{

	private static String COUNTRY="1,中国,2,中国香港,3,中国台湾";
	private static String PROVINCE="1,安徽,2,北京,3,重庆,4,福建,5,广东,6,甘肃,7,广西,8,贵州,9,河南,10,湖北,11,河北,12,海南,13,香港,14,黑龙江,15,湖南,16,吉林,17,江苏,18,江西,19,辽宁,20,澳门,21,内蒙古,22,宁夏,"
			+ "23,青海,24,四川,25,山东,26,上海,27,陕西,28,山西,29,天津,30,台湾,31,新疆,32,西藏,33,云南,34,浙江,35,其它,36,中国香港,37,中国台湾";
	private Map<String,String> province=new HashMap();
	private Map<String,String> country=new HashMap();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("textml;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		this.initCountry();
		this.initProvince();
		try{
			userService service=new userServiceImpl();
			User user=service.getCertainUser(req.getParameter("userid"));
			showUser(resp, user);
		}catch(Exception e)
		{
			showError(resp,e.getMessage());
		}
	}
	private void showError(HttpServletResponse resp, String message) throws IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Error</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2 align=\"center\">Error</h2>");
		out.println("	<hr>");
		out.println("	System Error," + message + "!");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	private void showUser(HttpServletResponse resp, User user)
			throws IOException {
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 \">");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\"css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\"images/top_bg.gif\"><img src=\"images/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\"images/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\"images/top_bg.gif\" align=\"right\"><img src=\"images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("");
		out.println("			<tr>");
		out.println("				<td background=\"images/dh_bg.gif\" align=\"left\" height=\"12\">");
		out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("						<tr>");
		out.println("							<td width=\"5%\"></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"productlist\"><img name=\"Image1\" border=\"0\" src=\"images/index.gif\" width=\"90\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"usermanage\"><img name=\"Image2\" border=\"0\" src=\"images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"shoppingcart\"><img name=\"Image4\" border=\"0\" src=\"images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"orderlist\"><img name=\"Image5\" border=\"0\" src=\"images/order.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("");
		out.println("							");
		out.println("          <td width=\"10%\"><a href=\"productlist\"><img name=\"Image6\" border=\"0\" src=\"images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
		out.println("						</tr>");
		out.println("					</table>");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
		out.println("			<tr>");
		out.println("				<td width=\"65%\"><br>");
		out.println("");
		out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
		out.println("				</td>");
		out.println("				<td width=\"35%\" align=\"right\">");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("</html>");
		out.println("<!-- Header End -->");
		out.println("<!-- Body Start -->");
		out.println("<form method=\"post\" name=\"reg\"  action=\"/ecport/user/modify.do\">");
		out.println("	<input type=\"hidden\" name=\"userid\" value=\"admin\"/>");
		out.println("");
		out.println("	<input type=\"hidden\" name=\"contactid\" value=\"1\"/>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
		out.println("");
		out.println("			<tr>");
		out.println("				<td height=\"25\" valign=\"middle\">");
		out.println("					<img src=\"images/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=index.jsp>达内电子商务门户</a> →用户信息修改");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder1\">");
		out.println("			<tr>");
		out.println("				 <td colspan=\"2\" align=\"center\" valign=\"middle\" background=\"images/bg2.gif\" width=\"60%\"> &nbsp;&nbsp;<font><b>用户信息修改</b></font> ");
		out.println("   				 </td>");
		out.println("			<tr>");
		out.println("			<tr>");
		out.println("				<td width=\"40%\" class=\"tablebody1\"><b>用户名</b>：<br>英文字母或数字，最大长度为8位</td>");
		out.println("				<td width=\"60%\" class=\"tablebody1\">");
		
		out.println("				<input type=\"text\" maxLength=\"12\" size=\"32\"  value=\""+user.getUserid()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("				<font color=\"#FF0000\">*</font></td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td width=\"40%\" class=\"tablebody1\"><b>密码</b>：<br>数字，6到8位</td>");
		out.println("				<td width=\"60%\" class=\"tablebody1\">");
		out.println("				<input type=\"password\" maxLength=\"12\" size=\"32\" name=\"password\" value=\""+user.getPassword()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("				<font color=\"#FF0000\">*</font></td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td width=\"40%\" class=\"tablebody1\"><b>确认密码</b>：<br>数字，6到8位</td>");
		out.println("				<td width=\"60%\" class=\"tablebody1\">");
		out.println("				<input type=\"password\" maxLength=\"12\" size=\"32\" name=\"password2\" value=\""+user.getPassword()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("				<font color=\"#FF0000\">*</font></td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td width=\"40%\" class=\"tablebody1\"><b>所在地区</b>：</td>");
		out.println("				<td width=\"60%\" class=\"tablebody1\">");
		out.println("					<select name=\"country\" onchange=\"javascript:initProvince(this.value)\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\">");	
		String coun=user.getCountry();
		for(int i=0;i<country.size();)
		{
			i++;
			if(coun.equals(String.valueOf(i)))
				out.println("    						<option value=\""+i+"\" selected>"+country.get(String.valueOf(i))+"</option>");
			else out.println("    						<option value=\""+i+"\" >"+country.get(String.valueOf(i))+"</option>");

		}
		
		out.println("					</select>");
		out.println("					<select name=\"province\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\">");
		out.println("               		  	");
		String prov=user.getProvince();
		for(int i=0;i<province.size();)
		{
			i++;
			if(prov.equals(String.valueOf(i)))
				out.println("    						<option value=\""+i+"\" selected>"+province.get(String.valueOf(i))+"</option>");
			else out.println("    						<option value=\""+i+"\" >"+province.get(String.valueOf(i))+"</option>");
		}
		out.println("				</select>省");
		out.println("				<input type=\"text\" size=\"8\" name=\"city\" value=\""+user.getCity()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>市/县</td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("				<td class=\"tablebody1\"><b>联系地址1</b>：</td>");
		out.println("				<td class=\"tablebody1\">");
		out.println("				<input type=\"text\" size=\"64\" maxlength=\"32\" name=\"street1\" value=\""+user.getStreet1()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("			</td>");
		out.println("			<tr>");
		out.println("				<td class=\"tablebody1\"><b>联系地址2</b>：</td>");
		out.println("				<td class=\"tablebody1\">");
		out.println("				<input type=\"text\" size=\"64\" maxlength=\"32\" name=\"street2\" value=\""+user.getStreet2()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("			</td>");
		out.println("			<tr>");
		out.println("				<td class=\"tablebody1\"><b>邮编</b>：</td>");
		out.println("				<td class=\"tablebody1\">");
		out.println("				<input type=\"text\" size=\"32\" maxlength=\"8\" name=\"zip\" value=\""+user.getZip()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("			</td>");
		out.println("			<tr>");
		out.println("				<td class=\"tablebody1\"><b>家庭电话</b>：</td>");
		out.println("				<td class=\"tablebody1\">");
		out.println("				<input type=\"text\" size=\"32\" maxlength=\"16\" name=\"homephone\" value=\""+user.getHomephone()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("			</td>");
		out.println("			<tr>");
		out.println("				<td class=\"tablebody1\"><b>办公室电话</b>：</td>");
		out.println("				<td class=\"tablebody1\">");
		out.println("				<input type=\"text\" size=\"32\" maxlength=\"16\" name=\"officephone\" value=\""+user.getOfficephone()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("			</td>");
		out.println("			<tr>");
		out.println("				<td class=\"tablebody1\"><b>手机</b>：</td>");
		out.println("				<td class=\"tablebody1\">");
		out.println("				<input type=\"text\" size=\"32\" maxlength=\"16\" name=\"cellphone\" value=\""+user.getCellphone()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/>");
		out.println("			</td>");
		out.println("			<tr>");
		out.println("");
		out.println("			<td class=\"tablebody1\"><b>Email地址</b>：<br>	请输入有效的邮件地址</td>");
		out.println("			<td class=\"tablebody1\">");
		out.println("			<input maxLength=\"50\" size=\"32\" maxlength=\"32\" name=\"email\" value=\""+user.getEmail()+"\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\"/></td>");
		out.println("			</tr>");
		out.println("			<tr>");
		out.println("			<td class=\"tablebody2\" valign=\"middle\" colspan=\"2\" align=\"center\">");
		out.println("			<input type=\"button\" value=\"修&nbsp;改\" onclick=\"javascript:checkReg()\"/>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		</table>");
		out.println("</form>");
		out.println("<html>");
		out.println("	<body>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
		out.println("		  <tr>");
		out.println("");
		out.println("		    <td height=\"17\" background=\"/ecport/images/bot_bg.gif\"></td>");
		out.println("		  </tr>");
		out.println("		</table>");
		out.println("		");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
		out.println("		  <tr>");
		out.println("		    <td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
		out.println("			<p align=\"center\">");
		out.println("				Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\">");
		out.println("");
		out.println("				<b><font face=\"Verdana,\">Tarena</font></b>");
		out.println("				<font color=#CC0000>.com.cn</font>");
		out.println("			</a></p><br>");
		out.println("		    </td>");
		out.println("		  </tr>");
		out.println("		</table>");
		out.println("	</body>");
		out.println("</html>");
		out.close();
	}

	private void initCountry()
	{
		String[] countries=COUNTRY.split(",");
		for(int i=0;i<countries.length;i++)
			country.put(countries[i],countries[++i]);
	}
	private void initProvince()
	{
		String[] provinces=PROVINCE.split(",");
		for(int i=0;i<provinces.length;i++)
			province.put(provinces[i], provinces[++i]);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	
}
