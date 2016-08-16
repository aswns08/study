package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.RecipeBoardDao;
import kr.co.cooks.vo.RecipeBoardUserVO;
import kr.co.cooks.vo.RecipeBoardVO;
import kr.co.cooks.vo.RecipeCommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RecipeBoardService {
	@Autowired RecipeBoardDao recipeDao;
	
	RecipeBoardVO recipeVO;
	
	List<RecipeBoardUserVO> recipeList;
	List<RecipeCommentVO> recipeCommentList;
	
	public int getEndPageNum(int pageSize) {

		int totalSize = recipeDao.totalSize();
		int endPageNum = totalSize / pageSize;

		if( (totalSize % pageSize) > 0 )
			endPageNum++;

		return endPageNum;
	}
	
	public List<?> recipeBoardList(int pageNum, int pageSize) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
			
		hashMap.put("startRow", ((pageNum-1) * pageSize +1) );
		hashMap.put("pageSize", pageSize*pageNum);

		return recipeDao.recipeBoardList(hashMap) ;
	}
	
	
	public void write(RecipeBoardVO recipeVO) {		
		recipeDao.write(recipeVO);
	}	
	
	public RecipeBoardUserVO content(int recipe_num) {
		return recipeDao.content(recipe_num);	
	}
	
	public RecipeBoardUserVO getUpdateRecipe(int recipe_num) {
		return recipeDao.getUpdateRecipe(recipe_num);	
	}
	
	public void update(RecipeBoardVO recipeVO) {
		recipeDao.update(recipeVO);
	}
	
	@Transactional
	public void delete(int recipe_num){
		recipeDao.likeDelete(recipe_num);			//글에 눌렸던 좋아요 삭제
		recipeDao.recipeAllCommentDelete(recipe_num);	//모든 코멘트 삭제
		recipeDao.delete(recipe_num);				//글 삭제	
	}

	public int getCommentCount(int recipe_num) {
		return recipeDao.getCommentCount(recipe_num);
	}
	
	public int addLike(int recipe_num){
		recipeDao.addLike(recipe_num);
		
		return getRecipeLike(recipe_num);
	}
	
	public int minusLike(int recipe_num){
		recipeDao.minusLike(recipe_num);
		
		return getRecipeLike(recipe_num);
	}
	
	public int getRecipeLike(int recipe_num) {
		return recipeDao.getRecipeLike(recipe_num);
	}
	
	public void addLikePeople(HashMap<String, Object> hashMap) {		
		recipeDao.addLikePeople(hashMap) ;	
	}
	
	public void minusLikePeople(HashMap<String, Object> hashMap) {		
		recipeDao.minusLikePeople(hashMap) ;	
	}
	
	public int checkLikePeople(HashMap<String, Object> hashMap) {		
		return recipeDao.checkLikePeople(hashMap) ;	
	}
	
	public void recipeHit(int recipe_num) {
		recipeDao.recipeHit(recipe_num);
	}
	
	public int recipeAllCommentCount(int recipe_num) {
		return recipeDao.recipeAllCommentCount(recipe_num);
	}

}
