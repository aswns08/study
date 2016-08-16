package com.daejeon.mybatis.bbs.service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.daejeon.mybatis.bbs.vo.BoardVO;

public interface BBSService {

	public int login(String id, String pwd);
	public HashMap<String, Object> list(String pageNum);
	public BoardVO content(int article_Num);
	public void write(BoardVO article, MultipartFile springfname);
	public void delete(int article_Num);
	public BoardVO getUpdateForm(int article_Num);
	public void update(BoardVO article, MultipartFile springfname);
	public void reply(BoardVO article);
	public int getCommentCount(int article_Num);
	
	
}
