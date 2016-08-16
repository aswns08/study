package kr.ac.daejeon;

import java.sql.Timestamp;

public class BoardVO {
	
	private int article_Num;
	private String id;
	private String title;
	private String content;
	private int depth;
	private int hit;
	private int group_Id;
	private int position;
	private Timestamp write_Date;
	private String fname;
	
	@Override
	public String toString() {
		return "BoardVO [article_Num=" + article_Num + ", id=" + id
				+ ", title=" + title + ", content=" + content + ", depth="
				+ depth + ", hit=" + hit + ", group_Id=" + group_Id
				+ ", position=" + position + ", write_Date=" + write_Date
				+ ", fname=" + fname + "]";
	}
	
	public int getArticle_Num() {
		return article_Num;
	}
	public void setArticle_Num(int i) {
		this.article_Num = i;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroup_Id() {
		return group_Id;
	}
	public void setGroup_Id(int group_Id) {
		this.group_Id = group_Id;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Timestamp getWrite_Date() {
		return write_Date;
	}
	public void setWrite_Date(Timestamp write_Date) {
		this.write_Date = write_Date;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	

}
