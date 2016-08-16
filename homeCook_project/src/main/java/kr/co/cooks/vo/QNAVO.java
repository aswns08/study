package kr.co.cooks.vo;

import java.sql.Timestamp;

public class QNAVO {
	
	private int q_Num;
	private String id;
	private String q_Title;
	private String q_Content;
	private Timestamp q_Date;
	private int q_Dept;
	private int q_Position;
	private int q_Groupid;
	private int f_Num;
	private String name;
	
	
	@Override
	public String toString() {
		return "QNAVO [q_Num=" + q_Num + ", id=" + id + ", q_Title=" + q_Title
				+ ", q_Content=" + q_Content + ", q_Date=" + q_Date
				+ ", q_Dept=" + q_Dept + ", q_Position=" + q_Position
				+ ", q_Groupid=" + q_Groupid + ", f_Num=" + f_Num + ", name="
				+ name + "]";
	}


	public int getQ_Num() {
		return q_Num;
	}


	public void setQ_Num(int q_Num) {
		this.q_Num = q_Num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getQ_Title() {
		return q_Title;
	}


	public void setQ_Title(String q_Title) {
		this.q_Title = q_Title;
	}


	public String getQ_Content() {
		return q_Content;
	}


	public void setQ_Content(String q_Content) {
		this.q_Content = q_Content;
	}


	public Timestamp getQ_Date() {
		return q_Date;
	}


	public void setQ_Date(Timestamp q_Date) {
		this.q_Date = q_Date;
	}


	public int getQ_Dept() {
		return q_Dept;
	}


	public void setQ_Dept(int q_Dept) {
		this.q_Dept = q_Dept;
	}


	public int getQ_Position() {
		return q_Position;
	}


	public void setQ_Position(int q_Position) {
		this.q_Position = q_Position;
	}


	public int getQ_Groupid() {
		return q_Groupid;
	}


	public void setQ_Groupid(int q_Groupid) {
		this.q_Groupid = q_Groupid;
	}


	public int getF_Num() {
		return f_Num;
	}


	public void setF_Num(int f_Num) {
		this.f_Num = f_Num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
