package com.myNovel.serverimpl;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import util.DateUtil;

import com.myNovel.dao.BookInfoDao;
import com.myNovel.dao.TypeListDao;
import com.myNovel.model.BookInfo;
import com.myNovel.model.TypeList;
import com.myNovel.model.User;

@Component
public class BookInfoServerImpl {
	private BookInfoDao bookInfoDao;

	public BookInfoDao getBookInfoDao() {
		return bookInfoDao;
	}

	@Autowired
	public void setBookInfoDao(BookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}

	public List<BookInfo> getBookInfoListByType(String type) {
		return bookInfoDao.selectBookInfoByType(type);
	}

	public BookInfo getBookInfo(int id) {
		return bookInfoDao.selectByPrimaryKey(id);
	}

	private TypeListDao typeListDao;

	public TypeListDao getTypeListDao() {
		return typeListDao;
	}

	@Autowired
	public void setTypeListDao(TypeListDao typeListDao) {
		this.typeListDao = typeListDao;
	}

	@Transactional
	public int addBookInfo(String bookname, String bookmessage,
			int[] typelists, int userid) {

		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookname(bookname);
		bookInfo.setBookmessage(bookmessage);
		bookInfo.setUploaduser(userid);
		bookInfo.setUpdatetime(DateUtil.getDefaultStringDate());
		bookInfoDao.insertBookInfo(bookInfo);
		int bookInfoId = bookInfo.getIdbookinfo();

		for (int idtype : typelists) {

			TypeList typeList = new TypeList();

			typeList.setIdbook(bookInfo.getIdbookinfo());
			typeList.setIdtype(idtype);
			typeListDao.insert(typeList);
		}

		return bookInfoId;
	}

	public List<BookInfo> getBookInfoByUserID(int userid) {
		return bookInfoDao.selectBookInfoByUserId(userid);
	}

	public void updateBI(BookInfo bookInfo) {
		bookInfoDao.updateByPrimaryKey(bookInfo);
	}

	public List<BookInfo> getAllBookInfo() {

		return bookInfoDao.selectAllBookInfo();
	}
}
