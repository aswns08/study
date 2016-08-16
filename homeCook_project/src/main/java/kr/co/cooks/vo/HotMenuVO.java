package kr.co.cooks.vo;

public class HotMenuVO {
	private int file_num ;
	private String originFileName ;
	private String saveFileName;
	private long fileSize;
	private int f_num;				//음식 번호
	private String f_name ;			//음식 이름
	private int f_price;			//가격
	private int f_count;			//매출량
	private String r_num;			//사업자 등록번호
	private String r_Name;
	
	
	public int getFile_num() {
		return file_num;
	}
	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
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
	public String getR_Name() {
		return r_Name;
	}
	public void setR_Name(String r_Name) {
		this.r_Name = r_Name;
	}
	
	@Override
	public String toString() {
		return "HotMenuVO [file_num=" + file_num + ", originFileName="
				+ originFileName + ", saveFileName=" + saveFileName
				+ ", fileSize=" + fileSize + ", f_num=" + f_num + ", f_name="
				+ f_name + ", f_price=" + f_price + ", f_count=" + f_count
				+ ", r_num=" + r_num + ", r_Name=" + r_Name + "]";
	}

}
