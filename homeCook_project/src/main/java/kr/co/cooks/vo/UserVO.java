package kr.co.cooks.vo;

public class UserVO {

	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private int user_Level;
	private int mileage;
	
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", phone=" + phone + ", user_Level="
				+ user_Level + ", mileage=" + mileage + "]";
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUser_Level() {
		return user_Level;
	}
	public void setUser_Level(int user_Level) {
		this.user_Level = user_Level;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
	
	
}
