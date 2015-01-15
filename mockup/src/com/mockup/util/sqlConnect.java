package com.mockup.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlConnect {

	public static Connection getConn() throws SQLException
	{
		Connection conn=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/gwap?useUnicode=true&characterEncoding=utf-8";
			String username="root";
			String password="";
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null)
			{
				System.out.println("数据库连接成功");
			}
			else
			{
				System.out.println("失败!");
			}		
		return conn;
		
	}
	
}
