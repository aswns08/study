package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.NoticeService;
import kr.co.cooks.vo.NoticeVO;
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
public class NoticeControl {

	private static final Logger logger = LoggerFactory.getLogger(NoticeControl.class);
	
	@Autowired NoticeService noticeService;
	NoticeVO noticeVO;
	UserVO userVO;
	
	static final int PAGE_DEFAULT_SIZE = 5;
	
	@RequestMapping(value="/NoticeList.app")
	public ModelAndView noticeList(@RequestParam(defaultValue ="1") int pageNum,
									@RequestParam(defaultValue = "5") int pageSize,
									HttpSession session) {
		
		if(pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;
		
		// 끝페이지 계산하는 메서드.
		int endPageNum = noticeService.getEndPageNum(pageSize);
		
		if(pageNum <= 0 ) pageNum = 1; // 페이지번호가 0보다 작거나 같을 수 없으니까 1페이지로 셋팅.
		if(pageNum > endPageNum) pageNum = endPageNum; // 페이지번호가 끝페이지 보다 클 경우에는 끝페이지번호가 페이지번호.
		
		List<?> noticeList = noticeService.noticeList(pageNum, pageSize);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("status", "success");
		mav.addObject("currentPageNum", pageNum);
		mav.addObject("endPageNum", endPageNum);
		mav.addObject("noticeList", noticeList);
		mav.setViewName("board_notice/notice");
		
		return mav;	
	}
	
	@RequestMapping(value="/NoticeWriteForm.app")
	public ModelAndView NoticeWriteForm(int pageNum){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_notice/notice_writeForm");
		
		return mav;
	}
	
	@RequestMapping(value="/NoticeWrite.app")
	public ModelAndView NoticeWrite(@ModelAttribute NoticeVO noticeVO,
									@RequestParam int pageNum,
									HttpSession session){
	
		UserVO userVO = ((UserVO)session.getAttribute("loginUser"));
		noticeVO.setId(userVO.getId());
		System.out.println(noticeVO);
		
		noticeService.noticeWrite(noticeVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value="/NoticeContent.app")
	public ModelAndView NoticeContent(NoticeVO noticeVO, HttpServletRequest req, HttpServletResponse res, HttpSession session){    
		
		//userVO = (UserVO)session.getAttribute("loginUser");
		
		ModelAndView mav = new ModelAndView();
		
		int no_Num=Integer.parseInt(req.getParameter("no_Num"));
		
		noticeVO = noticeService.noticeContent(no_Num, noticeVO);
		
		mav.addObject("noticeVO", noticeVO);
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.setViewName("board_notice/notice_content");
		return mav;
	}
	
	@RequestMapping(value="/noticeHit.app")
	public ModelAndView NoticeHit(int no_Num){
		ModelAndView mav = new ModelAndView();
		noticeService.noticeHit(no_Num);
		mav.setViewName("JSON");
		return mav;
	}
	
	@RequestMapping(value="/NoticeupdateForm.app")
	public ModelAndView NoticeupdateForm(@RequestParam int no_Num, @RequestParam int pageNum){
		ModelAndView mav = new ModelAndView();
		noticeVO=noticeService.getNoticeUpdate(no_Num);
		mav.addObject("pageNum", pageNum);
		mav.addObject("noticeVO", noticeVO);
		mav.setViewName("board_notice/notice_updateForm");
		return mav;
	}
	
	@RequestMapping(value="/NoticeUpdate.app")
	public ModelAndView NoticeUpdate(@ModelAttribute NoticeVO noticeVO, @RequestParam int pageNum){
		ModelAndView mav = new ModelAndView();
		
		noticeService.noticeUpdate(noticeVO);
		
		System.out.println(noticeVO);
		
		mav.addObject("no_Num", noticeVO.getNo_Num());
		mav.addObject("pageNum", pageNum);
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value="/NoticeDelete.app")
	public ModelAndView NoticeDelete(@RequestParam int no_Num, @RequestParam int pageNum){
		ModelAndView mav = new ModelAndView();
		noticeService.noticeDelete(no_Num);
		mav.addObject("pageNum", pageNum);
		mav.setViewName("redirect:/NoticeList.app?pageNum="+pageNum);
		return mav;
	}
}
