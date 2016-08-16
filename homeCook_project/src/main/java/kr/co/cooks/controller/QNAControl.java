package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.QNAService;
import kr.co.cooks.service.RestaurantService;
import kr.co.cooks.vo.QNAVO;
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
public class QNAControl {
	private static final Logger logger = LoggerFactory.getLogger(QNAControl.class);
	
	@Autowired QNAService qnaService;
	@Autowired RestaurantService restaurantService;
	QNAVO qnaVO;
	
	@RequestMapping(value = "/MyQNAlist.app")
	public ModelAndView list(HttpSession session) {
		
		ModelAndView mav= new ModelAndView();	
		
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		if(userVO.getUser_Level()==2){
			List<QNAVO> qnaList = qnaService.myqnaAllList();
			
			mav.addObject("qnaList", qnaList);
			mav.setViewName("user/mypage_QnAlist");
			
		} else if(userVO.getUser_Level()==1){
			
			List<QNAVO> qnaList = qnaService.myqnaOwnerlist(userVO.getId());
			
			mav.addObject("qnaList", qnaList);
			mav.setViewName("user/mypage_QnAlist");
			
		} else {
			List<QNAVO> qnaList = qnaService.myqnalist(userVO.getId());
			int totalCount = qnaService.getMyQNACount(userVO.getId());
			
			mav.addObject("qnaList", qnaList);
			mav.addObject("count", totalCount);
			mav.setViewName("user/mypage_QnAlist");
		}
		return mav;
	}
	
	@RequestMapping(value="/QNAWriteForm.app")
	public ModelAndView QNAWriteForm(@RequestParam String r_num, @RequestParam int f_num){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.setViewName("QNA/qna_writeForm");
		return mav;
	}
	
