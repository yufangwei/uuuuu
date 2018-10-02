package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	void add(User users);
	List<User> find(User ur);
	void del(User user);
	void upd(User user);
	List<User> getByPage(final int pageIndex,final int pageSize);
	int getCount();
	User findById(User user);
}
