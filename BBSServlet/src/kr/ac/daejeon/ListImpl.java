package kr.ac.daejeon;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListImpl implements BBSService {

	int count; // 총 글의 개수
	// 
	ArrayList<BoardVO> articleList;
	BBSDao bbsDao;
	
	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		
		System.out.println("서비스 요청 :" +req);
		
		int pageSize=10; // 한페이지에 보여질 글의 갯수
		int pageBlock=10; // 한페이지에 보여질 링크 갯수
		
		// 페이지 번호는 request에서 받아오기 때문에 String으로 받았음.
		String pageNum = req.getParameter("pageNum");
		
		if(pageNum==null) {
			// list.daejeon 요청이 처음 들어오면 pageNum은 null이기 때문에 기본 1로 초기값 설정 => 1페이지를 보여줌. 
			System.out.println(pageNum);
			pageNum="1";
		}
		
		bbsDao = BBSDao.getInstance();
		
		try{
			count=bbsDao.getArticleCount();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 페이지 번호는 String이었으므로 정수로 형변환
		// 페이징 처리를 위해 현재 페이지번호, 총 글의 갯수, 디폴트 페이지사이즈(한 페이지에 보여질 글의 갯수), 디폴트 페이지블록 : 페이지가 몇 개씩 보이는 지 정하는 변수. 
		Page.getInPage().paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		
		if (count > 0) {
			try {
				articleList = bbsDao.getArticles(Page.getInPage().getStartRow(), Page.getInPage().getEndRow());
				
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		} else {
			articleList = null;
		}
		
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("articleList", articleList);
		req.setAttribute("count", count);
		req.setAttribute("pagecode", Page.getInPage().getSb().toString());
		 
		return "/list.jsp";
	}

}
