package com.myNovel.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import util.CookieUtil;
import util.ImageUtil;

import com.myNovel.model.User;
import com.myNovel.serverimpl.BookInfoServerImpl;
import com.myNovel.serverimpl.UserServerImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserServerImpl userServerImpl;

	public UserServerImpl getUserServerImpl() {
		return userServerImpl;
	}

	@Autowired
	public void setUserServerImpl(UserServerImpl userServerImpl) {
		this.userServerImpl = userServerImpl;
	}

	private BookInfoServerImpl bookInfoServerImpl;

	public BookInfoServerImpl getBookInfoServerImpl() {
		return bookInfoServerImpl;
	}

	@Autowired
	public void setBookInfoServerImpl(BookInfoServerImpl bookInfoServerImpl) {
		this.bookInfoServerImpl = bookInfoServerImpl;
	}

	@RequestMapping("/register")
	public String addUser(String username, String password, Model model) {
		if (userServerImpl.addUser(username, password)) {
			// model.addAttribute("info", "register success");
			// return "success";
			return "redirect:/message?info=register success";
		}
		model.addAttribute("info", "register fail");
		return "false";
	}

	@RequestMapping("/usermanage/userinfo")
	public String showUserInfo() {
		return "user/showUserInfo";
	}

	@RequestMapping("/usermanage/updatepage")
	public String changeUserInfo() {
		return "user/changeUserInfo";
	}

	@RequestMapping("/usermanage/update")
	public String userupdate(String username, String password,
			MultipartFile faceimage, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		User user = ((User) session.getAttribute("user"));
		String imgadree = ImageUtil.savePic(faceimage, 180, 140, "facepic",
				session);
		user = userServerImpl.updateUser(username, password, imgadree, user);
		session.setAttribute("user", user);
		try {
			CookieUtil.addCookie(username,
					user.getUsername() + "&" + user.getPassword(), 3600,
					response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/showUserInfo";
	}

	@RequestMapping("/userlogin")
	public String userLogin(String username, String password, String captcha,
			HttpSession session, Model model, HttpServletResponse response) {
		
		User user = userServerImpl.getUserByName(username);
		if (!captcha.equalsIgnoreCase((String) session.getAttribute("code"))) {
			return "redirect:/message?info=loginFalse";
		}
		if (userServerImpl.checkCookieLogin(password, user)) {

			session.setAttribute("user", user);

			try {
				CookieUtil.addCookie("userlogininfo",
						username + "&" + password, 3600, response);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "redirect:/message?info=loginSuccess";
		}
		model.addAttribute("info", "账号或密码错误");
		return "redirect:/message?info=loginFalse";
	}

	@RequestMapping("/usermanage/userlogout")
	public String userLogout(Model model, HttpSession session,
			HttpServletResponse response) {
		try {
			CookieUtil.addCookie("userlogininfo", "0&0", 3600, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.removeAttribute("user");
		model.addAttribute("info", "注销成功");
		return "success";
	}
}
