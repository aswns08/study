package kr.co.cooks.vo;

public class ReviewFileVO {

	private int file_Num;
	private String originFileName;
	private String saveFileName;
	private long fileSize;
	private int re_Num;
	
	@Override
	public String toString() {
		return "FileListVO [file_Num=" + file_Num + ", originFileName="
				+ originFileName + ", saveFileName=" + saveFileName
				+ ", fileSize=" + fileSize + ", re_Num=" + re_Num + "]";
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
	public int getRe_Num() {
		return re_Num;
	}
	public void setRe_Num(int re_Num) {
		this.re_Num = re_Num;
	}
	
	
	
}
