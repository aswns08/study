package com.daejeon.bbs.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.dao.BBSDaoService;
import com.daejeon.bbs.vo.BoardVO;

@Service
public class BBSServiceImpl implements BBSService{

	int count; // 총 글의 개수

	ArrayList<BoardVO> articleList;

	@Autowired
	BBSDaoService bbsDao;
	@Autowired
	Page page;

	@Override
	public int login(String id, String pwd) {

		int status = 0;
		try {
			status=bbsDao.login_check(id, pwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}

	@Override
	public ModelAndView list(String pageNum) {

		int pageSize=10; // 한페이지에 보여질 글의 갯수
		int pageBlock=10; // 한페이지에 보여질 링크 갯수

		// 페이지 번호는 request에서 받아오기 때문에 String으로 받았음.

		if(pageNum==null) {
			// list.daejeon 요청이 처음 들어오면 pageNum은 null이기 때문에 기본 1로 초기값 설정 => 1페이지를 보여줌. 
			System.out.println(pageNum);
			pageNum="1";
		}

		try{
			count=bbsDao.getArticleCount();

		} catch(Exception e) {
			e.printStackTrace();
		}

		// 페이지 번호는 String이었으므로 정수로 형변환
		// 페이징 처리를 위해 현재 페이지번호, 총 글의 갯수, 디폴트 페이지사이즈(한 페이지에 보여질 글의 갯수), 디폴트 페이지블록 : 페이지가 몇 개씩 보이는 지 정하는 변수. 
		page.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);

		if (count > 0) {
			try {
				articleList = bbsDao.getArticles(page.getStartRow(), page.getEndRow());

			} catch(Exception e) {
				e.printStackTrace();

			}
		} else {
			articleList = null;
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", articleList);
		mav.addObject("pageNum", pageNum);
		mav.addObject("count", count);
		mav.addObject("pagecode", page.getSb().toString());
		mav.setViewName("list");

		return mav;

	}

	@Override
	public ModelAndView content(int article_Num, String pageNum) {

		BoardVO article = null;

		try{
			article = bbsDao.getArticle(article_Num);

		} catch(Exception e){
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.addObject("pageNum", pageNum);
		mav.setViewName("content");

		return mav;
	}

	@Override
	public ModelAndView writeForm(HttpServletRequest req) {
		HttpSession hs = req.getSession();
		// 로그인 페이지에서 setAttribute()로 키값을 id로 set해줌.
		// id가 있는 경우에는 로그인이 되어 있는 경우 이므로 바로 글쓰기 페이지로 이동
		ModelAndView mav = new ModelAndView();

		if(hs.getAttribute("id") != null) {
			mav.setViewName("writeForm");
			return mav;

		} else {
			// id값이 없는 경우에는 로그인을 한 후에 글을 써야 하므로 로그인 페이지로 이동.
			mav.addObject("writeForm", "ok");
			mav.setViewName("login");
			return mav;
		}
	}

	@Override
	public void write(BoardVO article) {

		try{
			bbsDao.insertArticle(article) ;
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ModelAndView delete(int article_Num, String pageNum) {

		try {
			bbsDao.deleteArticle(article_Num);
		}catch(Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list.daejeon?pageNum="+pageNum);
		return mav;

	}

	@Override
	public ModelAndView updateForm(HttpServletRequest req) {
		
		BoardVO article=null;
		
		int article_Num;

		article_Num = Integer.parseInt(req.getParameter("article_Num"));

		try{
			article = bbsDao.getUpdate(article_Num);
		}catch(Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.addObject("article_Num", article_Num);
		mav.setViewName("updateForm");

		return mav;
	}

	@Override
	public ModelAndView update(HttpServletRequest req) {

		String pageNum = req.getParameter("pageNum");
		int article_Num = Integer.parseInt(req.getParameter("article_Num"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		try{
			bbsDao.updateArticle(article_Num, title, content);
		} catch(Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/content.daejeon?article_Num="+article_Num+"&pageNum="+pageNum);
		return mav;
	}
	
	@Override
	public ModelAndView replyForm(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNum", req.getParameter("pageNum"));
		mav.addObject("position", req.getParameter("position"));
		mav.addObject("group_Id", req.getParameter("group_Id"));
		mav.addObject("depth", req.getParameter("depth"));
		mav.setViewName("replyForm");
		return mav;
		
	}
	
	@Override
	public ModelAndView reply(HttpServletRequest req) {

		BoardVO article = new BoardVO();
		article.setId((String)req.getSession().getAttribute("id"));
		article.setDepth(Integer.parseInt(req.getParameter("depth")));
		article.setPosition(Integer.parseInt(req.getParameter("position")));
		article.setGroup_Id(Integer.parseInt(req.getParameter("group_Id")));
		article.setTitle(req.getParameter("title"));
		article.setContent(req.getParameter("content"));
		
		try{
			bbsDao.replyArticle(article);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list.daejeon");
		return mav;
	}
	

}
