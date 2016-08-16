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

import com.daejeon.mybatis.comment.service.CommentService;
import com.daejeon.mybatis.comment.vo.CommentVO;

@Controller
public class CommetController01 {

	@Autowired CommentService cs;
/*
	@RequestMapping("commentWrite.comment")
	@ResponseBody
	public List<CommentVO> commentWrite(@ModelAttribute CommentVO comment, 
			HttpSession session, HttpServletResponse res) {

		comment.setId((String)session.getAttribute("id"));
		return cs.commentWrite(comment);
	
		 @ResponseBody를 붙이면 리턴할 때 json형식으로 리턴해줌.
		 * 순서는 @RequestMapping 다음에 @ResponseBody 순으로 선언을 해줘야 함.
		 * 또는 리턴 타입 앞에 붙일 수 있다.
		 * 단 애노테이션을 쓸 때는 반드시 context파일에 annotation driven을 설정해줘아함.
	}

	@RequestMapping("commentRead.comment")
	public @ResponseBody List<CommentVO> commentRead(@RequestParam int article_Num, int endRow, HttpServletResponse res) {

		return cs.commentRead(article_Num, endRow);
		
	}
*/

}
