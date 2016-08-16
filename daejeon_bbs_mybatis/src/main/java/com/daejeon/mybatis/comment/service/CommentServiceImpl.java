package com.daejeon.mybatis.comment.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daejeon.mybatis.comment.dao.CommentDao;
import com.daejeon.mybatis.comment.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired CommentDao commentDao;

	@Override
	public List<CommentVO> commentWrite(CommentVO comment) {

		commentDao.commentWrite(comment);

		return commentRead(comment.getArticle_Num(), 20);

	}	

	@Override
	public List<CommentVO> commentRead(int article_Num, int endRow) {

		HashMap<String, Integer> hm = new HashMap<>();

		hm.put("article_Num", article_Num);
		hm.put("endRow", endRow);

		return commentDao.commentRead(hm);
	}


}
