package kr.co.cooks.vo;

public class StorageVO {
	private String id;				//아이디
	private int f_num;				//음식 번호
	private int s_count;			//음식 수량
	private int s_price;			//음식 가격
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public int getS_count() {
		return s_count;
	}
	public void setS_count(int s_count) {
		this.s_count = s_count;
	}
	public int getS_price() {
		return s_price;
	}
	public void setS_price(int s_price) {
		this.s_price = s_price;
	}
	
	
	@Override
	public String toString() {
		return "StorageVO [id=" + id + ", f_num=" + f_num + ", s_count="
				+ s_count + ", s_price=" + s_price + "]";
	}
}
