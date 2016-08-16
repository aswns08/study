package kr.co.cooks.vo;

public class RestaurantFileListVO {
	
	private String r_Num;
	private String r_Name;
	private String id;
	private String r_Address;
	private String r_Phone;
	private String r_Foodtype;
	private String r_Info;
	private int file_Num;
	private String originFileName;
	private String saveFileName;
	private long fileSize;
	
	public String getR_Num() {
		return r_Num;
	}
	public void setR_Num(String r_Num) {
		this.r_Num = r_Num;
	}
	public String getR_Name() {
		return r_Name;
	}
	public void setR_Name(String r_Name) {
		this.r_Name = r_Name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getR_Address() {
		return r_Address;
	}
	public void setR_Address(String r_Address) {
		this.r_Address = r_Address;
	}
	public String getR_Phone() {
		return r_Phone;
	}
	public void setR_Phone(String r_Phone) {
		this.r_Phone = r_Phone;
	}
	public String getR_Foodtype() {
		return r_Foodtype;
	}
	public void setR_Foodtype(String r_Foodtype) {
		this.r_Foodtype = r_Foodtype;
	}
	public String getR_Info() {
		return r_Info;
	}
	public void setR_Info(String r_Info) {
		this.r_Info = r_Info;
	}
	public int getFile_Num() {
		return file_Num;
	}
	public void setFile_Num(int file_Num) {
		this.file_Num = file_Num;
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
	
	@Override
	public String toString() {
		return "RestaurantFileListVO [r_Num=" + r_Num + ", r_Name=" + r_Name
				+ ", id=" + id + ", r_Address=" + r_Address + ", r_Phone="
				+ r_Phone + ", r_Foodtype=" + r_Foodtype + ", r_Info=" + r_Info
				+ ", file_Num=" + file_Num + ", originFileName="
				+ originFileName + ", saveFileName=" + saveFileName
				+ ", fileSize=" + fileSize + "]";
	}
}
