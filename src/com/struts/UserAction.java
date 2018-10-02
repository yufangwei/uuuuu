package com.struts;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.entity.User_vo;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.util.DateTimeUtil;


public class UserAction implements ModelDriven<User_vo> {
	HttpServletRequest req = ServletActionContext.getRequest();
	private User_vo user_vo = new User_vo();
	private int id;
	private UserService userService;
	private int pageIndex;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User_vo getUser_vo() {
		return user_vo;
	}

	public void setUs_vo(User_vo user_vo) {
		this.user_vo = user_vo;
	}

	@Override
	public User_vo getModel() {
		// TODO Auto-generated method stub
		return user_vo;
	}
	public String add() {
		User user = new User();
		user.setId(user_vo.getId());
		user.setName(user_vo.getName());
		user.setPwd(user_vo.getPwd());
		user.setDt(DateTimeUtil.convertDate(user_vo.getDt()));
		userService.add(user);
		return "resgiter";
	}
	
	public String login() {
		User user = new User();
		user.setName(user_vo.getName());
		user.setPwd(user_vo.getPwd());
		List<User> ur = userService.find(user);
		if(ur!=null) {
			req.getSession().setAttribute("name", ur.get(0).getName());
			req.setAttribute("pageIndex", pageIndex);
			return "login";
		}
		return "doFail";
	}
	public String del() {
		User user = new User();
		user.setId(user_vo.getId());
		userService.del(user);
		return "del";
	}
	
	public String update() {
		User user = new User();
		user.setId(user_vo.getId());
		user.setName(user_vo.getName());
		user.setPwd(user_vo.getPwd());
		user.setDt(DateTimeUtil.convertDate(user_vo.getDt()));
		user = userService.findById(user);
		req.setAttribute("user", user);
		return "update.jsp";
		
	}
	
	public String upd() {
		User user = new User();
		user.setId(user_vo.getId());
		user.setName(user_vo.getName());
		user.setPwd(user_vo.getPwd());
		user.setDt(DateTimeUtil.convertDate(user_vo.getDt()));
		userService.upd(user);
		return "update";
	}
}
