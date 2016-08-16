package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.cooks.vo.NoticeVO;

public interface NoticeDao {
	public int totalSize() ;
	public List<NoticeVO> getNoticeList(Map<String, Object> paramMap);
	public void noticeWrite(NoticeVO noticeVO);
	public void noticeHit(int no_Num);
	public NoticeVO noticeContent(int no_Num);
	public NoticeVO getNoticeUpdate(int no_Num);
	public void noticeUpdate(NoticeVO noticeVO);
	public void noticeDelete(int no_Num);
}