	@RequestMapping(value="/QNAWrite.app")
	public ModelAndView QNAWrite(@RequestParam String r_num, @RequestParam int f_num,
								 @ModelAttribute QNAVO qnaVO, 
								 HttpSession session){
		
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		qnaVO.setId(userVO.getId());
		qnaVO.setF_Num(f_num);
		qnaService.qnaWrite(qnaVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value="/QNAContent.app")
	public ModelAndView QNAContent(int q_Num, String r_num, int f_num){
		
		ModelAndView mav = new ModelAndView();
	 
		String resOwner = restaurantService.getResOwner(r_num);
		
		qnaVO = qnaService.qnaContent(q_Num);
		
		mav.addObject("resOwner", resOwner);
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.addObject("qnaVO", qnaVO);
		mav.setViewName("QNA/qna_content");
		return mav;
	}
	
	@RequestMapping(value="/MyQNAContent.app")
	public ModelAndView MyQNAContent(@RequestParam int q_Num, @RequestParam int f_num){
		
		ModelAndView mav = new ModelAndView();
	 
		qnaVO = qnaService.qnaContent(q_Num);
		
		mav.addObject("f_num", f_num);
		mav.addObject("qnaVO", qnaVO);
		mav.setViewName("user/mypage_QnAcontent");
		return mav;
	}
	
	@RequestMapping(value="/QNAupdateForm.app")
	public ModelAndView QNAupdateForm(@RequestParam int q_Num, String r_num, int f_num){
		
		ModelAndView mav = new ModelAndView();
		
		qnaVO=qnaService.getQNAUpdate(q_Num);
		
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.addObject("qnaVO", qnaVO);
		mav.setViewName("QNA/qna_updateForm");
		
		return mav;
	}
	
	@RequestMapping(value="/QNAUpdate.app")
	public ModelAndView QNAUpdate(@ModelAttribute QNAVO qnaVO, String r_num, int f_num){
	
		ModelAndView mav = new ModelAndView();
		
		qnaService.qnaUpdate(qnaVO);
		mav.addObject("q_Num", qnaVO.getQ_Num());
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.addObject("status", "success");
		mav.setViewName("JSON");				
		
		return mav;
	}
	
	//My페이지에서 Q&A수정Form
	@RequestMapping(value="/MyQNAupdateForm.app")
	public ModelAndView MyQNAupdateForm(@RequestParam int q_Num, int f_num){
		
		ModelAndView mav = new ModelAndView();
		
		qnaVO=qnaService.getQNAUpdate(q_Num);
		
		mav.addObject("f_num", f_num);
		mav.addObject("qnaVO", qnaVO);
		mav.setViewName("user/mypage_QnAupdateForm");
		
		return mav;
	}
	
	//My페이지에서 Q&A수정
	@RequestMapping(value="/MyQNAUpdate.app")
	public ModelAndView MyQNAUpdate(@ModelAttribute QNAVO qnaVO, int f_num){
	
		ModelAndView mav = new ModelAndView();
		
		qnaService.qnaUpdate(qnaVO);
		mav.addObject("q_Num", qnaVO.getQ_Num());
		mav.addObject("f_num", f_num);
		mav.addObject("status", "success");
		mav.setViewName("JSON");				
		
		return mav;
	}
	
	@RequestMapping(value="/QNADelete.app")
	public ModelAndView QNADelete(@RequestParam int q_Num, String r_num, int f_num){
		ModelAndView mav = new ModelAndView();
		qnaService.qnaDelete(q_Num);
		mav.setViewName("redirect:/getFoodDetail.app?r_num="+r_num+"&f_num="+f_num);
		return mav;
	}
	
	@RequestMapping(value="/MyQNADelete.app")
	public ModelAndView MyQNADelete(@RequestParam int q_Num){
		ModelAndView mav = new ModelAndView();
		qnaService.qnaDelete(q_Num);
		mav.setViewName("redirect:/MyQNAlist.app");
		return mav;
	}
	
	@RequestMapping(value="/QNAreplyForm.app")
	public ModelAndView replyForm(@RequestParam int q_Num, String r_num, int f_num){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.addObject("q_Num", q_Num);
		mav.setViewName("QNA/qna_replyForm");
		return mav;
	}
	
	@RequestMapping(value="/QuestionReply.app")
	public ModelAndView QNAreply(@RequestParam String r_num, int f_num,
								 @ModelAttribute QNAVO qnaVO,
								 HttpSession session) {
		
		System.out.println("요청 : "+qnaVO);
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		qnaVO.setId(userVO.getId());
		qnaVO.setQ_Position(qnaVO.getQ_Num());
		qnaVO.setQ_Dept(1);
		qnaVO.setF_Num(f_num);
		
		System.out.println("set 한 후에 요청 : "+qnaVO);
		
		ModelAndView mav = new ModelAndView();
		
		qnaService.qnaReply(qnaVO);
		
		mav.addObject("r_num", r_num);
		mav.addObject("f_num", f_num);
		mav.addObject("q_Num", qnaVO.getQ_Num());
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		return mav;
	}
	
	//My페이지에서 Q&A댓글Form
	@RequestMapping(value="/MyQNAreplyForm.app")
	public ModelAndView MyreplyForm(@RequestParam int q_Num, @RequestParam int f_num){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("f_num", f_num);
		mav.addObject("q_Num", q_Num);
		mav.setViewName("user/mypage_QnAreplyForm");
		return mav;
	}
	
	//My페이지에서 Q&A댓글
	@RequestMapping(value="/MyQuestionReply.app")
	public ModelAndView MyQNAreply(@RequestParam int f_num,
								 @ModelAttribute QNAVO qnaVO,
								 HttpSession session) {
		
		System.out.println("요청 : "+qnaVO);
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		qnaVO.setId(userVO.getId());
		qnaVO.setQ_Position(qnaVO.getQ_Num());
		qnaVO.setQ_Dept(1);
		qnaVO.setF_Num(f_num);
		
		System.out.println("set 한 후에 요청 : "+qnaVO);
		
		ModelAndView mav = new ModelAndView();
		
		qnaService.qnaReply(qnaVO);
		
		mav.addObject("f_num", f_num);
		mav.addObject("q_Num", qnaVO.getQ_Num());
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		return mav;
	}
	
	
}
