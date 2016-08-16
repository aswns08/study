package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		BoardVO article = null;
		
		try{
			BBSDao bbsDao = BBSDao.getInstance();
			article = bbsDao.getArticle(Integer.parseInt(req.getParameter("article_Num")));
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		req.setAttribute("article", article);
		req.setAttribute("pageNum", req.getParameter("pageNum"));
		
		return "/content.jsp";
	}

}
