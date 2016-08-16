package kr.co.cooks.vo;


public class FoodVO {
	private int f_num;				//음식 번호
	private String f_name ;			//음식 이름
	private int f_price;			//가격
	private String f_ex_date;		//유통기한
	private String f_recipe;		//레시피
	private String f_ingredients;	//원재료명
	private String f_origin;		//원산지명
	private String f_store;			//보관방법
	private int f_count;			//매출량
	private String r_num;			//사업자 등록번호
	
	
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public String getF_recipe() {
		return f_recipe;
	}
	public void setF_recipe(String f_recipe) {
		this.f_recipe = f_recipe;
	}
	public String getF_ex_date() {
		return f_ex_date;
	}
	public void setF_ex_date(String f_ex_date) {
		this.f_ex_date = f_ex_date;
	}
	public String getF_ingredients() {
		return f_ingredients;
	}
	public void setF_ingredients(String f_ingredients) {
		this.f_ingredients = f_ingredients;
	}
	public String getF_origin() {
		return f_origin;
	}
	public void setF_origin(String f_origin) {
		this.f_origin = f_origin;
	}
	public String getF_store() {
		return f_store;
	}
	public void setF_store(String f_store) {
		this.f_store = f_store;
	}
	public int getF_count() {
		return f_count;
	}
	public void setF_count(int f_count) {
		this.f_count = f_count;
	}
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	
	
	@Override
	public String toString() {
		return "FoodVO [f_num=" + f_num + ", f_name=" + f_name + ", f_price="
				+ f_price + ", f_recipe=" + f_recipe + ", f_ex_date="
				+ f_ex_date + ", f_ingredients=" + f_ingredients
				+ ", f_origin=" + f_origin + ", f_store=" + f_store
				+ ", f_count=" + f_count + ", r_num=" + r_num + "]";
	}
}
