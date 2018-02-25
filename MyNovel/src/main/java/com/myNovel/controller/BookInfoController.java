package com.myNovel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import util.NumUtil;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.myNovel.model.BookContents;
import com.myNovel.model.BookInfo;
import com.myNovel.model.Types;
import com.myNovel.model.User;
import com.myNovel.serverimpl.BookContentServerimpl;
import com.myNovel.serverimpl.BookInfoServerImpl;
import com.myNovel.serverimpl.TypesServerImpl;

@Component
@RequestMapping("/book")
public class BookInfoController {
	private BookInfoServerImpl bookInfoServerImpl;

	public BookInfoServerImpl getBookInfoServerImpl() {
		return bookInfoServerImpl;
	}

	@Autowired
	public void setBookInfoServerImpl(BookInfoServerImpl bookInfoServerImpl) {
		this.bookInfoServerImpl = bookInfoServerImpl;
	}

	private TypesServerImpl typesServerImpl;

	public TypesServerImpl getTypesServerImpl() {
		return typesServerImpl;
	}

	@Autowired
	public void setTypesServerImpl(TypesServerImpl typesServerImpl) {
		this.typesServerImpl = typesServerImpl;
	}

	private BookContentServerimpl bookContentServerimpl;

	public BookContentServerimpl getBookContentServerimpl() {
		return bookContentServerimpl;
	}

	@Autowired
	public void setBookContentServerimpl(
			BookContentServerimpl bookContentServerimpl) {
		this.bookContentServerimpl = bookContentServerimpl;
	}

	@RequestMapping("/bookmanage/addbookinfo")
	public String addBookInfo(String bookname, String bookmessage,
			int[] typelists, MultipartFile[] files, HttpSession session,
			String[] filenames) {

		bookContentServerimpl.addBookContent(bookname, bookmessage,
				typelists, files, session, filenames);

		return "redirect:/message?info=addbookinfo_success";
	}

	@RequestMapping("/bookmanage/addbookinfopage")
	public String addBookInfoPage(Model model) {
		ArrayList<Types> types = (ArrayList<Types>) typesServerImpl
				.getAllTypes();
		model.addAttribute("types", types);
		return "book/addbookinfopage";
	}

	@RequestMapping("/bookmanage/userbooklist")
	public String goAddContentPage(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		int userid = user.getId();
		List<BookInfo> bookInfos = bookInfoServerImpl
				.getBookInfoByUserID(userid);
		model.addAttribute("bookInfos", bookInfos);

		return "book/showuserbooklist";
	}

	@RequestMapping("/getcontent{bookid}")
	public String magMainList(@PathVariable int bookid, Model model) {

		List<BookContents> bookContents = bookContentServerimpl
				.getBookContentsByBookID(bookid);
	
		model.addAttribute("bookContents", bookContents);

		return "book/clist";
	}

	@RequestMapping("/novelList")
	public String showBook(Model model){
//		
		return "book/novelList";
	}
	
	@RequestMapping("/bookmanage/updateBIPage{bookid}")
	public String updateBIPage(@PathVariable int bookid, Model model) {
		BookInfo bookInfo = bookInfoServerImpl.getBookInfo(bookid);
		ArrayList<Types> types = (ArrayList<Types>) typesServerImpl
				.getAllTypes();
		model.addAttribute("types", types);
		model.addAttribute("bookinfo", bookInfo);
		return "book/updateBIPage";
	}

	@RequestMapping("/bookmanage/upBI")
	public String upBI(BookInfo bookInfo) {
		return "redirect:/book/bookmanage/userbooklist";
	}
	
	
}
