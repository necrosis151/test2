package com.myNovel.serverimpl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisTestDao {
	private ListOperations<String, String> listop;

	public ListOperations<String, String> getLists() {
		return listop;
	}

	@Resource(name = "redisTemplate")
	public void setLists(ListOperations<String, String> listop) {
		this.listop = listop;
	}

	public Long getTestList() {

		return  listop.size("ltest");

	}
}
