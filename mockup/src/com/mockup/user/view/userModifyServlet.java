package com.mockup.user.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mockup.user.pojo.User;

public class userModifyServlet extends HttpServlet{

	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String contextpath=(String)this.getServletContext().getAttribute("contextpath");
		String imagepath=(String)this.getServletContext().getAttribute("imagepath");
		String csspath=(String)this.getServletContext().getAttribute("csspath");
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		List<String> province=(ArrayList<String>)req.getAttribute("province");
		List<String> country=(ArrayList<String>)req.getAttribute("country");
		/*String[] province=(String[])req.getAttribute("province");
		String[] country=(String[])req.getAttribute("country");*/
				
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 \">");
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>达内电子商务门户</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
		out.println("		<link href=\""+csspath+"/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
		out.println("");
		out.println("<!-- Header Start -->");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
		out.println("			<tr>");
		out.println("				<td align=\"left\" width=\"7%\" background=\""+imagepath+"/top_bg.gif\"><img src=\""+imagepath+"/logo.gif\" width=\"286\" height=\"58\"></td>");
		out.println("				<td width=\"62%\" background=\""+imagepath+"/top_bg.gif\">　</td>");
		out.println("				<td width=\"31%\" background=\""+imagepath+"/top_bg.gif\" align=\"right\"><img src=\""+imagepath+"/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		out.println("");
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
		out.println("					<img src=\""+imagepath+"/Forum_nav.gif\" align=\"absmiddle\">");
		out.println("					<a href=index.jsp>达内电子商务门户</a> →用户信息修改");
		out.println("				</td>");
		out.println("			</tr>");
		out.println("		</table>");
		out.println("		<br>");
		out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder1\">");
		out.println("			<tr>");
		out.println("				 <td colspan=\"2\" align=\"center\" valign=\"middle\" background=\""+imagepath+"/bg2.gif\" width=\"60%\"> &nbsp;&nbsp;<font><b>用户信息修改</b></font> ");
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
		for(int i=0;i<country.size();i++)
		{
			if(coun.equals(String.valueOf(i+1)))
				out.println("    						<option value=\""+i+"\" selected>"+country.get(i)+"</option>");
			else out.println("    						<option value=\""+i+"\" >"+country.get(i)+"</option>");

		}
		out.println("					</select>");
		out.println("					<select name=\"province\" style=\"font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000\">");
		out.println("               		  	");
		String prov=user.getProvince();
		for(int i=0;i<province.size();i++)
		{
			if(prov.equals(String.valueOf(i+1)))
				out.println("    						<option value=\""+i+"\" selected>"+province.get(i)+"</option>");
			else out.println("    						<option value=\""+i+"\" >"+province.get(i)+"</option>");
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
		out.println("		    <td height=\"17\" background=\""+imagepath+"/bot_bg.gif\"></td>");
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
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	
}
