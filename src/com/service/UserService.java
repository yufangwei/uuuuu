package com.service;

import java.util.List;

import com.entity.User;
import com.util.PageUtil;

public interface UserService {
	void add(User user);
	void upd(User user);
	PageUtil<User> getPage(PageUtil<User> userPage);
	List<User> find(User user);
	void del(User user);
	User findById(User user);
}
