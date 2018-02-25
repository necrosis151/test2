package test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myNovel.serverimpl.RedisTestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/Mybatis-spring.xml",
		"file:src/main/resources/spring-redis.xml",
		"file:src/main/resources/spring-mvc.xml" })
public class RedisTest {
	private RedisTestDao redisTestDao;

	public RedisTestDao getRedisTestDao() {
		return redisTestDao;
	}

	@Resource
	public void setRedisTestDao(RedisTestDao redisTestDao) {
		this.redisTestDao = redisTestDao;
	}

	@Test
	public void testGetLists() {

		System.out.println(redisTestDao.getTestList());

	}

}
