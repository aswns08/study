package kr.co.cooks.vo;

public class RestaurantFileVO {
	
	private int file_Num;
	private String originFileName;
	private String saveFileName;
	private long fileSize;
	private String r_Num;
	
	
	@Override
	public String toString() {
		return "AddRestaurantFileVO [file_Num=" + file_Num
				+ ", originFileName=" + originFileName + ", saveFileName="
				+ saveFileName + ", fileSize=" + fileSize + ", r_Num=" + r_Num
				+ "]";
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


	public String getR_Num() {
		return r_Num;
	}


	public void setR_Num(String r_Num) {
		this.r_Num = r_Num;
	}
	
	
	
}
