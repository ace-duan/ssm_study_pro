package com.ace.ssm.mapper;

import java.util.List;

import com.ace.ssm.domain.BookInfo;

public interface BookInfoMapper {
	
	//Fuzzy query
	List <BookInfo> queryAllBook(BookInfo bookInfo);

}
