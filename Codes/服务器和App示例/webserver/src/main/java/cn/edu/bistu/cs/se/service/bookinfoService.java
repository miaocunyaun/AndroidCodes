package cn.edu.bistu.cs.se.service;

import java.util.List;

import cn.edu.bistu.cs.se.model.bookinfo;

public interface bookinfoService {
public List<bookinfo> selectall();
public int addbook(bookinfo bif);
public int deleteByPrimaryKey(Integer id);
public bookinfo selectbookbyid(Integer id);
public int updateByPrimaryKey(bookinfo record);
public List<bookinfo> selectbook(String name);
}
