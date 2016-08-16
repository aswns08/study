package kr.co.cooks.controller;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.UserService;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginControl {

	private static final Logger logger = LoggerFactory.getLogger(LoginControl.class);
	
	@Autowired UserService userService;
	UserVO userVO;
	
/*	페이지 이동만 필요할 경우 */
	
	
	@RequestMapping(value = "/login.app", method=RequestMethod.POST)
	public ModelAndView login(String email, String password, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		
		userVO = userService.validation_Check(email, password);
		
		if(userVO != null) {
			session.setAttribute("loginUser", userVO);
			mav.addObject("status", "success");
			
		} else {
			session.invalidate();
			mav.addObject("status", "fail");
		}
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value = "/loginUser.app")
	public ModelAndView loginUser(HttpSession session) {
		
		
		System.out.println("session 정보 : " +session.getAttribute("loginUser"));
		
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("loginUser") != null) {
			mav.addObject("status", "success");
			mav.addObject("loginUser", session.getAttribute("loginUser"));
			
		} else {
			mav.addObject("status", "fail");
		}
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value = "/logoutUser.app")
	public ModelAndView logoutUser(HttpSession session) {
		
		session.invalidate(); // session 끊어주는 메서드.
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
		
	}

	
}
	
