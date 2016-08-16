package com.daejeon.bbs.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daejeon.bbs.vo.BoardVO;

public interface BBSDaoService {
	
	public int login_check(String id, String pwd) throws IOException, SQLException;
	public int getArticleCount() throws SQLException, IOException;
	public ArrayList<BoardVO> getArticles(int startRow, int endRow) throws SQLException, IOException;
	public BoardVO getArticle(int article_Num) throws IOException, SQLException;
	public void insertArticle(BoardVO article) throws IOException, SQLException;
	public void deleteArticle(int article_Num) throws IOException, SQLException;
	public BoardVO getUpdate(int article_Num) throws IOException, SQLException;
	public void updateArticle(int article_Num, String title, String content) throws IOException, SQLException;
	public void replyArticle(BoardVO article) throws IOException, SQLException;
	
	
}
