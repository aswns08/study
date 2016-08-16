package kr.co.cooks.vo;

public class StorageMapVO {
	private String f_name;			//음식 이름
	private String r_num;			//음식 이름
	private int s_num;				//보관번호
	private int f_num;				//음식 번호
	private int s_count;			//음식 수량
	private int s_mileage;			//마일리지
	private int s_price;			//음식 가격
	private String saveFileName;	//저장된 파일 이름
	
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
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
	public int getS_mileage() {
		return s_mileage;
	}
	public void setS_mileage(int s_mileage) {
		this.s_mileage = s_mileage;
	}
	public int getS_price() {
		return s_price;
	}
	public void setS_price(int s_price) {
		this.s_price = s_price;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	
	@Override
	public String toString() {
		return "StorageMapVO [f_name=" + f_name + ", r_num=" + r_num
				+ ", s_num=" + s_num + ", f_num=" + f_num + ", s_count="
				+ s_count + ", s_mileage=" + s_mileage + ", s_price=" + s_price
				+ ", saveFileName=" + saveFileName + "]";
	}	
}
