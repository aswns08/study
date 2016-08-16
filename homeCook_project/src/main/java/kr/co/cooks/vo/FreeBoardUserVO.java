package kr.co.cooks.vo;

import java.sql.Timestamp;

public class FreeBoardUserVO {
	private int free_num;			//글번호
	private String id ;				//아이디
	private String free_title; 		//글 제목
	private String free_content;	//글 내용
	private Timestamp free_date;	//날짜
	private int free_hit;			//조회수
	private String name;			//이름
	
	public int getFree_num() {
		return free_num;
	}
	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFree_title() {
		return free_title;
	}
	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}
	public String getFree_content() {
		return free_content;
	}
	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}
	public Timestamp getFree_date() {
		return free_date;
	}
	public void setFree_date(Timestamp free_date) {
		this.free_date = free_date;
	}
	public int getFree_hit() {
		return free_hit;
	}
	public void setFree_hit(int free_hit) {
		this.free_hit = free_hit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "FreeBoardUserVO [free_num=" + free_num + ", id=" + id
				+ ", free_title=" + free_title + ", free_content="
				+ free_content + ", free_date=" + free_date + ", free_hit="
				+ free_hit + ", name=" + name + "]";
	}
}
