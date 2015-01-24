package com.mockup.user.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mockup.user.pojo.User;
import com.mockup.util.ServiceFactory;

public class usermodifyFilter implements Filter {
	private static String COUNTRY="1,中国,2,中国香港,3,中国台湾";
	private static String PROVINCE="1,安徽,2,北京,3,重庆,4,福建,5,广东,6,甘肃,7,广西,8,贵州,9,河南,10,湖北,11,河北,12,海南,13,香港,14,黑龙江,15,湖南,16,吉林,17,江苏,18,江西,19,辽宁,20,澳门,21,内蒙古,22,宁夏,"
			+ "23,青海,24,四川,25,山东,26,上海,27,陕西,28,山西,29,天津,30,台湾,31,新疆,32,西藏,33,云南,34,浙江,35,其它,36,中国香港,37,中国台湾";
	private List<String> province=new ArrayList<String>();
	private List<String> country=new ArrayList<String>();
	
	/*private static String COUNTRY="未选择,中国,中国香港,中国台湾";
	private static String PROVINCE="未选择,安徽,北京,重庆,福建,广东,甘肃,广西,贵州,河南,湖北,河北,海南,香港,黑龙江,湖南,吉林,江苏,江西,辽宁,澳门,内蒙古,宁夏,"
			+ "青海,四川,山东,上海,陕西,山西,天津,台湾,新疆,西藏,云南,浙江,其它,中国香港,中国台湾";
	
	private String[] province={};
	private String[] country={};*/
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=((HttpServletRequest) req).getSession();
		User user=(User)session.getAttribute("user");
		((HttpServletRequest) req).setAttribute("user", ServiceFactory.getUserService().getCertainUser(user.getUserid()));
		this.initCountry();
		this.initProvince();
		((HttpServletRequest) req).setAttribute("country", country);
		((HttpServletRequest) req).setAttribute("province", province);
		((HttpServletRequest)req).getRequestDispatcher("/userModify.vm").forward(req, resp);
		return ;
		//chain.doFilter(req, resp);
	}

	/*private void initProvince() {
		province=PROVINCE.split(",");	
	}

	private void initCountry() {
		country=COUNTRY.split(",");
	}*/

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	private void initCountry()
	{
		country.clear();
		String[] countries=COUNTRY.split(",");
		for(int i=0;i<countries.length;i++)
			country.add(countries[++i]);
	}
	private void initProvince()
	{
		province.clear();
		String[] provinces=PROVINCE.split(",");
		for(int i=0;i<provinces.length;i++)
			province.add(provinces[++i]);
	}

}
