package com.daejeon.comment.service;

import java.util.List;

import com.daejeon.comment.vo.CommentVO;

public interface CommentService {

	public List<CommentVO> commentWrite(CommentVO comment);
	public List<CommentVO> commentRead(int article_Num, int endRow);
}
