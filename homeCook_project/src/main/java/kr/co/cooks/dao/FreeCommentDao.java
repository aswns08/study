package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.FreeCommentUserVO;
import kr.co.cooks.vo.FreeCommentVO;

public interface FreeCommentDao {

	//코멘트 쓰기
	public void commentWrite(FreeCommentVO commentVO);

	//코멘트 읽어오기
	public List<FreeCommentUserVO> commentRead(HashMap<String, Integer> hashMap) ;

	//코멘트 삭제
	public void commentDelete(int free_num);

}
