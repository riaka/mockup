package com.mockup.user.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mockup.user.pojo.User;
import com.mockup.user.service.userService;
import com.mockup.util.ConnectionFactory;
import com.mockup.util.DaoFactory;

public class userServiceImpl implements userService {

	@Override
	public List getUserList() {
		return DaoFactory.getUserDao().getUserList();
	}

	@Override
	public User getCertainUser(String userid) {
		return DaoFactory.getUserDao().getCertainUser(userid);
	}

	@Override
	public void login(User user) {
		DaoFactory.getUserDao().login(user);
	}
	
	@Override
	public Boolean registerUser(User user) {
		return DaoFactory.getUserDao().registerUser(user);
	}
}
