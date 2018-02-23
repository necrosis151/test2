package com.myNovel.serverimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myNovel.dao.TypesDao;
import com.myNovel.model.Types;

@Component
public class TypesServerImpl {
	@Autowired
	private TypesDao typesDao;

	public TypesDao getTypesDao() {
		return typesDao;
	}

	public void setTypesDao(TypesDao typesDao) {
		this.typesDao = typesDao;
	}
	
	public List<Types> getAllTypes(){
		return typesDao.selectAllTypes();
	}
}
