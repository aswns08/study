package com.daejeon.bbs.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.vo.BoardVO;

public interface BBSService {

	public int login(String id, String pwd);
	public HashMap<String, Object> list(String pageNum);
	public BoardVO getArticle(int article_Num);
	public void write(BoardVO article, MultipartFile springfname);
//	public void delete(int article_Num);
//	public BoardVO getUpdateForm(int article_Num);
//	public void update(BoardVO article, int article_Num);
//	public void reply(BoardVO article);
//	public int getCommentCount(int article_Num);
	
	
}
