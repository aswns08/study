package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.FreeBoardDao;
import kr.co.cooks.vo.FreeBoardUserVO;
import kr.co.cooks.vo.FreeBoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreeBoardService {
	@Autowired FreeBoardDao freeDao;
	
public int getEndPageNum(int pageSize) {
		
		int totalSize = freeDao.totalSize();
		int endPageNum = totalSize / pageSize;
		
		if( (totalSize % pageSize) > 0 )
			endPageNum++;
		
		return endPageNum;
	}
	
	public List<?> freeBoardList(int pageNum, int pageSize) {

		HashMap<String, Object> hashMap = new HashMap<>();

		hashMap.put("startRow", ((pageNum-1) * pageSize +1) );
		hashMap.put("pageSize", pageSize*pageNum);

		return freeDao.freeBoardList(hashMap) ;

	}
	
	public void write(FreeBoardVO freeVO) {		
		freeDao.write(freeVO);
	}	
	
	public FreeBoardUserVO content(int free_num) {
		return freeDao.content(free_num);
	}
	
	public int getCommentCount(int free_num) {
		return freeDao.getCommentCount(free_num);
	}
	
	public FreeBoardUserVO getUpdateFree(int free_num) {
		return freeDao.getUpdateFree(free_num);	
	}
	
	public void update(FreeBoardVO freeVO) {
		freeDao.update(freeVO);
	}
	
	@Transactional
	public void delete(int free_num){
		freeDao.freeAllCommentDelete(free_num);		
		freeDao.delete(free_num);		
	}
	
	public void freeHit(int free_num) {
		freeDao.freeHit(free_num);
	}
}
