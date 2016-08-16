package kr.co.cooks.dao;

import java.util.List;
import java.util.Map;

import kr.co.cooks.vo.ReviewFileListVO;
import kr.co.cooks.vo.ReviewFileVO;
import kr.co.cooks.vo.ReviewVO;

public interface ReviewDao {

	public int totalSize() ;
	public List<?> getReviewList(Map<String, Object> paramMap);
	public List<?> getFoodReviewList(Map<String, Object> paramMap);
	public void insertReview(ReviewVO reviewVO);
	public void insertFileUpload(ReviewFileVO reviewFileVO);
	public ReviewFileListVO contentReview(int re_Num);
	public void deleteReview(int re_Num);
	public void deleteReviewPhoto(int re_Num);
	public ReviewVO getUpdateReviewForm(int re_Num);
	public void updateReview(ReviewVO reviewVO);
	public void updateFileUpload(ReviewFileVO reviewFileVO);
	public void deleteResReviewPhoto(String r_Num);//식당삭제에서 리뷰삭제
	public void deleteResReview(String r_Num);//식당삭제에서 리뷰삭제
	public void deleteFoodReviewPhoto(int f_num);//푸드삭제에서 리뷰삭제
	public void deleteFoodReview(int f_num);//푸드삭제에서 리뷰삭제
	
}
