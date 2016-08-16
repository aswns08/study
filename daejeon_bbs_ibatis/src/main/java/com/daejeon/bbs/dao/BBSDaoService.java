package com.daejeon.bbs.dao;

import java.util.List;

import com.daejeon.bbs.vo.BoardVO;

public interface BBSDaoService {
	
	public String login_check(String id);
	public int getArticleCount();
	public List<BoardVO> getArticles(int startRow, int endRow) ;
	public BoardVO getArticle(int article_Num) ;
	public void insertArticle(BoardVO article);
//	public void deleteArticle(int article_Num) ;
//	public BoardVO getUpdate(int article_Num) ;
//	public void updateArticle(BoardVO article, int article_Num) ;
//	public void replyArticle(BoardVO article) ;
//	public int getCommentCount(int article_Num);
	
}
