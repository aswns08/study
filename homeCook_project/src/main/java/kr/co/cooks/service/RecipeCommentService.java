package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.RecipeCommentDao;
import kr.co.cooks.vo.RecipeCommentUserVO;
import kr.co.cooks.vo.RecipeCommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeCommentService {
	@Autowired RecipeCommentDao commentDao ;
	
	public void commentWrite(RecipeCommentVO commentVO) {		
		
		commentDao.commentWrite(commentVO);			
	}
	
	public List<RecipeCommentUserVO> commentRead(int recipe_num, int endRow) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("recipe_num", recipe_num);
		hashMap.put("endRow", endRow);
		
		return commentDao.commentRead(hashMap);
	}
	
	public void commentDelete(int recipe_num, int rcomment_num){
		commentDao.commentDelete(rcomment_num);
	}
	
//	public void recipeAllCommentDelete(int recipe_num) {
//		commentDao.recipeAllCommentDelete(recipe_num);
//	}
}
