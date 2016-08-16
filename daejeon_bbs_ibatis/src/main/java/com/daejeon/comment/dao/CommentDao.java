package com.daejeon.comment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daejeon.comment.rowmapper.CommentRowMapper;
import com.daejeon.comment.vo.CommentVO;

@Repository
public class CommentDao implements CommentDaoService {

	@Autowired JdbcTemplate jdbcTemplate;

	@Override
	public List<CommentVO> commentWrite(CommentVO comment) {

		String sql = "insert into comments values(comment_seq.nextval,?,?,sysdate,?)";
		
		jdbcTemplate.update(sql, new Object[]{comment.getId(), comment.getComment_Content(),
				comment.getArticle_Num() });
		
		return commentRead(comment.getArticle_Num(), 20);
	}
	
	@Override
	public List<CommentVO> commentRead(int article_Num, int endRow) {
	
		String sql = "select * from (select rownum rm,human.* from "
				+ "(select * from comments where article_Num=? order by comment_Num) human) "
				+ "where rm between 1 and ?" ;
		return jdbcTemplate.query(sql, new Object[]{article_Num, endRow}, new CommentRowMapper() );
	}
}
