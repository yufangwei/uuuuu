package com.struts;

import java.util.ArrayList;
import java.util.List;

import com.entity.User_vo;
import com.opensymphony.xwork2.ModelDriven;

public class AjaxAction implements ModelDriven<List<User_vo>> {
	private User_vo user_vo = new User_vo();
	private List<User_vo> list;

	
	public List<User_vo> getList() {
		return list;
	}


	public void setUser_vo(User_vo user_vo) {
		this.user_vo = user_vo;
	}


	@Override
	public List<User_vo> getModel() {
		
		return list;
	}
	
	public String ajax() {
		User_vo us = new User_vo(1,"aaa","pwd","wwww");
		User_vo us1 = new User_vo(2,"bbb","pwd","sss");
		User_vo us2 = new User_vo(3,"ccc","pwd","sss");
		list = new ArrayList<User_vo>();
		list.add(us);
		list.add(us1);
		list.add(us2);
		System.out.println(list.get(0).getId());
		return "suceess";
	}
}
