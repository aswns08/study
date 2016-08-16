package kr.ac.daejeon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BBSService {
	
	public String service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, Exception;
	
	
}
