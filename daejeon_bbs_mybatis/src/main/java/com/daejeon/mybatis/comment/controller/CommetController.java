package com.daejeon.mybatis.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.mybatis.comment.service.CommentService;
import com.daejeon.mybatis.comment.vo.CommentVO;

@Controller
public class CommetController {

	@Autowired CommentService cs;

	@RequestMapping("commentWrite.comment")
	public ModelAndView commentWrite(@ModelAttribute CommentVO comment, 
			HttpSession session, HttpServletResponse res) {

		comment.setId((String)session.getAttribute("id"));

		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", cs.commentWrite(comment));
		mav.setViewName("JSON");

		return mav;

	}

	@RequestMapping("commentRead.comment")
	public ModelAndView commentRead(@RequestParam int article_Num, int endRow, HttpServletResponse res) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", cs.commentRead(article_Num, endRow));
		mav.setViewName("JSON");

		return mav;

		

	}

}
