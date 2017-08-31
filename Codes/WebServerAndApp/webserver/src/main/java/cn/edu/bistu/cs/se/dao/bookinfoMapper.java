package cn.edu.bistu.cs.se.dao;

import java.util.List;

import cn.edu.bistu.cs.se.model.bookinfo;

public interface bookinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(bookinfo record);

    int insertSelective(bookinfo record);

    bookinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(bookinfo record);

    int updateByPrimaryKey(bookinfo record);

	List<bookinfo> selectall();
	List<bookinfo> selectbook(String name);
}