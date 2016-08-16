package com.daejeon.multipart.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class DownLoadViewImpl extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String originFileName = (String)model.get("originFileName");
		String real = "d:/upload/";
		File file = new File(real+model.get("saveFileName"));

		res.setContentType("application/download");
		int length = (int)file.length();
		res.setContentLength(length);
		
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
		boolean ie = userAgent.indexOf("MSIE") > -1;
		
		if(ie) {
			originFileName = URLEncoder.encode(file.getName(), "utf-8").replace("+", "%20");
			System.out.println("익스플로러");
		} else {
			originFileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1").replace("+", "%20");
			System.out.println("익스플로러 아닌 브라우저");
		}
		
		res.setHeader("Content-Disposition", "attachment; filename=\""+originFileName+ "\";");
		OutputStream out = res.getOutputStream();
		FileInputStream fis = null;
		
		try{
			int temp;
			fis = new FileInputStream(file);
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
		
	}
		

}
