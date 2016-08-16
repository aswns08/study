package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		req.setCharacterEncoding("utf-8");

		BoardVO article = new BoardVO();
		article.setId((String)req.getSession().getAttribute("id"));
		article.setDepth(Integer.parseInt(req.getParameter("depth")));
		article.setPosition(Integer.parseInt(req.getParameter("position")));
		article.setGroup_Id(Integer.parseInt(req.getParameter("group_Id")));
		article.setTitle(req.getParameter("title"));
		article.setContent(req.getParameter("content"));
		
		BBSDao bbsDao = BBSDao.getInstance();
		
		try{
			bbsDao.replyArticle(article);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/list.daejeon";
	}

}
