package com.framework.base.pager;

import java.util.List;

public class Pager {

	private int pageNow = 1;
	private int pageSize = 10;
	private int totalCount;
	private int totalPage;
	private int offSet;
	private List<?> datas;
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (this.totalCount%this.pageSize==0)?this.totalCount/this.pageSize:(this.totalCount/this.pageSize)+1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffSet() {
		this.offSet = (this.pageNow-1)*this.pageSize;
		return this.offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	public List<?> getDatas() {
		return datas;
	}
	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
	
	
}
