package com.mockup.user.service;

import java.util.HashMap;
import java.util.List;

import com.mockup.user.pojo.User;

public interface userService {
	public List getUserList();
	public User getCertainUser(String userid);
	public void login(User user);
	public Boolean registerUser(User user);
}
