package com.daejeon.comment.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.daejeon.comment.vo.CommentVO;

public interface CommentDaoService {

	public List<CommentVO> commentWrite(CommentVO comment);
	public List<CommentVO> commentRead(int article_Num, int endRow);
}
