package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FreeBoardService;
import kr.co.cooks.vo.FreeBoardUserVO;
import kr.co.cooks.vo.FreeBoardVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreeBoardControl {

	private static final Logger logger = LoggerFactory.getLogger(FreeBoardControl.class);

	@Autowired FreeBoardService freeService ;
	FreeBoardUserVO freeUserVO;
	static final int PAGE_DEFAULT_SIZE = 5;

	//글 목록(리스트)
	@RequestMapping(value="/freeList.app")
	public ModelAndView freeList(@RequestParam(defaultValue ="1") int pageNum,
								@RequestParam(defaultValue = "5") int pageSize,
								HttpSession session) {

		if(pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;
		
		// 끝페이지 계산하는 메서드.
		int endPageNum = freeService.getEndPageNum(pageSize);
		
		if(pageNum <= 0 ) pageNum = 1; // 페이지번호가 0보다 작거나 같을 수 없으니까 1페이지로 셋팅.
		if(pageNum > endPageNum) pageNum = endPageNum; // 페이지번호가 끝페이지 보다 클 경우에는 끝페이지번호가 페이지번호.
		
		List<?> freeList = freeService.freeBoardList(pageNum, pageSize);

		ModelAndView mav = new ModelAndView();
		mav.addObject("currentPageNum", pageNum);
		mav.addObject("endPageNum", endPageNum);
		mav.addObject("freeList", freeList);
		mav.setViewName("board_free/freeList");

		return mav;
	}

	//글 쓰기 폼
	@RequestMapping(value="/freeWriteForm.app")
	public ModelAndView freeWriteForm(String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_free/freeWriteForm");

		return mav;		
	}

	//글 쓰기
	@RequestMapping(value="/freeWrite.app")
	public String freeWrite(@ModelAttribute FreeBoardVO freeVO, HttpSession session) {

		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");		
		freeVO.setId(sessionVO.getId());

		freeService.write(freeVO);		

		return "redirect:/freeList.app?pageNum="+1;		
	}

	//글 읽기
	@RequestMapping(value="/freeContent.app")
	public ModelAndView freeContent(@RequestParam int free_num, @RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int freeCommentCount=0 ;

		freeUserVO=freeService.content(free_num);
		freeCommentCount=freeService.getCommentCount(free_num);	//댓글 개수

		mav.addObject("freeUserVO", freeUserVO);
		mav.addObject("freeCommentCount",freeCommentCount);	
		mav.addObject("pageNum", pageNum);		

		mav.setViewName("board_free/freeContent");		

		return mav ;
	}

	//글 수정 폼
	@RequestMapping(value="/freeUpdateForm.app")
	public ModelAndView freeUpdateForm(@RequestParam int free_num, @RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		freeUserVO=freeService.getUpdateFree(free_num);

		mav.addObject("freeUserVO", freeUserVO);
		mav.addObject("pageNum", pageNum);

		mav.setViewName("board_free/freeUpdateForm");		

		return mav ;		
	}

	//글 수정
	@RequestMapping(value="/freeUpdate.app")
	public String freeUpdate(@ModelAttribute  FreeBoardVO freeVO, @RequestParam String pageNum) {

		freeService.update(freeVO);

		return "redirect:/freeContent.app?free_num="+freeVO.getFree_num() +"&pageNum=" + pageNum ;	
	}

	//글 삭제
	@RequestMapping(value="/freeDelete.app")
	public String freeDelete(@RequestParam int free_num) {

		freeService.delete(free_num);

		return "redirect:/freeList.app?pageNum=" + 1 ;	
	}

	//조회수 추가
	@RequestMapping(value="/freeHit.app")
	public ModelAndView freeHit(int free_num) {
		ModelAndView mav = new ModelAndView();

		freeService.freeHit(free_num);
		mav.setViewName("JSON");

		return mav ;						
	}

}
