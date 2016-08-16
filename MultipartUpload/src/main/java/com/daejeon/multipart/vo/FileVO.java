package com.daejeon.multipart.vo;

public class FileVO {
	private String originFileName;
	private String saveFileName;
	private long fileSize;
	private int article_Num;
	
	
	@Override
	public String toString() {
		return "FileVO [originFileName=" + originFileName + ", saveFileName="
				+ saveFileName + ", fileSize=" + fileSize + ", article_Num="
				+ article_Num + "]";
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


	public int getArticle_Num() {
		return article_Num;
	}


	public void setArticle_Num(int article_Num) {
		this.article_Num = article_Num;
	}
	
	
	

}
