package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.RecipeBoardUserVO;
import kr.co.cooks.vo.RecipeBoardVO;
import kr.co.cooks.vo.RecipeCommentVO;

public interface RecipeBoardDao {
	
	//총 글 개수 가져오기
	public int totalSize();
		
	//글 목록 가져오기
	public List<RecipeBoardUserVO> recipeBoardList(HashMap<String, Object> hashMap);
	
	//글 쓰기	
	public void write(RecipeBoardVO recipeVO);
	
	//글읽기
	public RecipeBoardUserVO content(int recipe_num);
	
	//수정 폼 가져오기
	public RecipeBoardUserVO getUpdateRecipe(int recipe_num); 
	
	//글 수정하기
	public void update(RecipeBoardVO recipeVO);
	
	//글 삭제하기
	public void delete(int recipe_num);
	
	//댓글 개수 가져오기
	public int getCommentCount(int recipe_num) ;
	
	//댓글 리스트 가져오기
	public List<RecipeCommentVO> getCommentArticles(HashMap<String, Integer> rowHashMap);
	
	//좋아요 추가
	public void addLike(int recipe_num);
	
	//좋아요 취소
	public void minusLike(int recipe_num);
	
	//좋아요 수
	public int getRecipeLike(int recipe_num);
	
	//좋아요 사람 추가
	public void addLikePeople(HashMap<String, Object> hashMap);
	
	//좋아요 사람 빼기
	public void minusLikePeople(HashMap<String, Object> hashMap);
	
	//좋아요 누른 사람 체크
	public int checkLikePeople(HashMap<String, Object> hashMap);
	
	//좋아요 모두 삭제
	public void likeDelete(int recipe_num);
	
	//좋아요 수 삭제
	public void deleteLikeCount(int recipe_num);
	
	//조회수 
	public void recipeHit(int recipe_num);
	
	//모든 댓글 삭제
	public void recipeAllCommentDelete(int recipe_num);
	
	//모든 댓글 수
	public int recipeAllCommentCount(int recipe_num);

}
