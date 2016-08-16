package com.daejeon.bbs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.daejeon.bbs.vo.BoardVO;

@Repository
public class BBSDao implements BBSDaoService {

	ArrayList<BoardVO> articleList;
	BoardVO article;
	@Autowired SqlMapClientTemplate smct;

	@Override
	public String login_check(String id) {
		
		return (String)smct.queryForObject("login_check", id);
		
	}
	
	@Override
	public int getArticleCount() {
		return (int)smct.queryForObject("getCount");
	}

	@Override
	public List<BoardVO> getArticles(int startRow, int endRow) {
		HashMap<String, Integer> hm = new HashMap<>();
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		return smct.queryForList("getArticles", hm);

	}

	@Override
	public BoardVO getArticle(int article_Num) {
		
		return (BoardVO)smct.queryForObject("getArticle", article_Num);
		//return jdbcTemplate.queryForObject(sql, new Object[]{article_Num}, new BBSContentRowMapper());

	}
	
	@Override
	public void insertArticle(BoardVO article) {
		
		smct.insert("insertArticle", article);
		
	}
/*	
	@Override
	public void deleteArticle(int article_Num) {
		
		String sql = "delete from BBS where article_Num=?";
		jdbcTemplate.update(sql, new Object[]{article_Num});
		
	}
	
	@Override
	public BoardVO getUpdate(int article_Num) {
		
		String sql = "select title, content, fname from BBS where article_Num=?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{article_Num}, new BBSUpdateRowMapper());
	}
	
	@Override
	public void updateArticle(BoardVO article, int article_Num) {
		
		String sql = "update BBS set title=?, content=? where article_Num=?";
		jdbcTemplate.update(sql, new Object[]{article.getTitle(), article.getContent(), article_Num});
		
	}
	
	@Override
	public void replyArticle(BoardVO article) {
		
		String sqlUpdate = "update BBS set position=position+1 where group_Id=? and position>?";
		jdbcTemplate.update(sqlUpdate, new Object[]{article.getGroup_Id(), article.getPosition()});
		
		String sqlInsert = "insert into BBS values(bbs_seq.nextval,?,?,?,?,0,?,?,sysdate,?)";
		jdbcTemplate.update(sqlInsert, new Object[]{article.getId(), article.getTitle(), 
				article.getContent(), article.getDepth()+1, article.getGroup_Id(), 
				article.getPosition()+1, article.getFname()});
		
	}
	
	@Override
	public int getCommentCount(int article_Num) {

		String sql = "select count(*) from comments where article_Num =?" ;
		
		return jdbcTemplate.queryForObject(sql, new Object[]{article_Num}, Integer.class);
		
	}

*/
}
