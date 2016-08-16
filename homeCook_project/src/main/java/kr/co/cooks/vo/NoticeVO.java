package kr.co.cooks.vo;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int no_Num;
	private String id;
	private String no_Title;
	private String no_Content;
	private Timestamp no_Date;
	private int no_Hit;
	
	@Override
	public String toString() {
		return "NoticeVO [no_Num=" + no_Num + ", id=" + id + ", no_Title="
				+ no_Title + ", no_Content=" + no_Content + ", no_Date="
				+ no_Date + ", no_Hit=" + no_Hit + "]";
	}
	
	public int getNo_Num() {
		return no_Num;
	}
	public void setNo_Num(int no_Num) {
		this.no_Num = no_Num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo_Title() {
		return no_Title;
	}
	public void setNo_Title(String no_Title) {
		this.no_Title = no_Title;
	}
	public String getNo_Content() {
		return no_Content;
	}
	public void setNo_Content(String no_Content) {
		this.no_Content = no_Content;
	}
	public Timestamp getNo_Date() {
		return no_Date;
	}
	public void setNo_Date(Timestamp no_Date) {
		this.no_Date = no_Date;
	}
	public int getNo_Hit() {
		return no_Hit;
	}
	public void setNo_Hit(int no_Hit) {
		this.no_Hit = no_Hit;
	}
	
	

}
