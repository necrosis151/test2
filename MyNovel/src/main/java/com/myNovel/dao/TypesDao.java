package com.myNovel.dao;

import java.util.List;

import com.myNovel.model.Types;

public interface TypesDao {
    int deleteByPrimaryKey(Integer idtypes);

    int insert(Types record);

    int insertSelective(Types record);

    Types selectByPrimaryKey(Integer idtypes);

    int updateByPrimaryKeySelective(Types record);

    int updateByPrimaryKey(Types record);
    
    List<Types> selectAllTypes();
}