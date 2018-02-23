package com.myNovel.serverimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.myNovel.dao.UserDao;
import com.myNovel.model.User;

@Component
public class UserServerImpl {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean checkUserExist(String username) {
		if (getUserByName(username) == null) {
			return false;
		}
		return true;
	}

	public User getUserByName(String username) {
		return userDao.selectByUsername(username);
	}

	public boolean checkCookieLogin(String password, User user) {

		if (user != null && (user.getPassword()).equals(password)) {

			return true;
		}
		return false;
	}

	public boolean addUser(String username, String password) {
		if (this.checkUserExist(username)) {
			return false;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userDao.insertSelective(user);
		return true;
	}

	public User updateUser(String username, String password, String faceimage,
			User user) {
		user.setUsername(username);
		user.setPassword(password);
		user.setFaceimage(faceimage);
		userDao.updateByPrimaryKeySelective(user);
		return user;
	}

}
