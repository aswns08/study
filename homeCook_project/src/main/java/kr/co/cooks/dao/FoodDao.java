package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.FoodFileListVO;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodMainFileListVO;
import kr.co.cooks.vo.FoodVO;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.StorageMapVO;

public interface FoodDao {

	//음식 목록 가져오기
	public List<FoodMainFileListMapVO> getArticles(String r_num);

	//음식 상세정보 가져오기 
	public FoodMainFileListMapVO getFoodDetail(int f_num);

	//음식 사진들 가져오기
	public List<FoodFileListVO> getFoodFiles(int f_num) ;
	
	//레스토랑 정보 가져오기
	public RestaurantFileListVO getResInfo(String r_num);	

	//한 레스토랑의 총 음식 개수 가져오기
	public int getFoodCount(String r_num);

	//음식 추가하기
	public void addFood(FoodVO foodVO);

	//메인 사진 추가
	public void addFoodMainFile(FoodMainFileListVO foodMainFileVO);

	//음식 사진들 추가
	public void addFoodFile(FoodFileListVO foodFileVO);

	//음식 삭제
	public void deleteFood(int f_num);
	
	//메인 사진 삭제
	public void deleteFoodMainFile(int f_num);
	
	//메인 사진 삭제
	public void deleteFoodFiles(int f_num);
	
	//구매번호 테이블에 구매내역 추가
	public void addOrderNum(String userId);
	
	//구매 테이블에 구매내역 추가
	public void addOrders(HashMap<String, Object> hashMap);
	
	//마일리지 적립
	public void minusMileage(HashMap<String, Object> mileageMap);
	
	//마일리지 적립
	public void addMileage(HashMap<String, Object> mileageMap);
	
	//매출량 ++
	public void addFoodCount(int f_num);
	
	//최신메뉴 가져오기
	public  List<FoodMainFileListMapVO> getRecentFood();	
	
	//검색된 이름의 음식 갯수
	public int foodSearchCount(String f_name);
	
	//음식 검색했을 때 리스트	
	public List<FoodMainFileListMapVO> foodSearch(String f_name);
	
	//장바구니에 추가
	public void addJang(HashMap<String, Object> hashMap);
	
	//장바구니 보여주기
	public List<StorageMapVO> showJang(String userId);
	
	//장바구니 음식 삭제
	public void deleteJangFood(int s_num);

}
