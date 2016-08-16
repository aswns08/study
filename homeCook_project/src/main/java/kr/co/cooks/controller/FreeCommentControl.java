package kr.co.cooks.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FreeCommentService;
import kr.co.cooks.vo.FreeCommentVO;
import kr.co.cooks.vo.RecipeCommentVO;
import kr.co.cooks.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreeCommentControl {
	@Autowired FreeCommentService commentService ;
	
	ModelAndView mav = new ModelAndView();

	//코멘트 쓰기
	@RequestMapping(value="/freeCommentWrite.app")
	public ModelAndView freeCommentWrite(@ModelAttribute FreeCommentVO commentVO, HttpSession session) {
		
		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");		
		commentVO.setId(sessionVO.getId());
		
		commentService.commentWrite(commentVO) ;
		
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
	}

	//코멘트 읽기
	@RequestMapping("/freeCommentRead.app")
	public ModelAndView freeCommentRead(int free_num, int endRow, HttpServletResponse res) {

		mav.addObject("freeCommentUserVO", commentService.commentRead(free_num, endRow));
		mav.setViewName("JSON");

		return mav;		
	}

	//코멘트 삭제
	@RequestMapping("/freeCommentDelete.app")
	public ModelAndView freeCommentDelete(@RequestParam int free_num, int fcomment_num, HttpSession session) {

		commentService.commentDelete(fcomment_num);	
		
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
	}
}
