package com.myNovel.model;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;

	private String username;

	private String password;

	private String faceimage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getFaceimage() {
		return faceimage;
	}

	public void setFaceimage(String faceimage) {
		this.faceimage = faceimage == null ? null : faceimage.trim();
	}
}