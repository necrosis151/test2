package com.myNovel.model;

public class BookContents {
	private Integer idbookcontents;

	private Integer chapter;

	private String chaptername;

	private String adress;

	private Integer bookid;

	private Integer userid;

	private String updatetime;

	public BookContents(String chaptername, String adress, Integer bookid,
			Integer userid, String updatetime) {
		this.chaptername = chaptername;
		this.adress = adress;
		this.bookid = bookid;
		this.userid = userid;
		this.updatetime = updatetime;
	}

	public BookContents() {

	}

	public Integer getIdbookcontents() {
		return idbookcontents;
	}

	public void setIdbookcontents(Integer idbookcontents) {
		this.idbookcontents = idbookcontents;
	}

	public Integer getChapter() {
		return chapter;
	}

	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}

	public String getChaptername() {
		return chaptername;
	}

	public void setChaptername(String chaptername) {
		this.chaptername = chaptername == null ? null : chaptername.trim();
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress == null ? null : adress.trim();
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime == null ? null : updatetime.trim();
	}
}