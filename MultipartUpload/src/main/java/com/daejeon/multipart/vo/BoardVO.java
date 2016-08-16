package com.daejeon.multipart.vo;

import java.sql.Timestamp;

public class BoardVO {
	
	private int article_Num;
	private String content;
	private Timestamp write_date;
	
	
	@Override
	public String toString() {
		return "BoardVO [article_Num=" + article_Num + ", content=" + content
				+ ", write_date=" + write_date + "]";
	}


	public int getArticle_Num() {
		return article_Num;
	}


	public void setArticle_Num(int article_Num) {
		this.article_Num = article_Num;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getWrite_date() {
		return write_date;
	}


	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	
	
	

}
