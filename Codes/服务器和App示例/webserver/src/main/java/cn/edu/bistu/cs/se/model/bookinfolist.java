package cn.edu.bistu.cs.se.model;

import java.io.Serializable;
import java.util.List;

public class bookinfolist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403851481502147036L;
	
	private List<bookinfo> list;

	public List<bookinfo> getList() {
		return list;
	}

	public void setList(List<bookinfo> list) {
		this.list = list;
	}
	

}
