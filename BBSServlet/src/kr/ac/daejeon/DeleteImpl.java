package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		int article_Num;
		
		String pageNum = req.getParameter("pageNum");
		
		req.setAttribute("pageNum", pageNum);
		article_Num = (Integer.parseInt(req.getParameter("article_Num")));
		
		BBSDao bbsDao = BBSDao.getInstance();
		
		try {
			bbsDao.deleteArticle(article_Num);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/list.daejeon"+pageNum;
	}

}
