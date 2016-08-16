package com.daejeon.bbs.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.daejeon.bbs.dao.BBSDaoService;
import com.daejeon.bbs.vo.BoardVO;

public class BBSServiceImpl implements BBSService{

	int count; // 총 글의 개수

	ArrayList<BoardVO> articleList;

	BBSDaoService bbsDao;
	Page page;

	public void setDao(BBSDaoService bbsDao) {
		this.bbsDao = bbsDao;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public ModelAndView login(HttpServletRequest req) {
		HttpSession hs;

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		int status=0;

		try {
			status=bbsDao.login_check(id, pwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(status==1) {
			// session은 jsp의 내장객체로 getSession을 통해 값을 넣어주면
			// req.validate()메서드를 통해 Session을 끊어주거나
			// req.removeAttribute() 메서드를 통해 Session안에 값을 제거 해준다. 
			hs=req.getSession();
			hs.setAttribute("id", id);

			ModelAndView mav = new ModelAndView();

			if(hs.getAttribute("writeForm")==null) {

				mav.setViewName("redirect:/list.daejeon");
				return mav;
				// 리스트 화면에서 바로 로그인 하는 경우
			} else {

				mav.setViewName("redirect:/write.daejeon");
				return mav;
				// 글쓰기 화면에서 로그인 하는 경우 로그인 후 다시 글쓰기 화면으로 이동.
			}

		} else if(status==2) {
			System.out.println("패스워드가 틀렸습니다.");
			return null;
		} else {
			System.out.println("회원이 아닙니다.");
			return null;
		}
	}

	@Override
	public ModelAndView list(HttpServletRequest req) {

		int pageSize=10; // 한페이지에 보여질 글의 갯수
		int pageBlock=10; // 한페이지에 보여질 링크 갯수

		// 페이지 번호는 request에서 받아오기 때문에 String으로 받았음.
		String pageNum = req.getParameter("pageNum");

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
	public ModelAndView content(HttpServletRequest req) {

		BoardVO article = null;

		try{
			article = bbsDao.getArticle(Integer.parseInt(req.getParameter("article_Num")));

		} catch(Exception e){
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("article", article);
		mav.addObject("pageNum", req.getParameter("pageNum"));
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
	public ModelAndView write(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BoardVO article = new BoardVO();

		article.setId((String)req.getSession().getAttribute("id"));

		//서블릿 3.0 규약에 따르지 않고 바로 파라미터가 읽어짐
		article.setTitle(req.getParameter("title"));
		article.setContent(req.getParameter("content"));

		try{
			bbsDao.insertArticle(article) ;
		}catch(Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list.daejeon");
		return mav;
	}

	@Override
	public ModelAndView delete(HttpServletRequest req) {
		int article_Num;

		String pageNum = req.getParameter("pageNum");

		req.setAttribute("pageNum", pageNum);
		article_Num = (Integer.parseInt(req.getParameter("article_Num")));

		try {
			bbsDao.deleteArticle(article_Num);
		}catch(Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list.daejeon"+pageNum);
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

		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
