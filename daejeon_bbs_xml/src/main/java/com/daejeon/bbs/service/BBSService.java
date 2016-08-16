package com.daejeon.bbs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface BBSService {

	public ModelAndView login(HttpServletRequest req);
	public ModelAndView list(HttpServletRequest req);
	public ModelAndView content(HttpServletRequest req);
	public ModelAndView writeForm(HttpServletRequest req);
	public ModelAndView write(HttpServletRequest req);
	public ModelAndView delete(HttpServletRequest req);
	public ModelAndView updateForm(HttpServletRequest req);
	public ModelAndView update(HttpServletRequest req);
	public ModelAndView replyForm(HttpServletRequest req);
	public ModelAndView reply(HttpServletRequest req);
	
	
	
}
