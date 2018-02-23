package com.myNovel.dao;

import java.util.List;

import com.myNovel.model.BookContents;

public interface BookContentsDao {
    int deleteByPrimaryKey(Integer idbookcontents);

    int insert(BookContents record);

    int insertSelective(BookContents record);

	BookContents selectByPrimaryKey(Integer idbookcontents);

    int updateByPrimaryKeySelective(BookContents record);

    int updateByPrimaryKey(BookContents record);

	List<BookContents> selectByBookInfoID(int bookid);
}