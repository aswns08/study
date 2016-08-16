package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.Perf.GetPerfAction;

public class UpdateImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		req.setCharacterEncoding("utf-8");
		
		String pageNum = req.getParameter("pageNum");
		int article_Num = Integer.parseInt(req.getParameter("article_Num"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BBSDao bbsDao = BBSDao.getInstance();
		
		try{
			bbsDao.updateArticle(article_Num, title, content);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/content.daejeon?pageNum="+pageNum+"&article_num="+article_Num; 
	}

}
