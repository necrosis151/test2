package com.myNovel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.CaptchaUtil;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	@RequestMapping()
	public void getCaptcha(HttpServletRequest req,HttpServletResponse resp){
		CaptchaUtil.getCaptcha(resp, req);
	}
	
}
