package kr.ac.daejeon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BBSDaoService {
	
	public int getArticleCount() throws SQLException, IOException;
	public ArrayList<BoardVO> getArticles(int startRow, int endRow) throws SQLException, IOException;
	public int login_check(String id, String pass) throws IOException, SQLException;
	public void insertArticle(BoardVO article) throws IOException, SQLException;
	public BoardVO getArticle(int article_Num) throws IOException, SQLException;
	public void replyArticle(BoardVO article) throws IOException, SQLException;
	public void deleteArticle(int article_Num) throws IOException, SQLException;
	public void updateArticle(int article_Num, String title, String content) throws IOException, SQLException;
	public BoardVO getUpdate(int article_Num) throws IOException, SQLException;
	
}
