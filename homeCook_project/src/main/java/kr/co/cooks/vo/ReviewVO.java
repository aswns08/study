package kr.co.cooks.vo;

import java.sql.Timestamp;

public class ReviewVO {
	
	private int re_Num;
	private String id;
	private String re_Title;
	private String re_Content;
	private Timestamp re_Date;
	private int re_Grade;
	private int re_Dept;
	private int re_Position;
	private int re_GroupId;
	private int f_Num;
	
	
	@Override
	public String toString() {
		return "ReviewVO [re_Num=" + re_Num + ", id=" + id + ", re_Title="
				+ re_Title + ", re_Content=" + re_Content + ", re_Date="
				+ re_Date + ", re_Grade=" + re_Grade + ", re_Dept=" + re_Dept
				+ ", re_Position=" + re_Position + ", re_GroupId=" + re_GroupId
				+ ", f_Num=" + f_Num + "]";
	}


	public int getRe_Num() {
		return re_Num;
	}


	public void setRe_Num(int re_Num) {
		this.re_Num = re_Num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRe_Title() {
		return re_Title;
	}


	public void setRe_Title(String re_Title) {
		this.re_Title = re_Title;
	}


	public String getRe_Content() {
		return re_Content;
	}


	public void setRe_Content(String re_Content) {
		this.re_Content = re_Content;
	}


	public Timestamp getRe_Date() {
		return re_Date;
	}


	public void setRe_Date(Timestamp re_Date) {
		this.re_Date = re_Date;
	}


	public int getRe_Grade() {
		return re_Grade;
	}


	public void setRe_Grade(int re_Grade) {
		this.re_Grade = re_Grade;
	}


	public int getRe_Dept() {
		return re_Dept;
	}


	public void setRe_Dept(int re_Dept) {
		this.re_Dept = re_Dept;
	}


	public int getRe_Position() {
		return re_Position;
	}


	public void setRe_Position(int re_Position) {
		this.re_Position = re_Position;
	}


	public int getRe_GroupId() {
		return re_GroupId;
	}


	public void setRe_GroupId(int re_GroupId) {
		this.re_GroupId = re_GroupId;
	}


	public int getF_Num() {
		return f_Num;
	}


	public void setF_Num(int f_Num) {
		this.f_Num = f_Num;
	}
	
	
	
	

}
