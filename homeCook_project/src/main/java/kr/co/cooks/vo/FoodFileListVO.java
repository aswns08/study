package kr.co.cooks.vo;

public class FoodFileListVO {
	private int file_num ;
	private String originFileName ;
	private String saveFileName;
	private long fileSize;
	private int f_num;
	
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
	
	@Override
	public String toString() {
		return "FoodFileListVO [file_num=" + file_num + ", originFileName="
				+ originFileName + ", saveFileName=" + saveFileName
				+ ", fileSize=" + fileSize + ", f_num=" + f_num + "]";
	}
}
	
	
	