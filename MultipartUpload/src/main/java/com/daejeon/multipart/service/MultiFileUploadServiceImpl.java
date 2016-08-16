package com.daejeon.multipart.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.daejeon.multipart.dao.MultiFileUploadDao;
import com.daejeon.multipart.vo.BoardVO;
import com.daejeon.multipart.vo.FileVO;


@Service
public class MultiFileUploadServiceImpl {
	
	@Autowired MultiFileUploadDao mfud;
	
	public void write(MultipartHttpServletRequest mRequest) {
		mfud.write(mRequest.getParameter("content"));
		
		String realFolder="d:/upload/";
		File dir = new File(realFolder);
		
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		List<MultipartFile> mfile = mRequest.getFiles("fname");
		Iterator<MultipartFile> iter = mfile.iterator();
		
		while(iter.hasNext()) {
			MultipartFile uploadFile = iter.next();
			String originFileName = uploadFile.getOriginalFilename();
			String saveFileName = originFileName;
			long fileSize = uploadFile.getSize();
			
			if(!originFileName.isEmpty()) {
				if(new File(realFolder + originFileName).exists()) {
					saveFileName = originFileName + "_" + System.currentTimeMillis();
				}
				FileVO fileVO = new FileVO();
				fileVO.setOriginFileName(originFileName);
				fileVO.setSaveFileName(saveFileName);
				fileVO.setFileSize(fileSize);
				
				mfud.insertFileUpload(fileVO);
				try{
					uploadFile.transferTo(new File(realFolder + saveFileName));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<BoardVO> read() {
		return mfud.read();
	}
	
	public List<FileVO> content(int article_Num) {
		
		return mfud.content(article_Num);
	}
	
	

}
