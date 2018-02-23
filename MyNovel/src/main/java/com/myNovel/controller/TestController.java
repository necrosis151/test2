package com.myNovel.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myNovel.model.Test;

@Controller
public class TestController {
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
}
