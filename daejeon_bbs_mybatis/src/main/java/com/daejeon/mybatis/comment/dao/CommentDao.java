package com.daejeon.mybatis.comment.dao;

import java.util.HashMap;
import java.util.List;

import com.daejeon.mybatis.comment.vo.CommentVO;

public interface CommentDao {

	public void commentWrite(CommentVO comment);
	public List<CommentVO> commentRead(HashMap<String, Integer> hm); 
	

}
