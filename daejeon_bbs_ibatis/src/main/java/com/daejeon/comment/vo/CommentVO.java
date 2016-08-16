package com.daejeon.comment.vo;

import java.sql.Timestamp;

public class CommentVO {

	private int comment_Num;
	private String id;
	private String comment_Content;
	private Timestamp comment_date;
	private int article_Num;
	
	@Override
	public String toString() {
		return "CommentVO [comment_Num=" + comment_Num + ", id=" + id
				+ ", comment_Content=" + comment_Content + ", comment_date="
				+ comment_date + ", article_Num=" + article_Num + "]";
	}


	public int getComment_Num() {
		return comment_Num;
	}


	public void setComment_Num(int comment_Num) {
		this.comment_Num = comment_Num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getComment_Content() {
		return comment_Content;
	}


	public void setComment_Content(String comment_Content) {
		this.comment_Content = comment_Content;
	}


	public Timestamp getComment_date() {
		return comment_date;
	}


	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}


	public int getArticle_Num() {
		return article_Num;
	}


	public void setArticle_Num(int article_Num) {
		this.article_Num = article_Num;
	}
	
	
	
	
	
}
