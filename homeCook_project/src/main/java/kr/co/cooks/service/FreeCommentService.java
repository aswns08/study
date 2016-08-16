package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.FreeCommentDao;
import kr.co.cooks.vo.FreeCommentUserVO;
import kr.co.cooks.vo.FreeCommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeCommentService {
	@Autowired FreeCommentDao freeDao ;

	public void commentWrite(FreeCommentVO commentVO) {	
		freeDao.commentWrite(commentVO);			
	}

	public List<FreeCommentUserVO> commentRead(int free_num, int endRow) {
		HashMap<String, Integer> hashMap = new HashMap<>();

		hashMap.put("free_num", free_num);
		hashMap.put("endRow", endRow);

		return freeDao.commentRead(hashMap);
	}


	public void commentDelete(int fcomment_num){
		freeDao.commentDelete(fcomment_num);
	}
}
