package com.daejeon.bbs.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.service.BBSService;
import com.daejeon.bbs.vo.BoardVO;


@Controller
public class BBSController {

	private static final Logger logger = LoggerFactory.getLogger(BBSController.class);
	@Autowired BBSService bs;
	BoardVO article;
	
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
		
		HashMap<String, Object> hm = bs.list(pageNum);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("articleList", hm.get("articleList"));
		mav.addObject("pageNum", pageNum);
		mav.addObject("count", hm.get("count"));
		mav.addObject("pagecode", hm.get("pagecode"));
		mav.setViewName("list");
		return mav;
	} 
	
	@RequestMapping(value = "/content.daejeon")
	public ModelAndView content(@RequestParam int article_Num, String pageNum) {
		
		article = bs.getArticle(article_Num);
//		int commentCount = bs.getCommentCount(article_Num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.addObject("pageNum", pageNum);
//		mav.addObject("commentCount", commentCount);
		mav.setViewName("content");
		return mav;
	}
	
	@RequestMapping(value = "/writeForm.daejeon")
	public ModelAndView writeForm(HttpSession session) {
		
		// 로그인 페이지에서 setAttribute()로 키값을 id로 set해줌.
		// id가 있는 경우에는 로그인이 되어 있는 경우 이므로 바로 글쓰기 페이지로 이동
		ModelAndView mav = new ModelAndView();

		if(session.getAttribute("id") != null) {
			mav.setViewName("writeForm");

		} else {
			// id값이 없는 경우에는 로그인을 한 후에 글을 써야 하므로 로그인 페이지로 이동.
			session.setAttribute("writeForm", "ok");
			mav.setViewName("login");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/write.daejeon")
	public String write(@ModelAttribute BoardVO article, HttpSession session, MultipartFile springfname) {
		// @ModelAttribute jsp에 있는 값들을 읽어와서 BoardVO article 에 자동으로 set해줌. 
		article.setId((String)session.getAttribute("id"));
		bs.write(article, springfname);
		// redirect 를 붙이지 않으면 (String) view를 찾기 때문에 redirect를 붙여준다.
		return "redirect:/list.daejeon?pageNum="+1;
	}
	
/*	
	@RequestMapping(value ="/delete.daejeon")
	public String delete(@RequestParam int article_Num, String pageNum) {
		
		bs.delete(article_Num);
		
		return "redirect:/list.daejeon?pageNum="+pageNum;
	}
	
	@RequestMapping(value ="/updateForm.daejeon")
	public ModelAndView updateForm(@RequestParam int article_Num, String pageNum) {

		article = bs.getUpdateForm(article_Num);

		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.addObject("pageNum", pageNum);
		mav.addObject("article_Num", article_Num);
		mav.setViewName("updateForm");

		return mav;

	}
	
	@RequestMapping(value ="/update.daejeon")
	public String update(@ModelAttribute BoardVO article,
			@RequestParam int article_Num, String pageNum) {
		
		bs.update(article, article_Num);
		
		return "redirect:/content.daejeon?article_Num="+article_Num+"&pageNum="+pageNum;
	}
	
	
	@RequestMapping(value ="/replyForm.daejeon")
	public ModelAndView replyForm(@ModelAttribute BoardVO article, @RequestParam String pageNum) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNum", pageNum);
		mav.addObject("position", article.getPosition());
		mav.addObject("group_Id", article.getGroup_Id());
		mav.addObject("depth", article.getDepth());
		mav.setViewName("replyForm");
		return mav;
	}
	
	@RequestMapping(value ="/reply.daejeon")
	public String reply(@ModelAttribute BoardVO article, HttpSession session,
			@RequestParam String pageNum) {
		
		article.setId((String)session.getAttribute("id"));
		
		bs.reply(article);
		
		return "redirect:/list.daejeon?pageNum="+pageNum;
	}
	
	@RequestMapping(value = "/download.daejeon")
	public ModelAndView download(String fname) {
		String realFolder = "d:/upload/";
		ModelAndView mav = new ModelAndView("download", "filename", new File(realFolder+fname));
		// viewname , obbject key name , object 객체
		// new ModelAndView("download", "filename", new File(realFolder+fname));
		// mav.setViewName("download");
		return mav;
	}
*/
}
