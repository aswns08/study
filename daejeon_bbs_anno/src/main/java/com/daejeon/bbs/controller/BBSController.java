package com.daejeon.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.service.BBSService;
import com.daejeon.bbs.vo.BoardVO;


@Controller
public class BBSController {

	private static final Logger logger = LoggerFactory.getLogger(BBSController.class);
	@Autowired
	BBSService bs;
	
	@RequestMapping(value = "/login.daejeon")
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		int status = bs.login(id, pwd);
		
		if(status==1) {
			// session은 jsp의 내장객체로 getSession을 통해 값을 넣어주면
			// req.validate()메서드를 통해 Session을 끊어주거나
			// req.removeAttribute() 메서드를 통해 Session안에 값을 제거 해준다. 
			session.setAttribute("id", id);
			
			if(session.getAttribute("writeForm")==null) {
				mav.setViewName("redirect:/list.daejeon?pageNum="+1);
				// 리스트 화면에서 바로 로그인 하는 경우
			} else {
				mav.setViewName("writeForm");
				// 글쓰기 화면에서 로그인 하는 경우 로그인 후 다시 글쓰기 화면으로 이동.
			}
		} else if(status==2) {
			System.out.println("패스워드가 틀렸습니다.");
			return null;
			
		} else {
			System.out.println("회원이 아닙니다.");
			return null;
		}
		
		return mav;
	}

	@RequestMapping(value = "/list.daejeon")
	public ModelAndView list(@RequestParam("pageNum") String pageNum) {
		return bs.list(pageNum);
	} 
	
	@RequestMapping(value = "/content.daejeon")
	public ModelAndView content(@RequestParam int article_Num, String pageNum) {
		return bs.content(article_Num, pageNum);
	}
	
	@RequestMapping(value = "/writeForm.daejeon")
	public ModelAndView writeForm(HttpServletRequest req) {
		return bs.writeForm(req);
	}
	
	@RequestMapping(value = "/write.daejeon")
	public String write(@ModelAttribute BoardVO article, HttpSession session) {
		// @ModelAttribute jsp에 있는 값들을 읽어와서 BoardVO article 에 자동으로 set해줌. 
		article.setId((String)session.getAttribute("id"));
		bs.write(article);
		// redirect 를 붙이지 않으면 (String) view를 찾기 때문에 redirect를 붙여준다.
		return "redirect:/list.daejeon?pageNum="+1;
	}
	
	@RequestMapping(value ="/delete.daejeon")
	public ModelAndView delete(@RequestParam int article_Num, String pageNum) {
		return bs.delete(article_Num, pageNum);
	}
	
	@RequestMapping(value ="/updateForm.daejeon")
	public ModelAndView updateForm(HttpServletRequest req) {
		return bs.updateForm(req);
	}
	
	@RequestMapping(value ="/update.daejeon")
	public ModelAndView update(@ModelAttribute BoardVO article) {
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
