package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.RecipeCommentUserVO;
import kr.co.cooks.vo.RecipeCommentVO;

public interface RecipeCommentDao {
	//코멘트 쓰기
	public void commentWrite(RecipeCommentVO commentVO) ;
	
	//코멘트 읽어오기
	public List<RecipeCommentUserVO> commentRead(HashMap<String, Integer> hashMap) ;
	
	//코멘트 삭제
	public void commentDelete(int rcomment_num);
}
