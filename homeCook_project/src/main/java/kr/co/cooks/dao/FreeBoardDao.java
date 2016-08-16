package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.FreeBoardUserVO;
import kr.co.cooks.vo.FreeBoardVO;

public interface FreeBoardDao {
	
	//총 글 개수 가져오기
	public int totalSize();
	
	//글 목록 가져오기
	public List<FreeBoardUserVO> freeBoardList(HashMap<String, Object> hashMap);
	
	//글 쓰기	
	public void write(FreeBoardVO freeVO);
	
	//글읽기
	public FreeBoardUserVO content(int free_num);
	
	//댓글 개수 가져오기
	public int getCommentCount(int free_num);
	
	//수정 폼 가져오기
	public FreeBoardUserVO getUpdateFree(int free_num); 

	//글 수정하기
	public void update(FreeBoardVO freeVO);

	//모든 댓글 삭제
	public void freeAllCommentDelete(int free_num);
		
	//글 삭제하기
	public void delete(int free_num);
	
	//조회수
	public void freeHit(int free_num);
	


}
