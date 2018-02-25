package com.myNovel.dao;

import java.util.List;

import com.myNovel.model.BookInfo;

public interface BookInfoDao {
    int deleteByPrimaryKey(Integer idbookinfo);

    int insertBookInfo(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer idbookinfo);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

	List<BookInfo> selectBookInfoByType(String type);
	
	List<BookInfo> selectBookInfoByUserId(int userid);
	
	List<Integer> selectBookidByPage(int BeginNum,int pageSize);
	
	List<BookInfo> selectBookInfosByPage(List<Integer> idlist);
}