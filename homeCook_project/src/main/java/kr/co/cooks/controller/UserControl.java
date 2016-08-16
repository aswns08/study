package kr.co.cooks.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.UserService;
import kr.co.cooks.vo.UserOrderVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControl {

	private static final Logger logger = LoggerFactory.getLogger(UserControl.class);
	
	@Autowired UserService userService;
	UserVO userVO;
	
	@RequestMapping(value = "/emailCheck", method=RequestMethod.POST)
	public ModelAndView signUpEmailCheck(@RequestParam String signUp_email) {
		
		ModelAndView mav = new ModelAndView();
		
		String email = userService.signUpEmailCheck(signUp_email);
		if(email == null) {
			mav.addObject("status", "success");
			mav.setViewName("JSON");
			
		} else {
			mav.addObject("status", "fail");
			mav.setViewName("JSON");
		}
		
		 return mav;
	}
	
	@RequestMapping(value = "/signUp", method=RequestMethod.POST)
	public ModelAndView signUpUser(@ModelAttribute UserVO userVO) {
		
		userService.signUpUser(userVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		return mav;
	}
	
	// 회원정보수정 페이지 요청
	@RequestMapping(value = "/userInfo.app")
	public String userInfo(HttpSession session) {
		
		//System.out.println("session 값 : " +session.getAttribute("loginUser"));
		
		return "user/mypage_UserInfo";
	}
	
	// 개인정보수정.
	@RequestMapping(value = "/userUpdate.app")
	public ModelAndView userUpdate(@ModelAttribute UserVO userVO,
									@RequestParam String pwd, HttpSession session) {
		
		String status = userService.userUpdate(userVO, pwd);
		
		ModelAndView mav = new ModelAndView();
		
		if(status == "success") {
			session.setAttribute("loginUser", userVO);
			mav.addObject("status", "success");
		} else {
			mav.addObject("status", "fail");
		}
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	// 회원(이메일) 유/무 확인
	@RequestMapping(value = "/findEmailCheck", method=RequestMethod.POST)
	public ModelAndView findEmailCheck(@RequestParam String input_email) {
		
		ModelAndView mav = new ModelAndView();
		
		String email = userService.signUpEmailCheck(input_email);
		
		if(email == null) {
			mav.addObject("status", "empty");
			
		} else {
			mav.addObject("status", "overlap");
			
		}
		mav.setViewName("JSON");
		return mav;
	}
	
	// 이메일로 인증번호 요청
	@RequestMapping(value = "/emailAuth.app", method=RequestMethod.POST)
	public ModelAndView findEmail(@RequestParam String input_email) throws Exception {

		int random = (int) ((Math.random()+1) * 10000); //인증번호 랜덤발생
		System.out.println("" + random);


		// 메일 관련 정보
		String host = "smtp.naver.com";
		final String username = "cielo0208@naver.com"; //사용할 이메일주소
		final String password = "homecook0714"; //비번
		int port=465;

		// 메일 내용
		String recipient = input_email; //받는사람
		String subject = "인증번호 메일발송";
		String body = "인증번호는 " + random + " 입니다. 번호를 입력하세요.";

		Properties props = System.getProperties();


		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true); //for debug

		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("cielo0208@naver.com")); //발신자 정보
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(body);

		Transport.send(mimeMessage);

		ModelAndView mav = new ModelAndView();

		mav.addObject("status", "success");
		mav.addObject("vcode", random);
		mav.addObject("email", input_email);
		mav.setViewName("JSON");
		return mav;
	}
	
	// 비밀번호 변경 요청
	@RequestMapping(value="/changePwd", method=RequestMethod.POST)
	public ModelAndView changePwd(@RequestParam String email, String new_pwd) throws Exception {
		
		userService.changePwd(email, new_pwd);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("status", "success");
		mav.setViewName("JSON");

		return mav;
	}
	
	// 구매내역 페이지 요청
	@RequestMapping(value = "/userOrderList.app")
	public ModelAndView userOrderList(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		userVO = (UserVO)session.getAttribute("loginUser");
		
		if(userVO.getUser_Level()==2){
			List<UserOrderVO> orderList = userService.orderAllList();
			System.out.println("주문내역 :" +orderList);
			
			mav.addObject("orderList", orderList);
			mav.setViewName("user/mypage_OrderList");
			
		} else {
			List<UserOrderVO> orderList = userService.orderList(userVO.getId());
			System.out.println("주문내역 :" +orderList);
			
			mav.addObject("orderList", orderList);
			mav.setViewName("user/mypage_OrderList");
		}
		
		return mav;
	}

	
}