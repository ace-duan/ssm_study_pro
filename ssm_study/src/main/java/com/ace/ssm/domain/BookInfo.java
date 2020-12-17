package com.ace.ssm.domain;

import java.util.Date;

public class BookInfo {
	private Integer bookid;
	private String bookname;
	private String bookauthor;
	private String booktype;
	private String publishpress;
	private Date publishdate;
	private Integer isborrow;
	private String createdby;
	private Date creationtime;
	private Date lastupdatetime;
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getPublishpress() {
		return publishpress;
	}
	public void setPublishpress(String publishpress) {
		this.publishpress = publishpress;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public Integer getIsborrow() {
		return isborrow;
	}
	public void setIsborrow(Integer isborrow) {
		this.isborrow = isborrow;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}
	public Date getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	@Override
	public String toString() {
		return "BookInfo [bookid=" + bookid + ", bookname=" + bookname + ", bookauthor=" + bookauthor + ", booktype="
				+ booktype + ", publishpress=" + publishpress + ", publishdate=" + publishdate + ", isborrow="
				+ isborrow + ", createdby=" + createdby + ", creationtime=" + creationtime + ", lastupdatetime="
				+ lastupdatetime + "]";
	}
	

}
