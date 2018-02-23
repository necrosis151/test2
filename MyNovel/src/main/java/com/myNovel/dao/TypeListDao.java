package com.myNovel.dao;

import com.myNovel.model.TypeList;

public interface TypeListDao {
    int deleteByPrimaryKey(Integer idtypelist);

    int insert(TypeList record);

    int insertSelective(TypeList record);

    TypeList selectByPrimaryKey(Integer idtypelist);

    int updateByPrimaryKeySelective(TypeList record);

    int updateByPrimaryKey(TypeList record);
}