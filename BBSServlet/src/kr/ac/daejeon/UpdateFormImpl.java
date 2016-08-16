package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormImpl implements BBSService {

	BoardVO article;
	
	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {

		int article_Num;
		
		article_Num = Integer.parseInt(req.getParameter("article_Num"));
		
		BBSDao bbsDao = BBSDao.getInstance();
		
		try{
			article = bbsDao.getUpdate(article_Num);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("article", article);
		req.setAttribute("pageNum", req.getParameter("pageNum"));
		req.setAttribute("article_Num", article_Num);
		
		return "/updateForm.jsp";
	}

}
