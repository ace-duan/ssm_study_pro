package com.ace.ssm.utils;

public class PageBean {
	private Integer currentPage;
	private Integer pageSize=5;
	private Integer totalPage;
	private Integer totalCount;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (int)(Math.ceil(this.totalCount*1.0/this.pageSize));
	}

	
}
