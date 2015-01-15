package com.mockup.user.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mockup.user.dao.userDao;
import com.mockup.user.pojo.User;
import com.mockup.util.ConnectionFactory;

public class userDaoImpl implements userDao {

	@Override
	public List getUserList() {
		List<User> users= new ArrayList();
		String query="select users.userid,password,street1,street2,city,province,country,zip,email,homephone,cellphone,officephone from users,contactinfo where users.userid = contactinfo.userid ;";
		Connection conn=null;
		Statement stmt= null;
		ResultSet result=null;
		try {
			conn = ConnectionFactory.getConn();
			stmt=conn.createStatement();
			result=stmt.executeQuery(query);
			
			while(result.next())
			{
				User user=new User();
				user.setUserid(result.getString("userid"));
				user.setPassword("password");
				user.setStreet1("street1");
				user.setStreet2("street2");
				user.setCity("city");
				user.setProvince("province");
				user.setCountry("country");
				user.setZip("zip");
				user.setEmail("email");
				user.setHomephone("homephone");
				user.setCellphone("cellphone");
				user.setOfficephone("officephone");
				
				users.add(user);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException("error when querying database ",e1);
		}
		finally {
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying database ",e);
			}
		}
		return users;
	}

	@Override
	public User getCertainUser(String userid) {
		String query="select users.userid,password,street1,street2,city,province,country,zip,email,homephone,"
				+ "cellphone,officephone from users,contactinfo where users.userid = contactinfo.userid and users.userid = '"+userid+"';";
		User user=new User();
		user.setUserid(userid);
		fetchUser(query, user);
		return user;
	}

	@Override
	public User login(String userid, String password) {
		String query="select users.userid,password,street1,street2,city,province,country,zip,email,homephone,cellphone,"
				+ "officephone from users,contactinfo where users.userid = contactinfo.userid and users.userid = '"+userid+"' and password = '"+password+"';";
		User user=new User();
		user.setUserid(userid);
		user.setPassword(password);
		fetchUser(query, user);
		return user;
	}
	private void fetchUser(String query, User user) {
		
		Connection conn=null;
		Statement stmt= null;
		ResultSet result=null;
		try {
			conn = ConnectionFactory.getConn();
			stmt=conn.createStatement();
			result=stmt.executeQuery(query);
			if(result.next())
			{		
				user.setUserid(result.getString("userid"));
				user.setPassword(result.getString("password"));
				user.setStreet1(result.getString("street1"));
				user.setStreet2(result.getString("street2"));
				user.setCity(result.getString("city"));
				user.setProvince(result.getString("province"));
				user.setCountry(result.getString("country"));
				user.setZip(result.getString("zip"));
				user.setEmail(result.getString("email"));
				user.setHomephone(result.getString("homephone"));
				user.setCellphone(result.getString("cellphone"));
				user.setOfficephone(result.getString("officephone"));
				user.setLogon(true);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException("error when querying database ",e1);
		}
		finally {
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying database ",e);
			}
		}
	}
	@Override
	public Boolean registerUser(User user) {
		Connection conn=null;
		Statement stmt= null;
		ResultSet result=null;
		Boolean flag = true;
		String query = "select userid from users";
		try {
			conn = ConnectionFactory.getConn();
			stmt=conn.createStatement();
			result=stmt.executeQuery(query);
			
			//表明已有人注册
			while(result.next())
			{
				if(user.getUserid().equals(result.getString("userid").trim()))
				{
					flag = false;
					break;
				}
			}
			if(flag)
			{
				result.last();
				System.out.println(result.getRow());
				System.out.println(user.getStreet1());
					
				//插入数据进数据库
				String str1 = "INSERT INTO users VALUES ('"+user.getUserid()+"', '"+user.getPassword()+"')";
				String str2 = "INSERT INTO contactinfo VALUES ("
						+ result.getRow() + ", '" + user.getUserid() + "', '"
						+ user.getStreet1().toString() + "', '"
						+ user.getStreet2().toString() + "', '"
						+ user.getCity().toString() + "', "
						+ user.getProvince() + ", " + user.getCountry() + ", '"
						+ user.getZip() + "', '" + user.getEmail() + "', '"
						+ user.getHomephone() + "', '" + user.getCellphone()
						+ "', '" + user.getOfficephone() + "')";
				if(stmt.executeUpdate(str1) == 0)
					flag = false;
				if(stmt.executeUpdate(str2) == 0)
					flag = false;
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException("error when inserting database ",e1);
		}
		finally {
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when inserting database ",e);
			}
		}
		return flag;
	}

}
