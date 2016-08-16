package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteFormImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		HttpSession hs = req.getSession();
		// 로그인 페이지에서 setAttribute()로 키값을 id로 set해줌.
		// id가 있는 경우에는 로그인이 되어 있는 경우 이므로 바로 글쓰기 페이지로 이동
		if(hs.getAttribute("id") != null) {
			return "/writeForm.jsp";
		} else {
			
			// id값이 없는 경우에는 로그인을 한 후에 글을 써야 하므로 로그인 페이지로 이동.
			hs.setAttribute("writeForm", "ok");
			return "/login.jsp";
		}
		 
	}

}
