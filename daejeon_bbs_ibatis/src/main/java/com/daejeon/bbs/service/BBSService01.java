package com.daejeon.bbs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.vo.BoardVO;

public interface BBSService01 {

	public int login(String id, String pwd);
	public ModelAndView list(String pageNum);
	public BoardVO getArticle(int article_Num);
	public ModelAndView writeForm(HttpServletRequest req);
	public void write(BoardVO article);
	public ModelAndView delete(int article_Num, String pageNum);
	public ModelAndView updateForm(HttpServletRequest req);
	public ModelAndView update(HttpServletRequest req);
	public ModelAndView replyForm(HttpServletRequest req);
	public ModelAndView reply(HttpServletRequest req);
	
	
	
}
