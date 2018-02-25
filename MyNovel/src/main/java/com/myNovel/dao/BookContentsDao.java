package com.myNovel.dao;

import java.util.ArrayList;
import java.util.List;

import com.myNovel.model.BookContents;

public interface BookContentsDao {
    int deleteByPrimaryKey(Integer idbookcontents);

    int insert(List<BookContents> record);

    int insertSelective(BookContents record);

	BookContents selectByPrimaryKey(Integer idbookcontents);

    int updateByPrimaryKeySelective(BookContents bclist);

    int updateByPrimaryKey(BookContents record);

	ArrayList<BookContents> selectByBookInfoID(int bookid);
}