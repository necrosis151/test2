package com.myNovel.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myNovel.model.Test;
import com.myNovel.serverimpl.RedisTestDao;

@Controller
public class TestController {
	@Autowired
	private RedisTestDao redisTestDao;

	public RedisTestDao getRedisTestDao() {
		return redisTestDao;
	}

	public void setRedisTestDao(RedisTestDao redisTestDao) {
		this.redisTestDao = redisTestDao;
	}

	@RequestMapping("/gojsonTest")
	public String goJson() {
		return "test/jsonTest";
	}

	@RequestMapping("/jsontest")
	@ResponseBody
	public Test test(@RequestBody Test test) {

		System.out.println("username: " + test.getUsername());
		System.out.println("password: " + test.getPassword());
		return test;
	}

	@RequestMapping("/redisTest")
	public void getRedis() {
		System.out.println(redisTestDao.getTestList());
		
	}
}
