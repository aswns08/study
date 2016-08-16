package com.daejeon.mybatis.bbs.dao;

import java.util.HashMap;
import java.util.List;

import com.daejeon.mybatis.bbs.vo.BoardVO;

public interface BBSDao  {

	public int getArticleCount();
	public List<BoardVO> getArticles(HashMap<String, Integer> hashmap);
	public String login_check(String id);
	public BoardVO content(int article_Num);
	public void insertArticle(BoardVO article);
	public void deleteArticle(int article_Num);
	public BoardVO getUpdateForm(int article_Num);
	public void update(BoardVO article);
	public void updatePosition(BoardVO article);
	public void reply(BoardVO article);
	public int getCommentCount(int article_Num);

}
