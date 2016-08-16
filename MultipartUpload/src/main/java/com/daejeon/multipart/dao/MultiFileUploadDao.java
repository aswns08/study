package com.daejeon.multipart.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.daejeon.multipart.vo.BoardVO;
import com.daejeon.multipart.vo.FileVO;

public interface MultiFileUploadDao {

	public void write(String content);
	public void insertFileUpload(FileVO fileVO);
	public List<BoardVO> read();
	public List<FileVO> content(int article_Num);
}
