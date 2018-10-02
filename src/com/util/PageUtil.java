package com.util;

import java.util.List;

public class PageUtil<T> {
	//ÿҳ��ʾ������
	private int pageSize=3;
	//��ǰҳ
	private int pageIndex;
	//������
	private int count;
	//��ҳ��
	private int pageCount;
	//���ݵļ���
	private List<T> list;
	
	//�Ƿ��ǵ�һҳ
	private boolean isfirst;
	//�Ƿ����һҳ
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
