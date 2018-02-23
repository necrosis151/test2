package test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.myNovel.model.BookInfo;
import com.myNovel.serverimpl.BookInfoServerImpl;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration(locations = {
		"file:src/main/resources/Mybatis-spring.xml",
		"file:src/main/resources/spring-mvc.xml" })
// 加载配置文件
public class BookInfoTest {

	@Resource
	private BookInfoServerImpl bookInfoServerImpl;

	public BookInfoServerImpl getBookInfoServerImpl() {
		return bookInfoServerImpl;
	}

	public void setBookInfoServerImpl(BookInfoServerImpl bookInfoServerImpl) {
		this.bookInfoServerImpl = bookInfoServerImpl;
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testselType() {

		ArrayList<BookInfo> bookInfos = (ArrayList<BookInfo>) bookInfoServerImpl
				.getBookInfoListByType("科幻类");
		for (BookInfo bookInfo : bookInfos) {
			System.out.println(bookInfo.getUser().getUsername() + "  "
					+ bookInfo.getBookname());
		}

		// assertTrue(bookInfos.size() > 0);
		// User user=userServerImpl.getUserByName("test1");
		// System.out.println(user.getId());
	}

//	@Test
//	@Transactional
//	@Rollback(false)
//	public void testinsertbookinfo() {
//
//		
//
//		// assertTrue(bookInfos.size() > 0);
//		// User user=userServerImpl.getUserByName("test1");
//		// System.out.println(user.getId());
//	}
	
}
