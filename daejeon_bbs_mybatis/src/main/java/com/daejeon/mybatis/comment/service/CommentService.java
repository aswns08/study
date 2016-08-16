package com.daejeon.mybatis.comment.service;

import java.util.List;

import com.daejeon.mybatis.comment.vo.CommentVO;

public interface CommentService {

	public List<CommentVO> commentWrite(CommentVO comment);
	public List<CommentVO> commentRead(int article_Num, int endRow);
}
