package cn.edu.bistu.cs.se.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.bistu.cs.se.dao.bookinfoMapper;
import cn.edu.bistu.cs.se.model.bookinfo;
import cn.edu.bistu.cs.se.service.bookinfoService;
@Service
public class bookinfoServiceImpl implements bookinfoService {
	@Resource
	private bookinfoMapper bookMapper;
	@Override
	public List<bookinfo> selectall() {
		// TODO Auto-generated method stub
		return bookMapper.selectall();
	}
	@Override
	public int addbook(bookinfo bif) {
		// TODO Auto-generated method stub
		return bookMapper.insertSelective(bif);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return bookMapper.deleteByPrimaryKey(id);
}
	@Override
	public bookinfo selectbookbyid(Integer id) {
		// TODO Auto-generated method stub
		
		return bookMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKey(bookinfo record) {
		// TODO Auto-generated method stub
		return bookMapper.updateByPrimaryKey(record);
	}
	@Override
	public List<bookinfo> selectbook(String name) {
		// TODO Auto-generated method stub
		return bookMapper.selectbook("%"+name+"%");
	}
}