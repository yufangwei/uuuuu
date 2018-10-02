package com.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.util.PageUtil;

public class showUserAction implements ModelDriven<PageUtil<User>> {
	
	HttpServletRequest req = ServletActionContext.getRequest();
	private int pageIndex;
	private UserService userService;
	private PageUtil<User> ypage = new PageUtil<User>();
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setYpage(PageUtil<User> ypage) {
		this.ypage = ypage;
	}
	
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public PageUtil<User> getModel() {
		// TODO Auto-generated method stub
		return null;
	}


	public String showAll() {
		ypage.setPageIndex(pageIndex);
		PageUtil<User> allPage = userService.getPage(ypage);
		req.setAttribute("allPage", allPage);
		return "showAll";
	}





}
