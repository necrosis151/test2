package com.myNovel.serverimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import util.DateUtil;
import util.SaveTxtUtil;

import com.myNovel.dao.BookContentsDao;
import com.myNovel.model.BookContents;
import com.myNovel.model.User;

@Component
public class BookContentServerimpl {

	private BookContentsDao bookContentsDao;

	private BookInfoServerImpl bookInfoServerImpl;

	public BookInfoServerImpl getBookInfoServerImpl() {
		return bookInfoServerImpl;
	}

	@Autowired
	public void setBookInfoServerImpl(BookInfoServerImpl bookInfoServerImpl) {
		this.bookInfoServerImpl = bookInfoServerImpl;
	}

	public BookContentsDao getBookContentsDao() {
		return bookContentsDao;
	}

	@Autowired
	public void setBookContentsDao(BookContentsDao bookContentsDao) {
		this.bookContentsDao = bookContentsDao;
	}

	public List<BookContents> getBookContentsByBookID(int bookid) {
		return bookContentsDao.selectByBookInfoID(bookid);
	}

	@Transactional
	public void addBookContent(String bookname, String bookmessage,
			int[] typelists, MultipartFile[] files, HttpSession session,
			String[] filenames) {

		ArrayList<String> filesadress = SaveTxtUtil.saveTxt(files, session);
		List<BookContents> bclist = new ArrayList<>();

		int userid = ((User) session.getAttribute("user")).getId();
		int bookid = bookInfoServerImpl.addBookInfo(bookname, bookmessage,
				typelists, userid);
		System.out.println("----------------" + bookid + "-------------");
		// Iterator<String> it=filesadress.iterator();
		if (!(files.length == 0)) {
			BookContents bookContents = null;
			int chapter = 0;
			for (int i = 0; i < files.length; i++) {
				if (!files[i].isEmpty()) {
					bookContents = new BookContents(filenames[i],
							filesadress.get(chapter), bookid, userid,
							DateUtil.getDefaultStringDate());
//					bookContents.setChaptername(filenames[i]);
//					bookContents.setAdress(filesadress.get(chapter));
//					bookContents.setBookid(bookid);
//					bookContents.setUserid(userid);
//					bookContents.setUpdatetime(DateUtil.getDefaultStringDate());
					chapter++;

					bclist.add(bookContents);
				}
			}
		}
		bookContentsDao.insert(bclist);
	}
}
