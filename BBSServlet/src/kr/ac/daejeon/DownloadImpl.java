package kr.ac.daejeon;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadImpl implements BBSService {
	
	@Override
	public String service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, Exception {
		String fileName = null;
		String realFolder = "d:/upload/";
		File file = new File(realFolder+req.getParameter("fname"));
		
		res.setContentType("application/download");
		res.setContentLengthLong((int) file.length());
		
		// ie 10번전까지 사용
/*		String userAgent = req.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;
		
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8").replace("+", "%20");
			System.out.println("익스플로러");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1").replace("+", "%20");
			System.out.println("익스플로러 아닌 브라우저");
		}
		*/
		
		// ie 11버전부터 사용가능 = > 완벽한 테스트는 안했음
		String userAgent = req.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("Trident") > -1;
		
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8").replace("+", "%20");
			System.out.println("익스플로러");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1").replace("+", "%20");
			System.out.println("익스플로러 아닌 브라우저");
		}
		
		res.setHeader("Content-Disposition", "attachment; filename=\""+fileName+ "\";");
		OutputStream out = res.getOutputStream();
		FileInputStream fis = null;
		
		try{
			int temp;
			fis = new FileInputStream(realFolder+file.getName());
			while( (temp=fis.read()) !=-1) {
				out.write(temp);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try{
					fis.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return null;
	}

}
