package com.mockup.user.dao;

import java.util.List;

import com.mockup.user.pojo.User;

public interface userDao {
	public List getUserList();
	public User getCertainUser(String userid);
	public void login(User user);
	public Boolean registerUser(User user);
}
