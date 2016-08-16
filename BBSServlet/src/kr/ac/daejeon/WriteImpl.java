package kr.ac.daejeon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class WriteImpl implements BBSService {

	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {

		req.setCharacterEncoding("utf-8");

/*		Enumeration<String> en = req.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName = en.nextElement();
			System.out.println("헤더이름 : "+headerName);
			System.out.println("헤더값 : "+req.getHeader(headerName));
		}*/

		Collection<Part> cp = req.getParts();
		Iterator<Part> it = cp.iterator();
		while(it.hasNext()) {
			Part pa = it.next();
			System.out.println("pa의 값: " +pa);
			System.out.println("pa의 name 값: " +pa.getName());
		}

		BoardVO article = new BoardVO();

		article.setId((String)req.getSession().getAttribute("id"));

		//서블릿 3.0 규약에 따르지 않고 바로 파라미터가 읽어짐
		//article.setTitle(req.getParameter("title"));
		//article.setContent(req.getParameter("content"));

		// 서블릿 3.0 규약을 따른 코드
		article.setTitle(readParameterValue(req.getPart("title")));
		article.setContent(readParameterValue(req.getPart("content")));

		Part filePart = req.getPart("fname");
		String fileName = getFileName(filePart);
		article.setFname(fileName);
		System.out.println(fileName);

		// 파일 업로드가 없으면 파일이 저장 될 디렉토리를 파일로 만늘려고 해서 예외발생

		if(fileName != null && !fileName.equals("")) {
			FileSaveHelper.save(fileName, filePart.getInputStream());
		}

		BBSDao bbsDao = BBSDao.getInstance();
		try{
			bbsDao.insertArticle(article) ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/list.daejeon";

	}

	private String getFileName(Part part) throws UnsupportedEncodingException {
		for(String cd : part.getHeader("Content-Disposition").split(";")) {
			if(cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1)
						.trim().replace("\"", "");
			}
		}
		return null;
	}	

	private String readParameterValue(Part part) throws IOException {
		InputStreamReader reader = new InputStreamReader(part.getInputStream(), "utf-8"); 

		int temp = -1;
		StringBuilder builder = new StringBuilder();

		while( (temp = reader.read()) != -1) {
			builder.append((char)temp);
		}
		return builder.toString();
	}

}
