package com.myNovel.model;

import java.io.Serializable;
import java.util.List;

public class BookInfo implements Serializable{
	private Integer idbookinfo;

	private String bookname;

	private String bookmessage;

	private String updatetime;

	private int uploaduser;

	private User user;

	private List<Types> types;

	public List<Types> getTypes() {
		return types;
	}

	public void setTypes(List<Types> types) {
		this.types = types;
	}

	public int getUploaduser() {
		return uploaduser;
	}

	public void setUploaduser(int uploaduser) {
		this.uploaduser = uploaduser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getIdbookinfo() {
		return idbookinfo;
	}

	public void setIdbookinfo(Integer idbookinfo) {
		this.idbookinfo = idbookinfo;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname == null ? null : bookname.trim();
	}

	public String getBookmessage() {
		return bookmessage;
	}

	public void setBookmessage(String bookmessage) {
		this.bookmessage = bookmessage == null ? null : bookmessage.trim();
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}

}