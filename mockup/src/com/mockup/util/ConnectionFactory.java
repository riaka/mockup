package com.mockup.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DB_PASSWORD = "";
	private static final String DB_USER = "root";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gwap?useUnicode=true&characterEncoding=utf-8";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	public static Connection getConn() 
	{
		Connection conn=null;
		
			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url=DB_URL;
			String username=DB_USER;
			String password=DB_PASSWORD;
			try {
				conn=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage(),e);
			}
			
		return conn;
		
	}
	
}
