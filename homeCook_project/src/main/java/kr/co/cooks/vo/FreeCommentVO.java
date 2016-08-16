package kr.co.cooks.vo;

import java.sql.Timestamp;

public class FreeCommentVO {
	private int fcomment_num;			//코멘트번호
	private String id ;					//아이디
	private String fcomment_content;	//글 내용
	private Timestamp fcomment_date;	//날짜
	private  int free_num;				//글번호
	
	public int getFcomment_num() {
		return fcomment_num;
	}
	public void setFcomment_num(int fcomment_num) {
		this.fcomment_num = fcomment_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFcomment_content() {
		return fcomment_content;
	}
	public void setFcomment_content(String fcomment_content) {
		this.fcomment_content = fcomment_content;
	}
	public Timestamp getFcomment_date() {
		return fcomment_date;
	}
	public void setFcomment_date(Timestamp fcomment_date) {
		this.fcomment_date = fcomment_date;
	}
	public int getFree_num() {
		return free_num;
	}
	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}
	
	
	@Override
	public String toString() {
		return "FreeCommentVO [fcomment_num=" + fcomment_num + ", id=" + id
				+ ", fcomment_content=" + fcomment_content + ", fcomment_date="
				+ fcomment_date + ", free_num=" + free_num + "]";
	}
}
