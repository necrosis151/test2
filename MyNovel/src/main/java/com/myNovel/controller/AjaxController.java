package com.myNovel.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import util.CaptchaUtil;

import com.google.gson.Gson;
import com.myNovel.model.BookInfo;
import com.myNovel.serverimpl.BookInfoServerImpl;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	private BookInfoServerImpl bookInfoServerImpl;

	public BookInfoServerImpl getBookInfoServerImpl() {
		return bookInfoServerImpl;
	}

	@Autowired
	public void setBookInfoServerImpl(BookInfoServerImpl bookInfoServerImpl) {
		this.bookInfoServerImpl = bookInfoServerImpl;
	}

	@ResponseBody
	@RequestMapping("/getbookinfo")
	public List<BookInfo> getbookinfoByPage(@RequestBody Map<String,Integer> map) {
		
		return bookInfoServerImpl.getBookInfoByPage(map.get("pageNum"), map.get("pageSize"));

	}
	@RequestMapping("/check")
	public void getCaptcha(HttpServletRequest req,HttpServletResponse resp){
		CaptchaUtil.getCaptcha(resp, req);
	}
}
