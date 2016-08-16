package kr.co.cooks.vo;

import java.sql.Timestamp;

public class UserOrderVO {
	
	private String id;				// 아이디
	private int o_Num;				// 주문번호
	private String r_Num;			// 식당번호
	private Timestamp o_Date;		// 주문날짜
	private int o_Count;			// 구매수량
	private int o_Price;			// 주문금액
	private int f_Num;				//음식 번호
	private String f_Name ;			//음식 이름
	private int f_Price;			//가격
	
	
	@Override
	public String toString() {
		return "UserOrderVO [id=" + id + ", o_Num=" + o_Num + ", r_Num="
				+ r_Num + ", o_Date=" + o_Date + ", o_Count=" + o_Count
				+ ", o_Price=" + o_Price + ", f_Num=" + f_Num + ", f_Name="
				+ f_Name + ", f_Price=" + f_Price + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getO_Num() {
		return o_Num;
	}


	public void setO_Num(int o_Num) {
		this.o_Num = o_Num;
	}


	public String getR_Num() {
		return r_Num;
	}


	public void setR_Num(String r_Num) {
		this.r_Num = r_Num;
	}


	public Timestamp getO_Date() {
		return o_Date;
	}


	public void setO_Date(Timestamp o_Date) {
		this.o_Date = o_Date;
	}


	public int getO_Count() {
		return o_Count;
	}


	public void setO_Count(int o_Count) {
		this.o_Count = o_Count;
	}


	public int getO_Price() {
		return o_Price;
	}


	public void setO_Price(int o_Price) {
		this.o_Price = o_Price;
	}


	public int getF_Num() {
		return f_Num;
	}


	public void setF_Num(int f_Num) {
		this.f_Num = f_Num;
	}


	public String getF_Name() {
		return f_Name;
	}


	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}


	public int getF_Price() {
		return f_Price;
	}


	public void setF_Price(int f_Price) {
		this.f_Price = f_Price;
	}
	
	
	
	
}
