package com.mockup.user.service;

import java.util.List;

import com.mockup.user.pojo.User;

public interface userService {
	public List getUserList();
	public User getCertainUser(String userid);
}
