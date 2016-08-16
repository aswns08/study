package com.daejeon.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.service.BBSService;


@Controller
public class BBSController {

	private static final Logger logger = LoggerFactory.getLogger(BBSController.class);

	BBSService bs;
	
	public BBSController(BBSService bs) {
		this.bs = bs;
	}
	
	@RequestMapping(value = "/login.daejeon")
	public ModelAndView login(HttpServletRequest req) {
		return bs.login(req);
	}

	@RequestMapping(value = "/list.daejeon")
	public ModelAndView list(HttpServletRequest req) {
		return bs.list(req);
	} 
	
	@RequestMapping(value = "/content.daejeon")
	public ModelAndView content(HttpServletRequest req) {
		return bs.content(req);
	}
	
	@RequestMapping(value = "/writeForm.daejeon")
	public ModelAndView writeForm(HttpServletRequest req) {
		return bs.writeForm(req);
	}
	
	@RequestMapping(value = "/write.daejeon")
	public ModelAndView write(HttpServletRequest req) {
		return bs.write(req);
	}
	
	@RequestMapping(value ="/delete.daejeon")
	public ModelAndView delete(HttpServletRequest req) {
		return bs.delete(req);
	}
	
	@RequestMapping(value ="/updateForm.daejeon")
	public ModelAndView updateForm(HttpServletRequest req) {
		return bs.updateForm(req);
	}
	
	@RequestMapping(value ="/update.daejeon")
	public ModelAndView update(HttpServletRequest req) {
		return bs.update(req);
	}
	
	@RequestMapping(value ="/replyForm.daejeon")
	public ModelAndView replyForm(HttpServletRequest req) {
		return bs.replyForm(req);
	}
	
	@RequestMapping(value ="/reply.daejeon")
	public ModelAndView reply(HttpServletRequest req) {
		return bs.reply(req);
	}
	
	
	

}
