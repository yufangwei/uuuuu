package com.entity;

public class User_vo {

	private int id;
	private String name;
	private String pwd;
	private String dt;
	
	public User_vo() {
		
	}
	public User_vo(int id, String name, String pwd, String dt) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.dt = dt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	
}
