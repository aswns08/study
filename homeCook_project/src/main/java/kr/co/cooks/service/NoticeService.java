package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.NoticeDao;
import kr.co.cooks.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service
public class NoticeService {
	@Autowired NoticeDao noticeDao;
	NoticeVO noticeVO;
	ModelAndView mav = new ModelAndView();
	
	public int getEndPageNum(int pageSize) {
		
		int totalSize = noticeDao.totalSize();
		int endPageNum = totalSize / pageSize;
		
		if( (totalSize % pageSize) > 0 )
			endPageNum++;
		
		return endPageNum;
	}
	
	public List<?> noticeList(int pageNum, int pageSize){
		
		HashMap<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("startRow", ((pageNum-1) * pageSize +1) );
		paramMap.put("pageSize", pageSize*pageNum);
		
		return noticeDao.getNoticeList(paramMap);
	}
	
	public void noticeWrite(NoticeVO noticeVO){
		noticeDao.noticeWrite(noticeVO);
	}
	
	
	public void noticeHit(int no_Num){
		noticeDao.noticeHit(no_Num);
	}
	
	public NoticeVO noticeContent(int no_Num, NoticeVO noticeVO){
		return noticeDao.noticeContent(no_Num);
	}
	
	public NoticeVO getNoticeUpdate(int no_Num){
		return noticeDao.getNoticeUpdate(no_Num);
	}
	
	public void noticeUpdate(NoticeVO noticeVO){
		noticeDao.noticeUpdate(noticeVO);
	}
	
	public void noticeDelete(int no_Num){
		noticeDao.noticeDelete(no_Num);
	}
}
