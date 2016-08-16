package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginImpl implements BBSService {
	
	HttpSession hs;
	
	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		System.out.println(req);
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		BBSDao bbsDao= BBSDao.getInstance();
		
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
			
			if(hs.getAttribute("writeForm")==null) {
				return "/list.daejeon";
				// 리스트 화면에서 바로 로그인 하는 경우
			} else {
				return "/writeForm.daejeon";
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

}
