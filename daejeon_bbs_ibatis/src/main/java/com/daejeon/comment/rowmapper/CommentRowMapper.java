package com.daejeon.comment.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.daejeon.comment.vo.CommentVO;

public class CommentRowMapper implements RowMapper<CommentVO> {
	CommentVO commentVO;
	
	@Override
	public CommentVO mapRow(ResultSet rs, int arg1) throws SQLException {
		commentVO = new CommentVO();
		
		commentVO.setComment_Num(rs.getInt("comment_Num"));
		commentVO.setId(rs.getString("id"));
		commentVO.setComment_Content(rs.getString("comment_Content"));
		commentVO.setComment_date(rs.getTimestamp("comment_date"));
		commentVO.setArticle_Num(rs.getInt("article_Num"));
		return commentVO;
	}
}
