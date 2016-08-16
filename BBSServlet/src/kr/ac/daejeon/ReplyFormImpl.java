package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyFormImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		req.setAttribute("pageNum", req.getParameter("pageNum"));
		req.setAttribute("position", req.getParameter("position"));
		req.setAttribute("group_Id", req.getParameter("group_Id"));
		req.setAttribute("depth", req.getParameter("depth"));
		
		return "/replyForm.jsp";
	}

}
