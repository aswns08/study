package com.daejeon.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daejeon.comment.dao.CommentDaoService;
import com.daejeon.comment.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired CommentDaoService commentdao;

	@Override
	public List<CommentVO> commentWrite(CommentVO comment) {

		return commentdao.commentWrite(comment);

	}	

	@Override
	public List<CommentVO> commentRead(int article_Num, int endRow) {
		
		return commentdao.commentRead(article_Num, endRow);
	}
}
