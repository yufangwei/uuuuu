package com.util;

import java.util.List;

public class PageUtil<T> {
	//每页显示的条数
	private int pageSize=3;
	//当前页
	private int pageIndex;
	//总条数
	private int count;
	//总页数
	private int pageCount;
	//数据的集合
	private List<T> list;
	
	//是否是第一页
	private boolean isfirst;
	//是否最后一页
	private boolean islast;
	
	
	
	
	public boolean isIsfirst() {
		return isfirst;
	}
	public void setIsfirst(boolean isfirst) {
		this.isfirst = isfirst;
	}
	public boolean isIslast() {
		return islast;
	}
	public void setIslast(boolean islast) {
		this.islast = islast;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
