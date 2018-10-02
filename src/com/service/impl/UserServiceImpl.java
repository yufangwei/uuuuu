package com.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import com.util.PageUtil;
@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> find(User user) {
		return userDao.find(user);
	}

	@Override
	public void del(User user) {
		userDao.del(user);
		
	}

	@Override
	public void upd(User user) {
		userDao.upd(user);
		
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}
	@Override
	public User findById(User user) {
		return userDao.findById(user);
	}

	//操作分页对象
	public PageUtil<User> getPage(PageUtil<User> userPage){
		List<User> list = userDao.getByPage(userPage.getPageIndex(), userPage.getPageSize());
		int count = userDao.getCount();
		userPage.setCount(count);
		userPage.setPageSize(userPage.getPageSize());
		userPage.setPageIndex(userPage.getPageIndex());
		userPage.setList(list);
		userPage.setIsfirst(userPage.getPageIndex()==1?true:false);
		userPage.setPageCount(count%userPage.getPageSize()==0?
				count/userPage.getPageSize():count/userPage.getPageSize()+1);
		userPage.setIslast(userPage.getPageIndex()==userPage.getPageCount()?true:false);
		return userPage;
	}

	
	

}
