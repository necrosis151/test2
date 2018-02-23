package com.myNovel.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myNovel.model.User;
import com.myNovel.serverimpl.UserServerImpl;

import util.CaptchaUtil;
import util.CookieUtil;

@Controller
public class PageController {
	@Resource
	private UserServerImpl userServerImpl;

	public UserServerImpl getUserServerImpl() {
		return userServerImpl;
	}

	public void setUserServerImpl(UserServerImpl userServerImpl) {
		this.userServerImpl = userServerImpl;
	}
	
	
	
	@RequestMapping("/message")
	public String gosuccesspage(String info,Model model){
		
		model.addAttribute("info",info);
		return "success";
	}
	@RequestMapping("/showUserInfo")
	public String goshowUserInfo(){
		return "user/showUserInfo";
	}
	@RequestMapping(value = { "/", "" })
	public String goindex(HttpServletRequest request, HttpSession session) {
		
		String[] userlogininfo = null;
		try {
			String tempString = CookieUtil.findCookie("userlogininfo", request);
			if (tempString == "0&0"||tempString==null) {
				return "index";
			}
	
			userlogininfo = tempString.split("&");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = userServerImpl.getUserByName(userlogininfo[0]);
		if (userServerImpl.checkCookieLogin(userlogininfo[1], user)) {
			session.setAttribute("user", user);
			System.out.println("session add user");
		}

		return "index";
	}

	@RequestMapping("/registerPage")
	public String gotoRegisterPage() {
		return "user/register";
	}

	@RequestMapping("/userloginPage")
	public String userLogin(HttpServletResponse resp,HttpServletRequest req) {
		
		return "user/login";
	}

	@RequestMapping("/userinfoPage")
	public String userinfo() {
		return "showUserInfo";
	}
	
	
}
